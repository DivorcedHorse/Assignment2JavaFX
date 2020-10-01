package main;

import static org.junit.Assert.*;

import DeckBuilder.Card;
import DeckBuilder.Deck;
import org.junit.*;

import java.util.ArrayList;

public class TestWarVariationOne {
    private WarVariationOne testWarOne;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        testWarOne = new WarVariationOne();
        player1 = new Player("Daniel", new Deck());
        player2 = new Player("Hao", new Deck());
    }


    /**
     * testEmptyHand ensures that if the players have no starting cards,
     * then our stringBuffer should return empty.
    */
    @Test
    public void testStartingEmptyHandsOutPut() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        assertEquals(0, testWarOne.playGame(players).length());
    }


    @Test
    public void testPlayerOneRoundWin() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "10", 10));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "9", 9));

        testWarOne.player1 = player1;
        testWarOne.player2 = player2;

        int expectedPlayerIDWin = 0;
        assertEquals(expectedPlayerIDWin, testWarOne.compareCards());
    }



    @Test
    public void testCheckWinnerString() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "10", 10));
        testWarOne.player1 = player1;

        String expectedWinnerOutput = "Daniel has won!\n";
        assertEquals(expectedWinnerOutput, testWarOne.checkWinner());
    }


    @Test
    public void testWARWinner() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "4", 4));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "7", 7));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "6", 6));

        player2.getPlayerHand().addCard(new Card("CLUBS", "8", 8));
        player2.getPlayerHand().addCard(new Card("CLUBS", "10", 10));
        player2.getPlayerHand().addCard(new Card("CLUBS", "6", 6));

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        testWarOne.playGame(players);

        int expectedLoserHandSize = 0;
        int expectedWinnerHandSize = 6;
        assertEquals(expectedLoserHandSize, testWarOne.player1.getPlayersHandSize());
        assertEquals(expectedWinnerHandSize, testWarOne.player2.getPlayersHandSize());
    }


    @After
    public void tearDown() {
        player1.getPlayerHand().getDeck().clear();
        player2.getPlayerHand().getDeck().clear();
        testWarOne.clearMiddleDeck();
    }
}