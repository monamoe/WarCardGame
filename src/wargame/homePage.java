/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import wargame.WarGame;

/**
 *
 * @author monamoe
 */
public class homePage extends Pane {

    //basic font sizes
    private Font header1 = new Font("Courier", 26);
    private Font labels = new Font("Courier", 16);
    private Font information = new Font("Courier", 12);
    private Font buttons = new Font("Courier", 13);

    //Labels
    Label titleLabel = new Label("War!");
    Label captionLabel = new Label("Chose your opponent! \nEnter their names, and press Start!");
    Label player1Label = new Label("Player 1");
    Label player2Label = new Label("Player 2");

    //Fields
    public static TextField player1Field = new TextField();
    public static TextField player2Field = new TextField();

    //Buttons
    private Button pvpButton = new Button("Player vs Player");
    private Button cpuButton = new Button("Player vs CPU");
    private Button playButton = new Button("Start!");

    //backgrounds
    private Rectangle player1Box = new Rectangle();
    private Rectangle player2Box = new Rectangle();

    public homePage() {

        //adding background colors first
        this.getChildren().add(player1Box);
        this.getChildren().add(player2Box);

        //set layouts
        setLayouts();

        //set events
        setEvents();

        //adding to the pane
        this.getChildren().add(titleLabel);
        this.getChildren().add(captionLabel);
        this.getChildren().add(player1Label);
        this.getChildren().add(player2Label);
        this.getChildren().add(player1Field);
        this.getChildren().add(player2Field);
        this.getChildren().add(pvpButton);
        this.getChildren().add(cpuButton);
        this.getChildren().add(playButton);

        //font size
        titleLabel.setFont(header1);
        captionLabel.setFont(information);
        player1Label.setFont(labels);
        player2Label.setFont(labels);
        pvpButton.setFont(buttons);
        cpuButton.setFont(buttons);
        playButton.setFont(buttons);
    }

    //sets the layouts for all of the elements
    public void setLayouts() {
        titleLabel.setMinHeight(30);
        titleLabel.setMinWidth(60);
        titleLabel.setLayoutX(220);
        titleLabel.setLayoutY(2);

        captionLabel.setMinHeight(50);
        captionLabel.setMinWidth(100);
        captionLabel.setLayoutX(180);
        captionLabel.setLayoutY(30);

        player1Label.setMinWidth(60);
        player1Label.setLayoutX(95);
        player1Label.setLayoutY(130);

        player1Field.setLayoutX(50);
        player1Field.setLayoutY(160);

        player2Label.setMinWidth(60);
        player2Label.setLayoutX(345);
        player2Label.setLayoutY(130);

        player2Field.setLayoutX(300);
        player2Field.setLayoutY(160);

        //buttons
        pvpButton.setMinWidth(60);
        pvpButton.setLayoutX(75);
        pvpButton.setLayoutY(230);

        cpuButton.setMinWidth(60);
        cpuButton.setLayoutX(325);
        cpuButton.setLayoutY(230);

        playButton.setMinHeight(40);
        playButton.setMinWidth(80);
        playButton.setFont(buttons);
        playButton.setLayoutX(210);
        playButton.setLayoutY(400);

        //background box
        player1Box.setLayoutX(20);
        player1Box.setLayoutY(120);
        player1Box.setWidth(210);
        player1Box.setHeight(200);
        player2Box.setLayoutX(270);
        player2Box.setLayoutY(120);
        player2Box.setWidth(210);
        player2Box.setHeight(200);
        player1Box.setFill(Color.LIGHTBLUE);
        player2Box.setFill(Color.LIGHTBLUE);
    }

    //sets the events for the buttons
    public void setEvents() {
        //when the PVP button is clicked
        pvpButton.setOnAction((ActionEvent e) -> {
            //enable both text fields
            player1Field.setEditable(true);
            player2Field.setEditable(true);
            player2Field.setText("");
            player2Label.setText("Player 2");
        });

        //when the CPU button is clicked
        cpuButton.setOnAction(((ActionEvent e) -> {
            player1Field.setEditable(true);
            player2Field.setEditable(false);
            player2Field.setText("CPU");
            player2Label.setText("CPU: ");
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
