package main;

public class GameSimulation {
    StringBuffer stringBuffer = new StringBuffer();

    public String playWARVariationOne() {
        main.WarVariationOne testOne = new main.WarVariationOne();
        String[] test = {"Daniel", "Hao"};
        testOne.setUpCardsAndPlayers(test);
        testOne.playGame(testOne.listOfPlayers);
        testOne.checkWinner();

        return stringBuffer.toString();
    }

    public String playWARVariationTwo() {
        String[] test = {"Daniel", "Hao"};
        main.GameSimulationTwo testTwo = new main.GameSimulationTwo();

        testTwo.setUpCardsAndPlayers(test);
        testTwo.playGame(testTwo.listOfPlayers);

        testTwo.checkWinner();
        return stringBuffer.toString();

    }

        //SETUP FOR SECOND VARIATION
        public String playWARVariationThree() {
            WarVariationThree testThree = new WarVariationThree();
            String[] test = {"Daniel", "HAO", "Rob"};

            testThree.setUpCardsAndPlayers(test);
            stringBuffer = testThree.playGame(testThree.listOfPlayers);
            testThree.checkWinner();
            return stringBuffer.toString();
    }
}
