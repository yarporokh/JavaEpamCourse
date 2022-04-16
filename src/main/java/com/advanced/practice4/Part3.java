package com.advanced.practice4;

public class Part3 {
    private int counter;
    private int counter2;
    private int number;

    public Part3(int number) {
        this.number = number;
    }

    public void compare() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void compareSync() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSync();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSync();
            }
        });

        t.start();
        t2.start();
    }

    public void increment() {
        for (int i = 0; i < number; i++) {
            System.out.print("counter is equal counter2:");
            System.out.println(counter == counter2);
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter2++;
        }
    }

    public synchronized void incrementSync() {
        increment();
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3(5);
        System.out.println("Compare: ");
        part3.compare();
        System.out.println("CompareSync: ");
        part3.compareSync();
    }


}
