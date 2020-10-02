/**
 * WarVariationTwo
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Represents the second WAR variation game.
 * 	    Simulates the steps/turns needed for two players
 * 	    to play.  Winner is player with the most cards
 * 	    at the end of the game.
 */
package main;

import DeckBuilder.Card;
import DeckBuilder.Deck;

import java.util.ArrayList;

public class WarVariationTwo extends GameVariation {

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

        while(checkForAnyEmptyDeck()){
            roundResult = compareCards();

            if(roundResult == TIE_ID) {
                if(!checkForAnyEmptyDeck())
                    return gameOutput;

                prepareForWAR();
            } else
                 determineRoundWinner(roundResult);
        }
        return gameOutput;
    }

    public boolean checkForAnyEmptyDeck() {
        return !player1.playerHand.checkIfDeckEmpty() &&
                !player2.playerHand.checkIfDeckEmpty();
    }

    public int compareCards() {
        Card player1Card = player1.playTopCard();;
        Card player2Card = player2.playTopCard();;
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);

        gameOutput.append(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() + "\n" );
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
            player1.addPoints(middleDeck);
        }

        if(roundResult == PLAYER_TWO_ID){
            gameOutput.append(player2.getPlayerName() + " Wins the round\n");
            player2.addPoints(middleDeck);
        }

        gameOutput.append(player1.getPlayerName() + " has a score of " + player1.getWinningsPileSize() + "\n");
        gameOutput.append(player2.getPlayerName() + " has a score of " + player2.getWinningsPileSize() + "\n");
        gameOutput.append("\n");
    }

    public void prepareForWAR() {
        gameOutput.append("*** WAR!!! ***\n");
        middleDeck.addCard(player1.playTopCard());
        middleDeck.addCard(player2.playTopCard());
    }

    public String checkWinner() {

        if (player1.getWinningsPileSize() > player2.getWinningsPileSize()){
            return ("Winner is " + player1.getPlayerName() + " Hand: " + player1.getPlayersHandSize() + " Pile: " +
                    player1.getWinningsPileSize());
        }
        else if(player1.getWinningsPileSize() < player2.getWinningsPileSize()) {
            return ("Winner is " + player2.getPlayerName() + " Hand: " + player2.getPlayersHandSize() + " Pile: " +
                    player2.getWinningsPileSize());
        }
        else{
            return ("It's a tie!\n");
        }
    }

    public void clearMiddleDeck() {
        middleDeck.getDeck().clear();
    }
}