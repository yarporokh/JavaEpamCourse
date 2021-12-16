package com.company.task7mvc.game;

import java.util.ArrayList;
import java.util.Random;

public class GameModel {
    private int min;
    private int max;
    private int randomNum = rand(0, 100);
    private ArrayList<Integer> historyOfNumbers = new ArrayList<>();


    public void setMinAndMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getRandomNum(){
        return randomNum;
    }
    public void addValueToHistory(int n) {
        historyOfNumbers.add(n);
    }

    private int rand(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public ArrayList<Integer> getHistoryOfNumbers(){
        return historyOfNumbers;
    }
}
