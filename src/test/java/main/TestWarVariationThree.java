package main;

import static org.junit.Assert.*;
import java.util.ArrayList;

import DeckBuilder.Deck;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import DeckBuilder.Card;

public class TestWarVariationThree {
    private static WarVariationThree testWarThree;
    private static ArrayList<Player> players;
    private static Player player1;
    private static Player player2;
    private static Player player3;

    @BeforeClass
    public static void setUp() {
        testWarThree = new WarVariationThree();
        players = new ArrayList<>();
        testWarThree.player1 = new Player("Daniel", new Deck());
        testWarThree.player2 = new Player("Hao", new Deck());
        testWarThree.player3 = new Player("Rob", new Deck());
    }


    @Test
    public void testStartingNumberOfCards() {
        String[] playerNames = {"Daniel", "HAO", "Rob"};
        testWarThree.setUpCardsAndPlayers(playerNames);
        player1 = testWarThree.listOfPlayers.get(0);
        player2 = testWarThree.listOfPlayers.get(1);
        player3 = testWarThree.listOfPlayers.get(2);

        int expectedStartingPlayerHandSize = 17;

        assertEquals(expectedStartingPlayerHandSize, player1.getPlayersHandSize());
        assertEquals(expectedStartingPlayerHandSize, player2.getPlayersHandSize());
        assertEquals(expectedStartingPlayerHandSize, player3.getPlayersHandSize());
    }

    @Test
    public void testTieWinners() {
        player1.getWinningsPile().addCard(new Card("DIAMONDS", "10", 10));
        player2.getWinningsPile().addCard(new Card("DIAMONDS", "5", 5));


        String expectedWinners = "WINNERS: \nWinner is Daniel Hand: 0 Pile: 1\nWinner is HAO Hand: 0 Pile: 1\n";
        assertEquals(expectedWinners, testWarThree.checkWinner());
    }

    @Test
    public void testTwoDuplicateLowCardsAndHighCardRoundWinner() {
        testWarThree.player1.getPlayerHand().addCard(new Card("DIAMONDS", "5", 5));
        testWarThree.player2.getPlayerHand().addCard(new Card("HEARTS", "5", 5));
        testWarThree.player3.getPlayerHand().addCard(new Card("CLUBS", "7", 7));

        int expectedWinnerID = 2;
        assertEquals(expectedWinnerID, testWarThree.compareCards());
    }



    @After
    public void tearDown() {
        player1.getPlayerHand().getDeck().clear();
        player1.getWinningsPile().getDeck().clear();

        player2.getPlayerHand().getDeck().clear();
        player2.getWinningsPile().getDeck().clear();

        player3.getPlayerHand().getDeck().clear();
        player3.getWinningsPile().getDeck().clear();
    }
}