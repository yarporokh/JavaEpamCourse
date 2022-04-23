package com.advanced.practice5.task9;

import java.util.Random;

public class Member implements Runnable {
    private static int willPlay;
    private int memberNumber;
    private int balance;
    private boolean canPlay;
    private boolean setBet;
    private Lot lot;

    public Member(int memberNumber, int balance) {
        this.memberNumber = memberNumber;
        this.balance = balance;
        this.canPlay = true;
        willPlay++;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void changePlayStatus() {
        canPlay = false;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public boolean isSetBet() {
        return setBet;
    }

    public boolean wantSetBet() {
        Random random = new Random();
        int bet = random.nextInt(4);
        if (bet == 1) {
            setBet = false;
            return false;
        } else
            setBet = true;
        return true;
    }

    public void canSetBet() {
        setBet = true;
    }

    @Override
    public void run() {
        if (canPlay)
            System.out.printf("Member-%d involved in auction, lot-%d\n", memberNumber, lot.getNumber());
        else
            Thread.currentThread().stop();



        while (true) {
            wantSetBet();
            if (!setBet) {

                willPlay--;
                System.out.printf("Member-%d doesn't want continue betting\n", memberNumber);
                Thread.currentThread().stop();
            }
            try {
                lot.addPrice();
                System.out.printf("Member-%d set bet %d to lot-%d\n", memberNumber, lot.getPrice(), lot.getNumber());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (willPlay == 1 && setBet == true) {
                try {
                    for (int i = 1; i <= 3; i++) {
                        Thread.sleep(1000);
                        System.out.printf("%d %d!\n", lot.getPrice(), i);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Member-%d win lot-%d with bet %d\n", memberNumber, lot.getNumber(), lot.getPrice());
                Thread.currentThread().stop();
            }
        }

    }
}