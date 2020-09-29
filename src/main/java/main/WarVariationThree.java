/**
 * WarVariationThree
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Represents the third WAR variation game.
 * 	    Simulates the steps/turns needed for three players
 * 	    to play.  Winner is player with the most cards
 * 	    at the end of the game.
 */
package main;

import java.util.ArrayList;

public class WarVariationThree extends GameVariation {

    static final Deck middleDeck = new Deck();
    public static final int PLAYER_ONE_ID = 0;
    public static final int PLAYER_TWO_ID = 1;
    public static final int PLAYER_THREE_ID = 2;
    public static final int TIE_ID = 3;
    StringBuffer gameOutput = new StringBuffer();
    Player player1;
    Player player2;
    Player player3;

    public StringBuffer playGame(ArrayList<Player> players) {
        player1 = players.get(PLAYER_ONE_ID);
        player2 = players.get(PLAYER_TWO_ID);
        player3 = players.get(PLAYER_THREE_ID);
        int roundResult;

        while (checkForAnyEmptyDeck()) {
            roundResult = compareCards();

            if (roundResult == TIE_ID) {
                if (!checkForAnyEmptyDeck())
                    return gameOutput;

                prepareForWAR();
            } else
                determineRoundWinner(roundResult);
        }
        return gameOutput;
    }


    public boolean checkForAnyEmptyDeck() {
        return !player1.playerHand.checkIfDeckEmpty() && !player2.playerHand.checkIfDeckEmpty() &&
                !player3.playerHand.checkIfDeckEmpty();
    }

    public int compareCards() {
        Card player1Card = player1.playTopCard();
        Card player2Card = player2.playTopCard();
        Card player3Card = player3.playTopCard();

        addCardsToMiddleDeck(player1Card, player2Card, player3Card);
        appendPlayedCards(player1Card, player2Card, player3Card);

        if(player1Card.getCardRank() > player2Card.getCardRank() && player1Card.getCardRank() > player3Card.getCardRank())
            return PLAYER_ONE_ID;
        else if(player1Card.getCardRank() < player2Card.getCardRank() && player3Card.getCardRank() < player2Card.getCardRank())
            return PLAYER_TWO_ID;
        else if (player1Card.getCardRank() < player3Card.getCardRank() && player2Card.getCardRank() < player3Card.getCardRank())
            return PLAYER_THREE_ID;
        else
            return TIE_ID;
    }

    public void determineRoundWinner(int roundResult) {
        if (roundResult == PLAYER_ONE_ID){
            gameOutput.append(player1.getPlayerName() + " Wins the round \n");
            player1.addPoints(middleDeck);
        }

        if(roundResult == PLAYER_TWO_ID){
            gameOutput.append(player2.getPlayerName() + " Wins the round\n");
            player2.addPoints(middleDeck);
        }

        if (roundResult == PLAYER_THREE_ID) {
            gameOutput.append(player3.getPlayerName() + " Wins the round\n");
            player3.addPoints(middleDeck);
        }

        gameOutput.append("Daniel has " + player1.getWinningsPileSize() + " points\n");
        gameOutput.append("HAO has " + player2.getWinningsPileSize() + " points\n");
        gameOutput.append("Rob has " + player3.getWinningsPileSize() + " points\n");
        gameOutput.append("\n");
    }

    public void prepareForWAR() {
        gameOutput.append("*** WAR!!! ***\n");
        addCardsToMiddleDeck(player1.playTopCard(), player2.playTopCard(), player3.playTopCard());
    }

    private void addCardsToMiddleDeck(Card player1Card, Card player2Card, Card player3Card) {
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);
        middleDeck.addCard(player3Card);
    }

    private void appendPlayedCards(Card player1Card, Card player2Card, Card player3Card) {
        gameOutput.append(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() + "\n");
        gameOutput.append(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() + "\n");
        gameOutput.append(player3.getPlayerName() + " plays " + player3Card.getCardName() + " of " + player3Card.getCardSuit() + "\n");
    }

    public String checkWinner() {
        ArrayList<Player> gameWinners = new ArrayList<>();
        gameWinners = comparePlayerPoints();

        String winnersOutput = "WINNERS: \n";

        for (int i = 0; i < gameWinners.size(); i++) {
            winnersOutput += ("Winner is " + gameWinners.get(i).getPlayerName() + " Hand: " +
                    gameWinners.get(i).getPlayersHandSize() + " Pile: " +
                    gameWinners.get(i).getWinningsPileSize() + "\n");
        }
        return winnersOutput;
    }

    private ArrayList<Player> comparePlayerPoints() {
        ArrayList<Player> winners = new ArrayList<>();
        winners.add(listOfPlayers.get(PLAYER_ONE_ID));
        Player tmpHighestPlayer = listOfPlayers.get(PLAYER_ONE_ID);

        for (int i = 1; i < listOfPlayers.size(); i++) {
            if (listOfPlayers.get(i).getWinningsPileSize() == tmpHighestPlayer.getWinningsPileSize())
                winners.add(listOfPlayers.get(i));
            if (listOfPlayers.get(i).getWinningsPileSize() > tmpHighestPlayer.getWinningsPileSize()) {
                winners.clear();
                winners.add(listOfPlayers.get(i));
                tmpHighestPlayer = listOfPlayers.get(i);
            }
        }
        return winners;
    }
}