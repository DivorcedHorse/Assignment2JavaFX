import java.util.ArrayList;

public class GameSimulationTwo extends GameVariation {
    static final Deck middleDeck = new Deck();


    public void playGame(ArrayList<Player> players) {

        int roundResult;
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        while(!player1.playerHand.checkIfDeckEmpty() && !player2.playerHand.checkIfDeckEmpty() ){

            roundResult = compareCards(player1, player2);

            if(roundResult == 0) {

                if(player1.playerHand.checkIfDeckEmpty() || player2.playerHand.checkIfDeckEmpty())
                    return;

                middleDeck.addCard(player1.playTopCard());
                middleDeck.addCard(player2.playTopCard());

                playGame(players);
            }

            if (roundResult == 1){
                System.out.println("Daniel has " + player1.playerPoints.deck.size() + " points");
                System.out.println("Hao has " + player2.playerPoints.deck.size() + " points");
            }

            if(roundResult == 2){
                System.out.println("Daniel has " + player1.playerPoints.deck.size() + " points");
                System.out.println("Hao has " + player2.playerPoints.deck.size() + " points");
            }
        }
    }

    private static int compareCards(Player player1, Player player2) {
        Card player1Card;
        Card player2Card;
        player1Card = player1.playTopCard();
        player2Card = player2.playTopCard();
        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);

        System.out.println(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() );
        System.out.println(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() );

        if(player1Card.getCardRank() > player2Card.getCardRank()){
            System.out.println(player1.getPlayerName() + " Wins the round\n");
            player1.addPoints(middleDeck);
            return 1;
        }
        else if(player1Card.getCardRank() < player2Card.getCardRank()){
            System.out.println(player2.getPlayerName() + " Wins the round\n");
            player2.addPoints(middleDeck);
            return 2;
        }
        else {
            System.out.println("tie\n");
            return 0;
        }
    }

    public void checkWinner() {
        Player player1 = listOfPlayers.get(0);
        Player player2 = listOfPlayers.get(1);

        if (player1.playerPoints.deck.size() > player2.playerPoints.deck.size()){
            System.out.println(player1.getPlayerName() + " has won by " + player1.playerPoints.deck.size());
        }
        else if(player1.playerPoints.deck.size() < player2.playerPoints.deck.size()) {
            System.out.println(player2.getPlayerName() + " has won by " + player2.playerPoints.deck.size());
        }
        else{
            System.out.println("Its a tie!");
        }
    }



}
