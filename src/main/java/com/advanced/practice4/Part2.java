package com.advanced.practice4;

import java.util.Scanner;

class Spam {
    private Thread[] threads;

    public Spam(String[] messages, int[] time) {
        threads = new Worker[messages.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker(messages[i], time[i]);
        }
    }

    public void start() {
        for (Thread t : threads) {
            t.start();
        }
    }

    public void stop() {
        for (Thread t : threads) {
            t.interrupt();
        }

    }

    private static class Worker extends Thread {
        String message;
        int time;

        Worker(String message, int time) {
            this.message = message;
            this.time = time;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(message);
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                if (!s.isEmpty())
                    stop();
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] messages = new String[]{"@@@", "bbbbbbb"};
        int[] times = new int[]{333, 222};
        Spam spam = new Spam(messages, times);
        spam.start();

    }
}

