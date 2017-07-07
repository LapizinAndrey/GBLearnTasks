package com.company;

import java.util.ArrayList;

/**
 * Created by andrejlapuzin on 14.06.17.
 */
public class Persons <T> {
    T name;

    public Persons(T name) {
        this.name = name;
    }

    T getName(){
        return this.name;
    }
}
