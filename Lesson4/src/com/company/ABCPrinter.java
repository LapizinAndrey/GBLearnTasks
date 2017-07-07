package com.company;

/**
 * Created by andrejlapuzin on 25.06.17.
 */
public class ABCPrinter {
    private volatile char currentLetter = 'A';

    ABCPrinter() {
        Thread t1 = new Thread(() -> printA());
        Thread t2 = new Thread(() -> printB());
        Thread t3 = new Thread(() -> printC());
        t1.start();
        t2.start();
        t3.start();
    }

    void printA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        this.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'B';
                    this.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void printB() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        this.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'C';
                    this.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void printC() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        this.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'A';
                    this.notifyAll();
                }
                System.out.printf("\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
