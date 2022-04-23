package com.advanced.practice5.task10;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {
    static Stock stock = new Stock();

    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, stock);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new Member(i)).start();
            Thread.sleep(400);
        }
    }

    public static class Stock implements Runnable {
        private int amount;
        private double price;
        private double sold;
        private double bought;

        public Stock() {
            this.price = 50;
            this.amount = 1000;
            this.sold = 1;
            this.bought = 0;
        }

        public synchronized void addSold(int n) {
            sold += n;
        }

        public synchronized void addBought(int n) {
            bought += n;
        }

        public synchronized int getAmount() {
            return amount;
        }

        public double getPrice() {
            return price;
        }

        public void buyAmount(int amount) {
            this.amount -= amount;
        }
        public void sellAmount(int amount) {
            this.amount += amount;
        }

        @Override
        public void run() {
            try {
                price = price * (bought / sold);
                Thread.sleep(500);
                System.out.println("Totally bought: " + bought);
                System.out.println("Totally sold: " + sold);
                System.out.printf("Amount of actions: %d. Stock price: %f\n", amount, price);
                bought = 0;
                sold = 1;
                if (amount == 0)
                    Thread.currentThread().stop();
            } catch (InterruptedException e) {
                Thread.currentThread().stop();
            }
        }
    }

    public static class Member implements Runnable {

        private int memberNumber;
        private int amountOfStocks;
        private Random rand;

        public Member(int memberNumber) {
            this.memberNumber = memberNumber;
            amountOfStocks = 0;
            rand = new Random();
        }

        @Override
        public void run() {
            while (stock.getAmount() != 0) {
                try {
                    if (rand.nextInt(0, 2) == 0) {
                        int tempAmount = rand.nextInt(1, stock.getAmount() + 1);
                        amountOfStocks -= tempAmount;
                        stock.sellAmount(tempAmount);
                        stock.addSold(tempAmount);
                        System.out.printf("Member-%d, sold %d stocks\n", memberNumber, tempAmount);
                    } else {
                        int tempAmount = rand.nextInt(1, stock.getAmount() + 1);
                        amountOfStocks += tempAmount;
                        stock.buyAmount(tempAmount);
                        stock.addBought(tempAmount);
                        System.out.printf("Member-%d, bought %d stocks\n", memberNumber, tempAmount);
                    }

                    BARRIER.await();
                } catch (Exception e) {

                    Thread.currentThread().stop();
                }
            }
            Thread.currentThread().stop();
        }
    }

}
