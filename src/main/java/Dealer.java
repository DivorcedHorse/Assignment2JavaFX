import java.util.Collections;
import java.util.HashMap;

public class Dealer {
    Deck deck;
    String[] players;

    public Dealer(String[] playerNames){
        players = playerNames;
    }

    public HashMap<String, Deck> splitDeck() {

        HashMap<String, Deck> playerCards = new HashMap<String, Deck>();

        for (int i = 0; i < players.length; i++){
            playerCards.put(players[i], new Deck());
        }

        int curPlayer = 0;
        int numPlayer = players.length;
        int numCards = deck.getDeck().size() / numPlayer;
        int curCards = 0;

        while(!deck.checkIfDeckEmpty()){
            if (curCards == numCards) {
                curPlayer++;
                curCards = 0;
            }
            if (curPlayer == 3) {
                break;
            }
            playerCards.get(players[curPlayer]).addCard(deck.getDeck().pop());
            curCards++;
        }
        return playerCards;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck.getDeck());
    }

    public void printDeck() {
        while (!deck.checkIfDeckEmpty()) {
            Card tmp = deck.getTopCard();
            System.out.printf("%s %s\n", tmp.getCardSuit(), tmp.getCardName());
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

}
