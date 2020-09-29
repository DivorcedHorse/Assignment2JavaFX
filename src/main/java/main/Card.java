/**
 * Card
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Domain model that represents a playing card.
 */
package main;

public class Card {
    String cardSuit;
    String cardName;
    int cardRank;

    public Card(String cardSuit, String cardName, int cardRank){
        this.cardSuit = cardSuit;
        this.cardName = cardName;
        this.cardRank = cardRank;
    }

    // GETTERS AND SETTERS
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
