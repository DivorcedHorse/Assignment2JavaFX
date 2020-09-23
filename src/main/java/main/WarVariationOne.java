package main;

import java.util.ArrayList;

public class WarVariationOne extends GameVariation {

    static final Deck middleDeck = new Deck();
    StringBuffer gameOutput = new StringBuffer();

    public StringBuffer playGame(ArrayList<Player> players) {
        int roundResult;
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        while(!player1.playerHand.checkIfDeckEmpty() && !player2.playerHand.checkIfDeckEmpty() ){
            roundResult = compareCards(player1, player2);

            if(roundResult == 0) {
                if(player1.playerHand.checkIfDeckEmpty() || player2.playerHand.checkIfDeckEmpty())
                    return gameOutput;

                prepareForWar(player1, player2);
                continue;
            }
            determineWinner(roundResult, player1, player2);
        }
        return gameOutput;
    }

    private void determineWinner(int roundResult, Player player1, Player player2) {
        if (roundResult == 1){
            gameOutput.append(player1.getPlayerName() + " Wins the round\n");
            player1.collectWinnings(middleDeck);
        }

        if(roundResult == 2){
            gameOutput.append(player2.getPlayerName() + " Wins the round\n");
            player2.collectWinnings(middleDeck);
        }
        gameOutput.append("D = " + player1.getPlayerHand().getDeckSize() + " .... H = " + player2.getPlayerHand().getDeckSize() + "\n");

        gameOutput.append("\n");
    }

    private void prepareForWar(Player player1, Player player2) {
        gameOutput.append("*** WAR!!! ***\n");
        middleDeck.addCard(player1.playTopCard());
        middleDeck.addCard(player2.playTopCard());
    }

    private int compareCards(Player player1, Player player2) {
        Card player1Card = player1.playTopCard();
        Card player2Card = player2.playTopCard();
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);

        gameOutput.append(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() + "\n");
        gameOutput.append(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() + "\n");

        if(player1Card.getCardRank() > player2Card.getCardRank()){
            return 1;
        }
        else if(player1Card.getCardRank() < player2Card.getCardRank()){
            return 2;
        }
        else {
            return 0;
        }
    }

    public String checkWinner() {
        Player player1 = listOfPlayers.get(0);
        Player player2 = listOfPlayers.get(1);

        if (player1.checkForEmptyHand()) {
            return (player2.getPlayerName() + " has won!\n");
        }
        else
            return (player1.getPlayerName() + " has won!\n");
    }


}