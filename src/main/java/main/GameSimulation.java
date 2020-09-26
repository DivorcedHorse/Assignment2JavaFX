/**
 * GameSimulation
 * 		By Daniel Tellez and Hao Tran
 *
 * 	Purpose:
 * 		Simulates the three WAR variations.  Calls and runs the
 * 	    necessary methods needed to play a WAR game.
 */
package main;

public class GameSimulation {

    private StringBuffer stringBuffer = new StringBuffer();


    /**
     * Plays a simulation of the first WAR variation game.
     *
     * @return
     */
    public String playWARVariationOne() {
        main.WarVariationOne warOneSimulation = new main.WarVariationOne();

        String[] playerNames = {"Daniel", "Hao"};
        warOneSimulation.setUpCardsAndPlayers(playerNames);

        stringBuffer.append(warOneSimulation.playGame(warOneSimulation.listOfPlayers));
        stringBuffer.append(warOneSimulation.checkWinner());

        return stringBuffer.toString();
    }

    /**
     * Plays a simulation of the second WAR variation game.
     *
     * @return
     */
    public String playWARVariationTwo() {
        main.WarVariationTwo warTwoSimulation = new main.WarVariationTwo();

        String[] playerNames = {"Daniel", "Hao"};
        warTwoSimulation.setUpCardsAndPlayers(playerNames);

        stringBuffer.append(warTwoSimulation.playGame(warTwoSimulation.listOfPlayers));
        stringBuffer.append(warTwoSimulation.checkWinner());

        return stringBuffer.toString();
    }

    /**
     * Plays a simulation of the third WAR variation game.
     *
     * @return
     */
    public String playWARVariationThree() {
        main.WarVariationThree warThreeSimulation = new WarVariationThree();

        String[] playerNames = {"Daniel", "HAO", "Rob"};
        warThreeSimulation.setUpCardsAndPlayers(playerNames);

        stringBuffer.append(warThreeSimulation.playGame(warThreeSimulation.listOfPlayers));
        stringBuffer.append(warThreeSimulation.checkWinner());

        return stringBuffer.toString();
    }
}