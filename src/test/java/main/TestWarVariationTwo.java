package main;

import static org.junit.Assert.*;
import java.util.ArrayList;

import DeckBuilder.Deck;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import DeckBuilder.Card;

public class TestWarVariationTwo {
    private static WarVariationTwo testWarOne;
    private static ArrayList<Player> players;
    private static Player player1;
    private static Player player2;

    @BeforeClass
    public static void setUp() {
        testWarOne = new WarVariationTwo();
        player1 = new Player("Daniel", new Deck());
        player2 = new Player("Hao", new Deck());
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
    }

    @Test
    public void testEmptyPlayerPointsPile() {
        testWarOne.playGame(players);

        assertEquals(0, player1.getWinningsPileSize());
        assertEquals(0, player2.getWinningsPileSize());
    }


    @Test
    public void testWinnersPlayerPointsPileSize() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "10", 10));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "5", 5));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "2", 2));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "3", 3));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "8", 8));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "7", 7));

        testWarOne.playGame(players);
        int expectedPlayerOnePoints = 4;
        int expectedPlayerTwoPoints = 2;

        assertEquals(expectedPlayerOnePoints, player1.getWinningsPileSize());
        assertEquals(expectedPlayerTwoPoints, player2.getWinningsPileSize());
    }

    @Test
    public void testOverallWinner() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "10", 10));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "5", 5));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "2", 2));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "3", 3));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "8", 8));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "7", 7));

        testWarOne.playGame(players);
        String expectedWinnerString = "Winner is Daniel Hand: 0 Pile: 4";

        assertEquals(expectedWinnerString, testWarOne.checkWinner());
    }

    @After
    public void tearDown() {
        player1.getPlayerHand().getDeck().clear();
        player1.getWinningsPile().getDeck().clear();

        player2.getPlayerHand().getDeck().clear();
        player2.getWinningsPile().getDeck().clear();
    }
}