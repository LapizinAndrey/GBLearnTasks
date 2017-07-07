package com.company;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestCalc t = new TestCalc();
        Class tc = t.getClass();
        Assert.start(tc);
    }
}
