package com.company;

/**
 * Created by andrejlapuzin on 25.06.17.
 */
public class MFU {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    void print(int pages) {
        synchronized (lock1) {
            try {
                for (int i = 0; i < pages; i++) {
                    Thread.sleep(50);
                    System.out.println("Отпечатано " + (i + 1) + " страниц");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void scan(int pages) {
        synchronized (lock2) {
            try {
                for (int i = 0; i < pages; i++) {
                    Thread.sleep(50);
                    System.out.println("Отсканировано " + (i + 1) + " страниц");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
