package main;

public class GameSimulation {

    public String playWARVariationOne() {
        StringBuffer stringBuffer = new StringBuffer();

        main.WarVariationOne testOne = new main.WarVariationOne();
        String[] test = {"Daniel", "Hao"};
        testOne.setUpCardsAndPlayers(test);

        stringBuffer = testOne.playGame(testOne.listOfPlayers);
        stringBuffer.append(testOne.checkWinner());

        return stringBuffer.toString();
    }

    public String playWARVariationTwo() {
        StringBuffer stringBuffer = new StringBuffer();

        String[] test = {"Daniel", "Hao"};
        main.GameSimulationTwo testTwo = new main.GameSimulationTwo();

        testTwo.setUpCardsAndPlayers(test);
        stringBuffer = testTwo.playGame(testTwo.listOfPlayers);

        stringBuffer.append(testTwo.checkWinner());

        return stringBuffer.toString();

    }

        //SETUP FOR SECOND VARIATION
        public String playWARVariationThree() {
            StringBuffer stringBuffer = new StringBuffer();

            WarVariationThree testThree = new WarVariationThree();
            String[] test = {"Daniel", "HAO", "Rob"};

            testThree.setUpCardsAndPlayers(test);
            stringBuffer = testThree.playGame(testThree.listOfPlayers);
            //testThree.checkWinner();
            return stringBuffer.toString();
    }
}
