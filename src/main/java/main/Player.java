/**
 * Player
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Domain model that represents a person playing the WAR variations.
 * 	    Player will keep track of their own hands and points pile.
 */
package main;

public class Player {
    String playerName;
    Deck playerHand;
    Deck winningsPile = new Deck();

    public Player(String name, Deck deck) {
        this.playerName = name;
        this.playerHand = deck;
    }

    /**
     * Adds current played round cards to players hands
     *
     * @param winningDeck - Cards played in round
     */
    public void collectWinnings(Deck winningDeck) {
        Deck tmp = new Deck();

        // empty out current players hand
        while (!playerHand.checkIfDeckEmpty()) {
            tmp.addCard(playerHand.getTopCard());
        }

        // add winning hand into players hand
        while (!winningDeck.checkIfDeckEmpty()) {
            playerHand.addCard(winningDeck.getTopCard());
        }

        // reverse the tmp deck to maintain original order
        while (!tmp.checkIfDeckEmpty()) {
            winningDeck.addCard(tmp.getTopCard());
        }

        // now can add the cards back into players hand
        while (!winningDeck.checkIfDeckEmpty()) {
            playerHand.addCard(winningDeck.getTopCard());
        }
    }

    /**
     * Adds cards to winningsPile
     *
     * @param winningDeck - Cards played in round
     */
    public void addPoints(Deck winningDeck){
        while (!winningDeck.checkIfDeckEmpty())
            winningsPile.addCard(winningDeck.getTopCard());
    }

    /**
     * Player plays top card from players hand
     *
     * @return Card - Top card from players deck
     */
    public Card playTopCard() {
        return playerHand.getTopCard();
    }

    /**
     * Checks if players hands is empty
     *
     * @return Boolean - True if empty, false otherwise
     */
    public boolean checkForEmptyHand() {
        return playerHand.checkIfDeckEmpty();
    }

    // GETTERS AND SETTERS
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Deck getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Deck playerHand) {
        this.playerHand = playerHand;
    }

    public Deck getWinningsPile() {
        return winningsPile;
    }

    public void setWinningsPile(Deck winningsPile) {
        this.winningsPile = winningsPile;
    }

}
