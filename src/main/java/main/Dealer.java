/**
 * Dealer
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Domain model that represents a dealer.  Responsible for
 * 	    dealing the cards to number of players and shuffling deck.
 */
package main;

import java.util.Collections;
import java.util.HashMap;

public class Dealer {
    Deck deck;
    String[] players;

    public Dealer(String[] playerNames){
        players = playerNames;
    }

    /**
     *
     * @return
     */
    public HashMap<String, Deck> splitDeck() {
        int curPlayer = 0;
        int numPlayers = players.length;
        int numCardsPerPlayer =  deck.getDeckSize() / numPlayers;
        int curCards = 0;

        HashMap<String, Deck> playerCards = createPlayerDecks();

        while(!deck.checkIfDeckEmpty()){
            if (curCards == numCardsPerPlayer) {
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

    private HashMap<String, Deck> createPlayerDecks() {
        HashMap<String, Deck> playerCards = new HashMap<String, Deck>();

        for (int i = 0; i < players.length; i++){
            playerCards.put(players[i], new Deck());
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
