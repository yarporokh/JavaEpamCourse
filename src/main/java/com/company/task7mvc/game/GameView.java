package com.company.task7mvc.game;

import java.util.ArrayList;

public class GameView {
    public void firstMessage() {
        System.out.println("Enter the numbers to guess a random number min 0, max 100");
    }

    public void outOfRange() {
        System.out.println("You number is out of range");
    }

    public void higher(ArrayList <Integer> historyOfNumbers) {
        System.out.println(historyOfNumbers);
        System.out.println("Your number must be higher");
    }

    public void lower(ArrayList <Integer> historyOfNumbers) {
        System.out.println(historyOfNumbers);
        System.out.println("Your number must be lower");
    }

    public void finalMessage(int num, ArrayList <Integer> historyOfNumbers){
        System.out.println(historyOfNumbers);
        System.out.printf("You win! The correct number is %d", num);
    }

    public void showInfo(int min, int max) {
        System.out.printf("The random number is between %d and  %d \n", min, max);
    }
}
