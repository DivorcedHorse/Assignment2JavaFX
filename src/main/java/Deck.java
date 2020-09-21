import java.util.Stack;
public class Deck {
    Stack<Card> deck;

    // Had to include a Deck constructor b/c splitDeck needed to
    // create a fresh new stack for each player....in main the builder
    // did all the work
    public Deck() {
        deck = new Stack<>();
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public boolean checkIfDeckEmpty() {
        return deck.empty();
    }

    public Card getTopCard(){
        return deck.pop();
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }
}
