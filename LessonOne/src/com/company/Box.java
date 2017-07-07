package com.company;

import java.util.ArrayList;

/**
 * Created by andrejlapuzin on 16.06.17.
 */
public class Box <T extends Fruit>{;

    ArrayList<T> fruits = new ArrayList<>();
    void add(T fruit){
        fruits.add(fruit);
    }

    float getWeight(){
        float weight = 0;
        for (T fruit:this.fruits) {
            weight+=fruit.getWeight();
        }
        return weight;
    }

    void move(Box <T> anotherBox){
        for (T fruit:this.fruits) {
            anotherBox.fruits.add(fruit);
        }
        fruits.clear();
    }

    boolean compare(Box anotherBox){
        if(this.getWeight()==anotherBox.getWeight()){
            return true;
        }
        else return false;
    }
}
