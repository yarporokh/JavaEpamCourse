package com.advanced.practice6.startegy.cards;

import com.advanced.practice6.startegy.cards.games.BridgeStrategy;
import com.advanced.practice6.startegy.cards.games.FoolStrategy;
import com.advanced.practice6.startegy.cards.games.PokerStrategy;
import com.advanced.practice6.startegy.cards.games.TexasHoldemStrategy;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new TexasHoldemStrategy();
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new PokerStrategy();
    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
        return new BridgeStrategy();
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return new FoolStrategy();
    }

}
