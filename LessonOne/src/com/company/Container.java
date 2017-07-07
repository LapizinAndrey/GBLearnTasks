package com.company;

import java.util.ArrayList;

/**
 * Created by andrejlapuzin on 15.06.17.
 */
public class Container<T> {
    void toArrayList(T input[], ArrayList<Object> output) {
        for (T index : input) {
            output.add(index);
        }
    }
}
