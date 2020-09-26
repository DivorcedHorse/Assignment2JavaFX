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
    StringBuffer gameOutput = new StringBuffer();

    public StringBuffer playGame(ArrayList<Player> players) {
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);
        int roundResult;

        while (checkForAnyEmptyDeck(player1, player2, player3)) {
            roundResult = compareCards(player1, player2, player3);

            if (roundResult == 0) {
                if (!checkForAnyEmptyDeck(player1, player2, player3))
                    return gameOutput;

                prepareForWar(player1, player2, player3);
                continue;
            }
            determineWinner(player1, player2, player3, roundResult);
        }
        return gameOutput;
    }


    private boolean checkForAnyEmptyDeck(Player player1, Player player2, Player player3) {
        return !player1.playerHand.checkIfDeckEmpty() && !player2.playerHand.checkIfDeckEmpty() &&
                !player3.playerHand.checkIfDeckEmpty();
    }

    private int compareCards(Player player1, Player player2, Player player3) {
        Card player1Card;
        Card player2Card;
        Card player3Card;
        player1Card = player1.playTopCard();
        player2Card = player2.playTopCard();
        player3Card = player3.playTopCard();

        addCardsToMiddleDeck(player1Card, player2Card, player3Card);
        appendPlayedCards(player1, player2, player3, player1Card, player2Card, player3Card);

        if(player1Card.getCardRank() > player2Card.getCardRank() && player1Card.getCardRank() > player3Card.getCardRank())
            return 1;
        else if(player1Card.getCardRank() < player2Card.getCardRank() && player3Card.getCardRank() < player2Card.getCardRank())
            return 2;
        else if (player1Card.getCardRank() < player3Card.getCardRank() && player2Card.getCardRank() < player3Card.getCardRank())
            return 3;
        else
            return 0;
    }

    private void prepareForWar(Player player1, Player player2, Player player3) {
        gameOutput.append("*** WAR!!! ***\n");
        addCardsToMiddleDeck(player1.playTopCard(), player2.playTopCard(), player3.playTopCard());
    }

    private void addCardsToMiddleDeck(Card player1Card, Card player2Card, Card player3Card) {
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);
        middleDeck.addCard(player3Card);
    }

    private void determineWinner(Player player1, Player player2, Player player3, int roundResult) {
        if (roundResult == 1){
            gameOutput.append(player1.getPlayerName() + " Wins the round \n");
            player1.addPoints(middleDeck);
        }

        if(roundResult == 2){
            gameOutput.append(player2.getPlayerName() + " Wins the round\n");
            player2.addPoints(middleDeck);
        }

        if (roundResult == 3) {
            gameOutput.append(player3.getPlayerName() + " Wins the round\n");
            player3.addPoints(middleDeck);
        }

        gameOutput.append("Daniel has " + player1.getWinningsPileSize() + " points\n");
        gameOutput.append("HAO has " + player2.getWinningsPileSize() + " points\n");
        gameOutput.append("Rob has " + player3.getWinningsPileSize() + " points\n");
        gameOutput.append("\n");
    }

    private void appendPlayedCards(Player player1, Player player2, Player player3, Card player1Card, Card player2Card, Card player3Card) {
        gameOutput.append(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() + "\n");
        gameOutput.append(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() + "\n");
        gameOutput.append(player3.getPlayerName() + " plays " + player3Card.getCardName() + " of " + player3Card.getCardSuit() + "\n");
    }


    public String checkWinner() {
        ArrayList<Player> winners = new ArrayList<>();
        winners = comparePlayerPoints(winners);

        String winnersOutput = "WINNERS: \n";
        for (int i = 0; i < winners.size(); i++) {
            winnersOutput += ("Winner is " + winners.get(i).getPlayerName() + " Hand: " +
                    winners.get(i).getPlayersHandSize() + " Pile: " +
                    winners.get(i).getWinningsPileSize() + "\n");
        }
        return winnersOutput;
    }

    private ArrayList<Player> comparePlayerPoints(ArrayList<Player> winners) {
        winners.add(listOfPlayers.get(0));
        Player tmpHighestPlayer = listOfPlayers.get(0);
        Boolean tiePlayers = false;

        for (int i = 1; i < 3; i++) {
            if (listOfPlayers.get(i).getWinningsPileSize() >= tmpHighestPlayer.getWinningsPileSize()) {
                if (listOfPlayers.get(i).getWinningsPileSize() == tmpHighestPlayer.getWinningsPileSize()) {
                    winners.add(listOfPlayers.get(i));
                    tiePlayers = true;
                    continue;
                }
                if (tiePlayers)
                    winners.clear();
                else {
                    winners.remove(0);
                    tmpHighestPlayer = listOfPlayers.get(i);
                }
                winners.add(listOfPlayers.get(i));
            }
        }
        return winners;
    }
}