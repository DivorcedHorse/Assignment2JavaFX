package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class TableController {
    @FXML
    private TextArea gameOutput;
    @FXML
    private Button playWar;
    @FXML
    private Button playWar2;
    @FXML
    private Button playButtonThree;

    public TableController() {
    }


    @FXML
    void playWar(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationOne();

        gameOutput.setText(newText);
    }

    @FXML
    void playWar2(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationTwo();

        gameOutput.setText(newText);
    }

    @FXML
    void playWar3(ActionEvent event) {
        GameSimulation gameSimulation = new GameSimulation();

        String newText;
        newText = gameSimulation.playWARVariationThree();

        gameOutput.setText(newText);
    }

    @FXML
    public void initialize() {
        gameOutput.setText("Please select one of the WAR variations!");
    }
}