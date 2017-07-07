package com.company;

import java.util.concurrent.Semaphore;

/**
 * Created by andrejlapuzin on 28.06.17.
 */
public class Tunnel extends Stage {

    Semaphore smphr = new Semaphore((Main.CARS_COUNT)/2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smphr.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smphr.release();
            }
    }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
