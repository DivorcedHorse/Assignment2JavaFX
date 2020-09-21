import java.util.ArrayList;

public class WarVariationOne extends GameVariation {

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
                player1.collectWinnings(middleDeck);
                System.out.println("Daniel has " + player1.playerHand.deck.size() + " cards");
                System.out.println("Hao has " + player2.playerHand.deck.size() + " cards");
            }

            if(roundResult == 2){
                player2.collectWinnings(middleDeck);
                System.out.println("Daniel has " + player1.playerHand.deck.size() + " cards");
                System.out.println("Hao has " + player2.playerHand.deck.size() + " cards");
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
            player1.collectWinnings(middleDeck);
            return 1;
        }
        else if(player1Card.getCardRank() < player2Card.getCardRank()){
            System.out.println(player2.getPlayerName() + " Wins the round\n");
            player2.collectWinnings(middleDeck);
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

        if (player1.checkForEmptyHand()) {
            System.out.println(player2.getPlayerName() + " has won!");
        }
        else
            System.out.println(player1.getPlayerName() + " has won!");
    }
}
