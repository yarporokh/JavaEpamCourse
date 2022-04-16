package com.advanced.practice4;

public class Part1 {
    public static void main(String[] args) {
        new NewThread("NewThread");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new ThreadClass();

    }
}


class NewThread implements Runnable {
    String name;
    Thread t;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, this.name);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name);
                Thread.sleep(333);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Interrupted");
        }
        System.out.println(name + " exiting.");
    }
}

class ThreadClass extends Thread {
    ThreadClass () {
        start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(currentThread().getName());
                Thread.sleep(333);
            }
        } catch (InterruptedException e) {
            System.out.println("ThreadClass Interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " exiting.");
    }
}
