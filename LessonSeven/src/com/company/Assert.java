package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by andrejlapuzin on 05.07.17.
 */
public class Assert {
    private static int counter = 0;
    public static void start(Class t) throws InvocationTargetException, IllegalAccessException {
        Method methods[] = t.getDeclaredMethods();
        runBeforeSuite(methods,counter);
        runTest(methods);
        runAfterSuite(methods,counter);
    }

    public static boolean assertEquals(double expected,double result){
        if (result==expected){return true;}
        else return false;
    }
    private static void runBeforeSuite(Method[]methods,int counter) throws InvocationTargetException, IllegalAccessException {
        for (Method m:methods){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                counter++;
                if (counter>1){
                    throw new RuntimeException();
                }
                m.invoke(null);
            }
        }
    }
    private static void runTest(Method[]methods) throws InvocationTargetException, IllegalAccessException {
        for (int i = 1; i <= 10; i++) {
            for (Method m:methods) {
                if(!m.isAnnotationPresent(Test.class)){continue;}
                if (m.getDeclaredAnnotation(Test.class).value() == i){
                    m.invoke(null);}
            }
        }
    }
    private static void runAfterSuite(Method[] methods, int counter) throws InvocationTargetException, IllegalAccessException {
        for (Method m:methods) {
            if(!m.isAnnotationPresent(AfterSuite.class)){continue;}
            counter++;
            if (counter>1){throw new RuntimeException();}
            m.invoke(null);}
    }
}
