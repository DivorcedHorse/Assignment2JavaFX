/**
 * DeckCreator
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Builder class that creates and initializes standard playing deck.
 */
package DeckBuilder;
import java.util.Stack;

public class DeckCreator {
    String[] cardSuits = {"SPADES", "CLUBS", "DIAMONDS", "HEARTS"};
    String[] cardNames = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "" +
            "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
    int[] cardRanks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    Deck deck;

    public DeckCreator() {
        deck = initDeck();
    }

    /**
     * Declares and initializes a new deck.
     *
     * @return newDeck - newly created playing deck
     */
    public Deck initDeck() {
        Deck newDeck = new Deck();
        newDeck.setDeck(createStandardDeck());

        return newDeck;
    }

    /**
     * Fills an empty deck with newly created cards.
     *
     * @return tmpCardDeck - newly created playing deck
     */
    private Stack<Card> createStandardDeck() {
        Stack<Card> tmpCardDeck = new Stack<>();

        for (int i = 0; i < cardSuits.length; i++) {
            for (int j = 0; j < cardRanks.length; j++) {
                tmpCardDeck.add(new Card(cardSuits[i], cardNames[j], cardRanks[j]));
            }
        }

        return tmpCardDeck;
    }
}
