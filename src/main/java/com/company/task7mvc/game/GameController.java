package com.company.task7mvc.game;

import java.util.Scanner;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;
    Scanner sc = new Scanner(System.in);
    private int userNumber;

    public GameController(GameModel model, GameView gameView) {
        this.gameModel = model;
        this.gameView = gameView;
        model.setMinAndMax(0, 100);
    }


    public void game() {
        gameView.firstMessage();
        while (true) {
            int num = sc.nextInt();
            if (num < gameModel.getMin() || num > gameModel.getMax()) {
                gameView.outOfRange();
            } else {

                gameModel.addValueToHistory(num);
                if (num < gameModel.getRandomNum()) {
                    gameView.higher(gameModel.getHistoryOfNumbers());
                    gameModel.setMinAndMax(num, gameModel.getMax());
                    gameView.showInfo(gameModel.getMin(), gameModel.getMax());

                } else if (num > gameModel.getRandomNum()) {
                    gameView.lower(gameModel.getHistoryOfNumbers());
                    gameModel.setMinAndMax(gameModel.getMin(), num);
                    gameView.showInfo(gameModel.getMin(), gameModel.getMax());

                } else {
                    gameView.finalMessage(num, gameModel.getHistoryOfNumbers());
                    break;
                }
            }
        }
    }
}
