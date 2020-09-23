/**
 * WarVariationOne
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Simulates the first WAR variation.  playGame will
 * 	    simulate the turns/rounds that occur during a game
 * 	    of WAR.
 */
package main;

import java.util.ArrayList;

public class WarVariationOne extends GameVariation {

    static final Deck middleDeck = new Deck();
    public static final int PLAYER_ONE_WIN_ROUND = 1;
    public static final int PLAYER_TWO_WIN_ROUND = 2;
    public static final int TIE_ROUND = 0;
    StringBuffer gameOutput = new StringBuffer();

    /**
     * playGame simulates the rounds the players will act
     * in simulating a game of WAR.
     *
     * @param players - Players playing the game.
     *
     * @return gameOutput - Buffer of text containing
     *                      the events of the game.
     */
    public StringBuffer playGame(ArrayList<Player> players) {
        int roundResult;
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        while(!player1.playerHand.checkIfDeckEmpty() && !player2.playerHand.checkIfDeckEmpty() ) {
            roundResult = compareCards(player1, player2);

            if (roundResult == 0) {
                if (player1.playerHand.checkIfDeckEmpty() || player2.playerHand.checkIfDeckEmpty())
                    return gameOutput;

                prepareForWar(player1, player2);
                continue;
            }

            determineWinner(roundResult, player1, player2);
        }
        checkWinner(players);
        return gameOutput;
    }

    private int compareCards(Player player1, Player player2) {
        Card player1Card = player1.playTopCard();
        Card player2Card = player2.playTopCard();
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);

        gameOutput.append(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() + "\n");
        gameOutput.append(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() + "\n");

        if(player1Card.getCardRank() > player2Card.getCardRank())
            return PLAYER_ONE_WIN_ROUND;
        else if(player1Card.getCardRank() < player2Card.getCardRank())
            return PLAYER_TWO_WIN_ROUND;
        else
            return TIE_ROUND;
    }

    private void determineWinner(int roundResult, Player player1, Player player2) {
        if (roundResult == PLAYER_ONE_WIN_ROUND) {
            gameOutput.append(player1.getPlayerName() + " Wins the round\n");
            gameOutput.append("\n");
            player1.collectWinnings(middleDeck);
        }

        if(roundResult == PLAYER_TWO_WIN_ROUND) {
            gameOutput.append(player2.getPlayerName() + " Wins the round\n");
            gameOutput.append("\n");
            player2.collectWinnings(middleDeck);

        }
    }

    private void prepareForWar(Player player1, Player player2) {
        gameOutput.append("*** WAR!!! ***\n");
        middleDeck.addCard(player1.playTopCard());
        middleDeck.addCard(player2.playTopCard());
    }

    public void checkWinner(ArrayList<Player> players) {
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        if (player1.checkForEmptyHand()) {
            gameOutput.append(player2.getPlayerName() + " has won!\n");
        }
        else
            gameOutput.append(player1.getPlayerName() + " has won!\n");
    }


}