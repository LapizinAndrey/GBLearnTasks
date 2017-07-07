package com.company;

/**
 * Created by andrejlapuzin on 16.06.17.
 */
public class Apple implements Fruit {
    private final float weight = 1.0f;

    @Override
    public float getWeight() {
        return this.weight;
    }
}
