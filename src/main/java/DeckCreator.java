import java.util.Stack;
public class DeckCreator {
    String[] cardSuit = {"SPADES", "CLUBS", "DIAMONDS", "HEARTS"};
    String[] cardNames = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "" +
            "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
    int[] cardRank = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    Deck deck;

    public DeckCreator() {
        deck = initDeck();
    }

    public Deck initDeck() {
        Deck deck = new Deck();
        deck.setDeck(createDeck());
        return deck;
    }


    public Stack<Card> createDeck() {
        Stack<Card> tmpCardDeck = new Stack<>();

        for (int i = 0; i < cardSuit.length; i++) {

            for (int j = 0; j < cardRank.length; j++) {

                tmpCardDeck.add(new Card(cardSuit[i], cardNames[j], cardRank[j]));
            }
        }

        return tmpCardDeck;
    }
}
