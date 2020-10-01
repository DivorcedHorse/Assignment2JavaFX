package main;

import static org.junit.Assert.*;

import DeckBuilder.Card;
import DeckBuilder.Deck;
import org.junit.*;

import java.util.ArrayList;

public class TestWarVariationOne {
    private static WarVariationOne testWarOne;
    private static ArrayList<Player> players;
    private static Player player1;
    private static Player player2;

    @BeforeClass
    public static void setUp()  {
        testWarOne = new WarVariationOne();
        player1 = new Player("Daniel", new Deck());
        player2 = new Player("Hao", new Deck());
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
    }

    /**
     * testEmptyHand ensures that if the players have no starting cards,
     * then our stringBuffer should return empty.
     */
    @Test
    public void testStartingEmptyHands() {
        assertEquals(0, testWarOne.playGame(players).length());
    }

    @Test
    public void testPlayerOneRoundWin() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "10", 10));
        player2.getPlayerHand().addCard(new Card("DIAMONDS", "5", 5));

        int expectedPlayerIDWin = 0;
        assertEquals(expectedPlayerIDWin, testWarOne.compareCards());
    }

    @Test
    public void testCheckWinnerString() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "10", 10));

        String expectedWinnerOutput = "Daniel has won!\n";
        assertEquals(expectedWinnerOutput, testWarOne.checkWinner());
    }


    /*
    @Test
    public void testCheckWARFlipFaceCardDown() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "2", 2));
        player1.getPlayerHand().addCard(new Card("SPADES", "4", 4));

        player2.getPlayerHand().addCard(new Card("CLUBS", "3", 3));
        player2.getPlayerHand().addCard(new Card("HEARTS", "4", 4));

        int expectedNumberOfCards = 0;

        testWarOne.playGame(players);
        assertEquals(expectedNumberOfCards, player1.getPlayersHandSize());
        assertEquals(expectedNumberOfCards, player2.getPlayersHandSize());
    }*/

    /*
    @Test
    public void testDetermineWinner() {
        int expectedRoundWinner = 1;
        String expectedOutPut = "Hao Wins the round\n";


        testWarOne.determineRoundWinner(expectedRoundWinner);
        System.out.println(testWarOne.gameOutput);

        assertEquals(0, 0);
    }*/


    //relook at
    @Test
    public void testWARWinner() {
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "6", 6));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "4", 4));
        player1.getPlayerHand().addCard(new Card("DIAMONDS", "7", 7));

        player2.getPlayerHand().addCard(new Card("CLUBS", "6", 6));
        player2.getPlayerHand().addCard(new Card("CLUBS", "10", 10));
        player2.getPlayerHand().addCard(new Card("CLUBS", "8", 8));

        int expectedLoserHandSize = 0;
        int expectedWinnerHandSize = 6;
        testWarOne.playGame(players);

        assertEquals(expectedLoserHandSize, player1.getPlayersHandSize());
        assertEquals(expectedWinnerHandSize, player2.getPlayersHandSize());
    }

}