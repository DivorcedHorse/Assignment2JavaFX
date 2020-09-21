import java.util.ArrayList;

public class WarVariationThree extends GameVariation {

    static final Deck middleDeck = new Deck();

    public void playGame(ArrayList<Player> players) {
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);

        int roundResult;

        while (!player1.playerHand.checkIfDeckEmpty() || !player2.playerHand.checkIfDeckEmpty() ||
                !player3.playerHand.checkIfDeckEmpty()) {

            roundResult = compareCards(player1, player2, player3);

            if(roundResult == 0) {

                if(player1.playerHand.checkIfDeckEmpty() || player2.playerHand.checkIfDeckEmpty() ||
                        player3.playerHand.checkIfDeckEmpty())
                    return;

                middleDeck.addCard(player1.playTopCard());
                middleDeck.addCard(player2.playTopCard());
                middleDeck.addCard(player3.playTopCard());
                playGame(players);
            }

            if (roundResult == 1){
                System.out.println(player1.getPlayerName() + " Wins the round \n");
                player1.addPoints(middleDeck);
            }

            if(roundResult == 2){
                System.out.println(player2.getPlayerName() + " Wins the round\n");
                player2.addPoints(middleDeck);
            }

            if (roundResult == 3) {
                System.out.println(player3.getPlayerName() + " Wins the round\n");
                player3.addPoints(middleDeck);
            }

            System.out.println("Daniel has " + player1.playerPoints.deck.size() + " points");
            System.out.println("HAO has " + player2.playerPoints.deck.size() + " points");
            System.out.println("Rob has " + player3.playerPoints.deck.size() + " points");

        }
    }

    private static int compareCards(Player player1, Player player2, Player player3) {
        Card player1Card;
        Card player2Card;
        Card player3Card;

        player1Card = player1.playTopCard();
        player2Card = player2.playTopCard();
        player3Card = player3.playTopCard();

        middleDeck.addCard(player1Card);
        middleDeck.addCard(player2Card);
        middleDeck.addCard(player3Card);

        System.out.println(player1.getPlayerName() + " plays " + player1Card.getCardName() + " of " + player1Card.getCardSuit() );
        System.out.println(player2.getPlayerName() + " plays " + player2Card.getCardName() + " of " + player2Card.getCardSuit() );
        System.out.println(player3.getPlayerName() + " plays " + player3Card.getCardName() + " of " + player3Card.getCardSuit() );

        if(player1Card.getCardRank() > player2Card.getCardRank() && player1Card.getCardRank() > player3Card.getCardRank()){
            return 1;
        }
        else if(player1Card.getCardRank() < player2Card.getCardRank() && player3Card.getCardRank() < player2Card.getCardRank()){
            return 2;
        }
        else if (player1Card.getCardRank() < player3Card.getCardRank() && player2Card.getCardRank() < player3Card.getCardRank()) {
            return 3;
        }
        else {
            return 0;
        }
    }

    public void checkWinner() {
        Player player1 = listOfPlayers.get(0);
        Player player2 = listOfPlayers.get(1);
        Player player3 = listOfPlayers.get(2);

        System.out.println("Daniel had " + player1.playerPoints.deck.size() + " points!");
        System.out.println("Hao had " + player2.playerPoints.deck.size() + " points!");
        System.out.println("Rob had " + player3.playerPoints.deck.size() + " points!");

    }
}