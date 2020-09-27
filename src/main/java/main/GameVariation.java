/**
 * GameVariation
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Abstract class defining the necessary methods that each WAR variation
 * 	    must implement in order to play a game of WAR.
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class GameVariation {

    ArrayList<Player> listOfPlayers = new ArrayList<>();

    /**
     * Create and initialize players, dealer, and
     * deck used for a WAR game.
     *
     * @param playerNames - List of names of players
     */
    public void setUpCardsAndPlayers(String[] playerNames) {

        HashMap<String, Deck> playerCards = new HashMap<String, Deck>();

        Deck mainDeck = new DeckCreator().initDeck();

        Dealer dealer = new Dealer(playerNames);
        dealer.setDeck(mainDeck);
        dealer.shuffleDeck();

        playerCards = dealer.splitDeck();

        listOfPlayers = createPlayers(playerCards, playerNames);
    }

    private ArrayList<Player> createPlayers(HashMap<String, Deck> playerDecks, String[] players){
        ArrayList<Player> listOfPlayers = new ArrayList<>();

        for (int i = 0; i < playerDecks.size(); i++) {
            listOfPlayers.add(new Player(players[i], playerDecks.get(players[i])));
        }

        return listOfPlayers;
    }

    /**
     * Simulates the steps necessary to play a variation of WAR.
     * Given players list, will iterate through players hand each
     * round playing and comparing cards.
     *
     * @param players - Players playing the game.
     *
     * @return StringBuffer - StringBuffer that contains all
     *                        events that occurred in a game.
     */
    public abstract StringBuffer playGame(ArrayList<Player> players);

    /**
     *  Determines who is overall winner of that variation
     *  of WAR.
     *
     * @return String - String that contains winner.
     */
    public abstract String checkWinner();

    /**
     * Checks to see if any of the players hands/deck
     * is empty.  If so, returns false to stop
     * the game.
     *
     * @return - =
     */
    public abstract boolean checkForAnyEmptyDeck();

    /**
     * Compares the card values that the players
     * played for that round.  Looks for the highest
     * played card.
     *
     * @return int - Number indicating which player won
     *               round (or tie)
     */
    public abstract int compareCards();

    /**
     * Determines who won the round just played.  Winner
     * collects their winnings and appends output.
     *
     * @param roundResult - int representing player who won round
     */
    public abstract void determineRoundWinner(int roundResult);

    /**
     * A tie has occurred, simply appends statement
     * and players play a face down card.
     */
    public abstract void prepareForWAR();
    }