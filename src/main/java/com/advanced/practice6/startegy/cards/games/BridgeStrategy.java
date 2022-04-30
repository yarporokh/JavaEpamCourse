package com.advanced.practice6.startegy.cards.games;

import com.advanced.practice6.startegy.cards.Card;
import com.advanced.practice6.startegy.cards.CardDealingStrategy;
import com.advanced.practice6.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeStrategy implements CardDealingStrategy {
    private final int CARDSFORPLAYER = 13;

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> stacks = new HashMap<>();

        for (int i = 1; i < players + 1; i++) {
            stacks.put("Player " + i, new ArrayList<>());
        }


        for (int i = 0; i < CARDSFORPLAYER; i++) {
            for (int j = 1; j < players + 1; j++) {
                stacks.get("Player " + j).add(deck.dealCard());
            }
        }


        return stacks;
    }
}
