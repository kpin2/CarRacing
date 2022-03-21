package com.example.carracing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import java.util.ArrayList;

/**
 * Class to build the GUI for the user to interact with and display the race
 * @author Kevin Pinto
 * @modified by:
 */

public class BuildGui extends Application {

    //Buttons to start a new race or exit
    private Button newRace;
    private Button exitRace;
    private Button selectRacer;

    //TilePane objects to hold buttons
    private TilePane gameStart;
    private TilePane inGame;

    //Creating the RacingVenue object to interact with
    private RacingVenue racingVenue;


    /**
     * Default constructor and initializing of all necessary fields for BuildGui
     */
    public BuildGui() {

        //Start screen buttons
        newRace = new Button("New Race");
        exitRace = new Button("Exit Race");

        //in game buttons
        selectRacer = new Button("Select Racer");

        //initializing the TilePanes to hold the buttons and adding them
        gameStart = new TilePane();
        inGame = new TilePane();

        gameStart.getChildren().addAll(newRace, exitRace);
        gameStart.setAlignment(Pos.CENTER);

        inGame.getChildren().addAll(selectRacer);
        inGame.setAlignment(Pos.CENTER);

    }



    //Setting up the GUI and all the elements within
    @Override
    public void start(Stage primaryStage) {
        try {

            Scene scene = new Scene(gameStart,500,500);
            primaryStage.setResizable(true);
            primaryStage.setScene(scene);
            primaryStage.show();


            //setting the actions when clicking the New Race button
            newRace.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Scene raceScene = new Scene(inGame, 600, 600);
                    Stage raceWindow = new Stage();
                    raceWindow.setScene(raceScene);
                    raceWindow.setResizable(true);
                    raceWindow.show();

                    primaryStage.close();

                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
