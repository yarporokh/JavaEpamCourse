package com.advanced.practice5.task11;

import java.util.concurrent.CyclicBarrier;

public class Main {
    static Plane plane = new Plane(20);
    private static final CyclicBarrier BARRIER = new CyclicBarrier(plane.places, plane);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new Passenger(i)).start();
            Thread.sleep(400);
        }
    }

    public static class Plane implements Runnable {
        private int places;
        private String departure = "A";
        private String destination = "B";

        public Plane(int places) {
            this.places = places;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.printf("Plane take off from Airport-%s and land in Airport-%s\n", departure, destination);
                String temp = departure;
                departure = destination;
                destination = temp;
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Passenger implements Runnable {
        private int passengerNumber;

        public Passenger(int carNumber) {
            this.passengerNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Passenger №%d get in plane.\n", passengerNumber);
                BARRIER.await();
                System.out.printf("Passenger №%d get out from plane.\n", passengerNumber);
            } catch (Exception e) {
            }
        }
    }

}
