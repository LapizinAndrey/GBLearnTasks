import java.sql.*;
import java.util.Scanner;

/**
 * Created by andrejlapuzin on 18.06.17.
 */

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement ps;
    static String command;
    static String comm[];

    public static void main(String args[]) {
        boolean i = 2.0 == 2;
        System.out.println(i);
        connect();
        start();
        getCommand();
        disconnect();
    }

    public static void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Shop.db");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void start(){
        try {
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Product (\n" +
                    "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t`prodId`\tTEXT NOT NULL,\n" +
                    "\t`Title`\tTEXT NOT NULL,\n" +
                    "\t`Cost`\tINTEGER NOT NULL\n" +
                    ");");
            ps = connection.prepareStatement("INSERT INTO Product (prodId,Title,Cost) VALUES (?,?,?)");
            stmt.execute("DELETE From Product");
            for (int i = 1; i <= 10000; i++) {
                ps.setString(1, "id_товара " + i);
                ps.setString(2, "товар" + i);
                ps.setDouble(3, i * 10);
                ps.executeUpdate();
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getCommand(){
        System.out.println("Введите команду");
        Scanner sc = new Scanner(System.in);
        command = sc.nextLine();
        comm = command.split(" ");
        if(comm[0].equalsIgnoreCase("/цена")){
            System.out.println(cost(comm[1]));
        }
        if (comm[0].equalsIgnoreCase("/сменитьцену")){
            changePrice(comm[1],comm[2]);
        }
        if (comm[0].equalsIgnoreCase("/товарыпоцене")){
            productsByPrice(comm[1],comm[2]);
        }
    }

    public static double cost(String s) {
        Double result = null;
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM 'Product' WHERE Title = '"+s+"'");
            result = rs.getDouble(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == null){
            System.out.println("такого товара нет");
        }
        return result;
    }

    public static void changePrice(String prod, String Price){
        try {
            int t = stmt.executeUpdate("UPDATE Product Set Cost = "+Price+" Where Title = '"+prod+"'");
            if (t==0){
                System.out.println("такого товара нет");
            }
            else System.out.println(t + "строк было изменено");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void productsByPrice(String min,String max){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM 'Product' WHERE COST > "+min +" AND COST < "+max);
            while (rs.next()){
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
