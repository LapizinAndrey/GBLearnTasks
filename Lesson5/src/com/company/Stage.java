package com.company;


/**
 * Created by andrejlapuzin on 28.06.17.
 */
public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
