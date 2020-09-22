package main;

public class Player {
    String playerName;
    Deck playerHand;
    Deck playerPoints = new Deck();

    public Player(String name, Deck deck) {
        this.playerName = name;
        this.playerHand = deck;
    }

    public void showMyCards() {
        System.out.printf("%s's Hand: \n", playerName);
        while (!playerHand.checkIfDeckEmpty()) {
            Card tmp = playerHand.getTopCard();
            System.out.printf("%s %s\n", tmp.getCardSuit(), tmp.getCardName());
        }
    }

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

    public void addPoints(Deck winningDeck){
        while (!winningDeck.checkIfDeckEmpty()){
            playerPoints.addCard(winningDeck.getTopCard());
        }

    }




    public Card playTopCard() {
        return playerHand.getTopCard();
    }

    public boolean checkForEmptyHand() {
        return playerHand.checkIfDeckEmpty();
    }

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

    public Deck getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(Deck playerPoints) {
        this.playerPoints = playerPoints;
    }

}
