package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by andrejlapuzin on 28.06.17.
 */
public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() {
        return stages;
    }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
