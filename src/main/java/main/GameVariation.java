package main;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class GameVariation {

    ArrayList<Player> listOfPlayers = new ArrayList<>();

    public void setUpCardsAndPlayers(String[] players) {

        HashMap<String, Deck> playerCards = new HashMap<String, Deck>();

        Deck mainDeck = new DeckCreator().initDeck();
        Dealer dealer = new Dealer(players);

        dealer.setDeck(mainDeck);
        dealer.shuffleDeck();

        playerCards = dealer.splitDeck();

        listOfPlayers = createPlayers(playerCards, players);
    }

    public abstract StringBuffer playGame(ArrayList<Player> players);

    public abstract String checkWinner();

    public ArrayList<Player> createPlayers(HashMap<String, Deck> playerDecks, String[] players){
        ArrayList<Player> listOfPlayers = new ArrayList<>();

        for (int i = 0; i < playerDecks.size(); i++) {
            listOfPlayers.add(new Player(players[i], playerDecks.get(players[i])));
        }

        return listOfPlayers;

    }

}
