package main;

import static org.junit.Assert.*;
import java.util.ArrayList;

import main.Deck;
import main.Player;
import main.WarVariationTwo;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Card;

public class TestWarVariationThree {
    private static WarVariationThree testWarOne;
    private static ArrayList<Player> players;
    private static Player player1;
    private static Player player2;
    private static Player player3;

    @BeforeClass
    public static void setUp() {
        testWarOne = new WarVariationThree();
    }

    @Test
    public void testStartingNumberOfCards() {
        String[] playerNames = {"Daniel", "HAO", "Rob"};
        testWarOne.setUpCardsAndPlayers(playerNames);
        player1 = testWarOne.listOfPlayers.get(0);
        player2 = testWarOne.listOfPlayers.get(1);
        player3 = testWarOne.listOfPlayers.get(2);

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
        System.out.println(expectedWinners);
        System.out.println(testWarOne.checkWinner());

        //assertEquals(0,0);
        assertEquals(expectedWinners,testWarOne.checkWinner());
    }

    @After
    public void tearDown() {
        player1.getPlayerHand().getDeck().clear();
        player1.getWinningsPile().getDeck().clear();

        player2.getPlayerHand().getDeck().clear();
        player2.getWinningsPile().getDeck().clear();
    }
}