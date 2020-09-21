package main;

import java.util.ArrayList;

public class GameSimulationTwo extends GameVariation {

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

                middleDeck.addCard(player1.playTopCard());
                middleDeck.addCard(player2.playTopCard());

                playGame(players);
            }

            if (roundResult == 1){
                gameOutput.append("Daniel has " + player1.playerPoints.deck.size() + " points\n");
                gameOutput.append("Hao has " + player2.playerPoints.deck.size() + " points\n");
            }

            if(roundResult == 2){
                gameOutput.append("Daniel has " + player1.playerPoints.deck.size() + " points\n");
                gameOutput.append("Hao has " + player2.playerPoints.deck.size() + " points\n");
            }
            gameOutput.append("\n");
        }
        return gameOutput;
    }

    private int compareCards(Player player1, Player player2) {
        Card player1Card;
        Card player2Card;
        player1Card = player1.playTopCard();
        player2Card = player2.playTopCard();
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);

        gameOutput.append(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() + "\n" );
        gameOutput.append(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() + "\n");

        if(player1Card.getCardRank() > player2Card.getCardRank()){
            gameOutput.append(player1.getPlayerName() + " Wins the round\n");
            player1.addPoints(middleDeck);
            return 1;
        }
        else if(player1Card.getCardRank() < player2Card.getCardRank()){
            gameOutput.append(player2.getPlayerName() + " Wins the round\n");
            player2.addPoints(middleDeck);
            return 2;
        }
        else {
            gameOutput.append("tie\n");
            return 0;
        }
    }

    public void checkWinner() {
        Player player1 = listOfPlayers.get(0);
        Player player2 = listOfPlayers.get(1);

        if (player1.playerPoints.deck.size() > player2.playerPoints.deck.size()){
            gameOutput.append(player1.getPlayerName() + " has won by " + player1.playerPoints.deck.size()+ "\n");
        }
        else if(player1.playerPoints.deck.size() < player2.playerPoints.deck.size()) {
            gameOutput.append(player2.getPlayerName() + " has won by " + player2.playerPoints.deck.size()+ "\n");
        }
        else{
            gameOutput.append("Its a tie!\n");
        }
    }



}
