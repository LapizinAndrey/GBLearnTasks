package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ABCPrinter abcPrinter = new ABCPrinter();
        Thread t1 = new Thread(()->printInFile("Thread1"));
        Thread t2 = new Thread(()->printInFile("Thread2"));
        Thread t3 = new Thread(()->printInFile("Thread3"));

        t1.start();
        t2.start();
        t3.start();

        MFU();
    }

    static void MFU(){
        MFU mfu = new MFU();
        Thread t1 = new Thread(()->mfu.print(10));
        Thread t2 = new Thread(()->mfu.scan(10));
        t1.start();
        t2.start();
    }
     synchronized static void printInFile(String thread) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("test.txt",true));
            for (int i = 0; i < 100; i += 10) {
                bw.write(thread + ": " + i + ", ");

            }
            bw.write("\n");
        }
            catch (IOException e) {
                e.printStackTrace();
        }
        finally {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
