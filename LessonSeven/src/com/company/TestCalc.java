package com.company;

/**
 * Created by andrejlapuzin on 05.07.17.
 */
public class TestCalc {

    @BeforeSuite
    public static void testBegin(){
        System.out.println("Тест начался");
    }

    @Test(10)
    public static void SubTest(){
        Calculator calculator = new Calculator();
        if (Assert.assertEquals(5,calculator.sub(10,5))){
            System.out.println("true sub");
        };
    }

    @Test(4)
    public static void divTest(){
        Calculator calculator = new Calculator();
        if(Assert.assertEquals(2,calculator.div(10,5))){
            System.out.println("true div");
        };
    }

    @Test(6)
    public static void multTest(){
        Calculator calculator = new Calculator();
        if(Assert.assertEquals(50,calculator.mult(10,5))){
            System.out.println("true mult");
        }
    }

    @Test(8)
    public static void sumTest(){
        Calculator calculator = new Calculator();
        if (Assert.assertEquals(15,calculator.add(10,5))){
            System.out.println("true sum");
        }
    }

    @AfterSuite
    public static void endOfTest(){
        System.out.println("Тест закончился");
    }
}
