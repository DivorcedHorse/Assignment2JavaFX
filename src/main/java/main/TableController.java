package main;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

import java.awt.*;

public class TableController {
    @FXML
    private TextArea gameOutput;

    @FXML
    private Button playWar;
    @FXML
    private Button playWar2;
    @FXML
    private Button playButtonThree;

    WarVariationOne test = new WarVariationOne();


    public TableController() {
    }

    @FXML
    void playWar(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationOne();

        gameOutput.setText(newText);
        // TODO: play a game of War (i.e., until someone wins or there is a tie)
    }


    @FXML
    void playWar2(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationTwo();

        gameOutput.setText(newText);
        // TODO: play a game of War (i.e., until someone wins or there is a tie)
    }


    @FXML
    void playWar3(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationThree();

        gameOutput.setText(newText);
        // TODO: play a game of War (i.e., until someone wins or there is a tie)
    }

    @FXML
    public void initialize() {
        // TODO: if you need to do some GUI init, do it here
        gameOutput.setText("Please select one of the game options!");
    }
}