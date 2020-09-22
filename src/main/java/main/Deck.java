/**
 * Deck
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Domain model that represents a playing deck that contains cards.
 */
package main;

import java.util.Stack;

public class Deck {
    Stack<Card> deck;

    public Deck() {
        deck = new Stack<>();
    }

    /**
     * Adds card to deck
     *
     * @param card - Card added to deck
     */
    public void addCard(Card card) {
        deck.add(card);
    }

    /**
     * Checks if deck is empty
     *
     * @return - True if empty, false otherwise
     */
    public boolean checkIfDeckEmpty() {
        return deck.empty();
    }

    /**
     * Pops top card from deck (stack)
     *
     * @return Card - Popped card from deck
     */
    public Card getTopCard(){
        return deck.pop();
    }

    /**
     * Gives number of cards in this deck
     *
     * @return int - size of deck
     */
    public int getDeckSize() {
        return deck.size();
    }

    // GETTERS AND SETTERS
    public Stack<Card> getDeck() {
        return deck;
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }
}
