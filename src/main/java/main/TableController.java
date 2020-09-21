package main;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class TableController {
    @FXML
    private TextArea gameOutput;

    @FXML
    private Button playButtonOne;
    @FXML
    private Button playButtonTwo;
    @FXML
    private Button playButtonThree;

    WarVariationOne test = new WarVariationOne();


    public TableController() {
    }

    @FXML
    void playWarOne(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationOne();

        gameOutput.setText(newText);
        // TODO: play a game of War (i.e., until someone wins or there is a tie)
    }

    @FXML
    void playWarTwo(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationTwo();

        gameOutput.setText(newText);
        // TODO: play a game of War (i.e., until someone wins or there is a tie)
    }

    @FXML
    void playWarThree(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationThree();

        gameOutput.setText(newText);
        // TODO: play a game of War (i.e., until someone wins or there is a tie)
    }

    @FXML
    public void initialize() {
        // TODO: if you need to do some GUI init, do it here
    }
}