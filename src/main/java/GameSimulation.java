public class GameSimulation {

    public static void main(String[] args) {

        /*
        // SETUP FOR FIRST VARIATION
        WarVariationOne testOne = new WarVariationOne();
        String[] test = {"Daniel", "Hao"};
        testOne.setUpCardsAndPlayers(test);
        testOne.playGame(testOne.listOfPlayers);
        testOne.checkWinner();*/

        /*
        //SETUP FOR SECOND VARIATION
        String[] test = {"Daniel", "Hao"};
        GameSimulationTwo testTwo = new GameSimulationTwo();
        String[] Two = {"Daniel", "Hao"};
        testTwo.setUpCardsAndPlayers(test);
        testTwo.playGame(testTwo.listOfPlayers);
        testTwo.checkWinner();
         */

        //SETUP FOR SECOND VARIATION
        WarVariationThree testThree = new WarVariationThree();
        String[] test = {"Daniel", "HAO", "Rob"};
        testThree.setUpCardsAndPlayers(test);
        testThree.playGame(testThree.listOfPlayers);
        testThree.checkWinner();
        System.out.println("FINISHED");


    }
}
