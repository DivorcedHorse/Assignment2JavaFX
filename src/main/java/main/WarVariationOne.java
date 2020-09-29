/**
 * WarVariationOne
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Represents the first WAR variation game.
 * 	    Simulates the steps/turns needed for two players
 * 	    to play until one runs out of cards.
 */
package main;

import java.util.ArrayList;

public class WarVariationOne extends GameVariation {

    static final Deck middleDeck = new Deck();
    StringBuffer gameOutput = new StringBuffer();
    public static final int PLAYER_ONE_ID = 0;
    public static final int PLAYER_TWO_ID = 1;
    public static final int TIE_ID = 2;
    Player player1;
    Player player2;

    public StringBuffer playGame(ArrayList<Player> players) {
        int roundResult;
        player1 = players.get(PLAYER_ONE_ID);
        player2 = players.get(PLAYER_TWO_ID);

        //gameOutput.append("Starting cards D = " + player1.getPlayersHandSize() + " H = " + player2.getPlayersHandSize() + "\n");
        while(checkForAnyEmptyDeck()){
            roundResult = compareCards();

            if(roundResult == TIE_ID) {
                if (player1.playerHand.checkIfDeckEmpty() || player2.playerHand.checkIfDeckEmpty())
                    return gameOutput;

                prepareForWAR();
            } else
                determineRoundWinner(roundResult);
        }
        return gameOutput;
    }

    public boolean checkForAnyEmptyDeck() {
        return !player1.playerHand.checkIfDeckEmpty()
                && !player2.playerHand.checkIfDeckEmpty();
    }

    public int compareCards() {
        Card player1Card = player1.playTopCard();
        Card player2Card = player2.playTopCard();
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);

        gameOutput.append(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() + "\n");
        gameOutput.append(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() + "\n");

        if(player1Card.getCardRank() > player2Card.getCardRank()){
            return PLAYER_ONE_ID;
        }
        else if(player1Card.getCardRank() < player2Card.getCardRank()){
            return PLAYER_TWO_ID;
        }
        else {
            return TIE_ID;
        }
    }

    public void determineRoundWinner(int roundResult) {
        if (roundResult == PLAYER_ONE_ID){
            gameOutput.append(player1.getPlayerName() + " Wins the round\n");
            player1.collectWinnings(middleDeck);
        }

        if(roundResult == PLAYER_TWO_ID){
            gameOutput.append(player2.getPlayerName() + " Wins the round\n");
            player2.collectWinnings(middleDeck);
        }
        gameOutput.append("D = " + player1.getPlayerHand().getDeckSize() + " .... H = " + player2.getPlayerHand().getDeckSize() + "\n");

        gameOutput.append("\n");
    }

    public void prepareForWAR() {
        gameOutput.append("*** WAR!!! ***\n");
        middleDeck.addCard(player1.playTopCard());
        middleDeck.addCard(player2.playTopCard());
    }

    public String checkWinner() {
        if (player1.checkForEmptyHand()) {
            return (player2.getPlayerName() + " has won!\n");
        }
        else
            return (player1.getPlayerName() + " has won!\n");
    }

    /**
     * Clears the middle deck after a game has
     * ended.
     */
    public void clearMiddleDeck() {
        middleDeck.getDeck().clear();
    }
}