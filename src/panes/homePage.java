/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import content.Game;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import wargame.WarGame;

public class homePage extends Pane {

    //Labels
    Label titleLabel = new Label("War!");
    Label player1Label = new Label("Player 1: ");
    Label player2Label = new Label("Player 2: ");

    //Fields
    public static TextField player1Field = new TextField();
    public static TextField player2Field = new TextField();

    //Buttons
    private Button pvpButton = new Button("Player vs Player");
    private Button cpuButton = new Button("Player vs CPU");
    private Button playButton = new Button("Start!");

    public homePage() {
        //set layouts
        setLayouts();
        //set events
        setEvents();
        this.getChildren().add(titleLabel);
        this.getChildren().add(player1Label);
        this.getChildren().add(player2Label);
        this.getChildren().add(player1Field);
        this.getChildren().add(player2Field);
        this.getChildren().add(pvpButton);
        this.getChildren().add(cpuButton);
        this.getChildren().add(playButton);

    }

    //sets the layouts for all of the elements
    public void setLayouts() {
        titleLabel.setLayoutX(20);

        player1Label.setLayoutX(20);
        player1Field.setLayoutX(50);
        player1Label.setLayoutY(50);
        player1Field.setLayoutY(50);

        player2Label.setLayoutX(200);
        player2Field.setLayoutX(250);
        player2Label.setLayoutY(50);
        player2Field.setLayoutY(50);

        //buttons
        pvpButton.setLayoutX(50);
        pvpButton.setLayoutY(100);
        cpuButton.setLayoutX(250);
        cpuButton.setLayoutY(100);
        playButton.setLayoutX(250);
        playButton.setLayoutY(200);
    }

    //sets the events for the buttons
    public void setEvents() {
        //when the PVP button is clicked
        pvpButton.setOnAction((ActionEvent e) -> {
            //enable both text fields
            player1Field.setEditable(true);
            player2Field.setEditable(true);
        });

        //when the CPU button is clicked
        cpuButton.setOnAction(((ActionEvent e) -> {
            player1Field.setEditable(true);
            player2Field.setEditable(false);
            player2Field.setText("CPU");
        }));

        //submitting
        playButton.setOnAction(((ActionEvent e) -> {
            WarGame.createGame();
            Game.setPlayers();
            WarGame.changeScene("main");
        }));
    }

    //returns the players names
    public static String getPlayer1Name() {
        return player1Field.getText().trim();
    }

    public static String getPlayer2Name() {
        return player2Field.getText().trim();
    }

}
