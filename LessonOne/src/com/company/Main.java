package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Persons persons[] = new Persons[5];
        ArrayList<Object> names = new ArrayList<>();

        Persons<String> personOne = new Persons("Bob");
        Persons<String> personTwo = new Persons("Patrick");
        Persons<String> personThree = new Persons("Larry");
        Persons<String> personFour = new Persons("Garry");
        Persons<Integer> personFive = new Persons(1654534);

        persons[0] = personOne;
        persons[1] = personTwo;
        persons[2] = personThree;
        persons[3] = personFour;
        persons[4] = personFive;

        showPersonsNames(persons);
        swap(0,4,persons);
        showPersonsNames(persons);

        Container<Persons> container = new Container();
        container.toArrayList(persons,names);

        Box <Apple> appleBox = new Box();
        Box <Orange> orangeBox = new Box();
        Box <Apple> anotherBox = new Box();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        appleBox.move(anotherBox);
        System.out.println(anotherBox.compare(orangeBox));
    }

    static void showPersonsNames(Persons[] persons){
        for (Persons index:persons) {
            System.out.println(index.getName());
        }
    }

    static void swap(int index, int indexTwo, Persons[] persons){
        try {
            Persons<Object>tmp;
            tmp = persons [indexTwo];
            persons[indexTwo] = persons[index];
            persons[index] = tmp;
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
