package main;

import java.util.*;

public class Card {
    String cardSuit;
    String cardName;
    int cardRank;


    public Card(String cardRanking, String cardName, int cardValue){
        this.cardSuit = cardRanking;
        this.cardName = cardName;
        this.cardRank = cardValue;
    }

    // Getter and setters
    public String getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public int getCardRank() {
        return cardRank;
    }

    public void setCardRank(int cardRank) {
        this.cardRank = cardRank;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

}
