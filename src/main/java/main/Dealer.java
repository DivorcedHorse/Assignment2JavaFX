/**
 * Dealer
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Domain model that represents a dealer.  Responsible for
 * 	    dealing the cards to number of players and shuffling deck.
 */
package main;

import DeckBuilder.Deck;
import java.util.Collections;
import java.util.HashMap;

public class Dealer {
    Deck deck;
    String[] players;

    public Dealer(String[] playerNames){
        players = playerNames;
    }

    /**
     *  Distributes even amount of cards to each players hand.
     *
     * @return playerCards - Corresponding deck to each player.
     */
    public HashMap<String, Deck> splitDeck() {
        int curPlayer = 0;
        int numPlayers = players.length;
        int numCardsPerPlayer =  deck.getDeckSize() / numPlayers;
        int givenCardCnt = 0;

        HashMap<String, Deck> playerCards = createPlayerDecks();

        while(!deck.checkIfDeckEmpty()) {
            if (givenCardCnt == numCardsPerPlayer) {
                curPlayer++;
                givenCardCnt = 0;
            }
            if (curPlayer == 3)
                break;

            playerCards.get(players[curPlayer]).addCard(deck.getTopCard());
            givenCardCnt++;
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

    /**
     * Simply rearranges order of cards in deck
     *
     */
    public void shuffleDeck() {
        Collections.shuffle(deck.getDeck());
    }

    // GETTERS AND SETTERS
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String[] getPlayers() {
        return players;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }


}
