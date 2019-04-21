/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import static wargame.Game.player1;
import static wargame.Game.player2;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author monamoe
 */
public class gamePage extends Pane {

    //basic font sizes
    private Font header1 = new Font("Courier", 26);
    private Font labels = new Font("Courier", 16);
    private Font information = new Font("Courier", 12);
    private Font buttons = new Font("Courier", 13);

    //round counter
    int roundCounter = 1;

    //button is true
    public static boolean player1ReadyBoolean = false;
    public static boolean player2ReadyBoolean = false;

    //backgrounds
    private Rectangle player1Box = new Rectangle(220, 210, Color.LIGHTBLUE);
    private Rectangle player2Box = new Rectangle(220, 210, Color.LIGHTBLUE);

    //holds the user's name, cards remaining
    private Label titleLabel = new Label("War!");
    public static Label player1Information = new Label("");
    public static Label player2Information = new Label("");
    public static Label roundInformation = new Label("Round Information: ");

    public static Button player1Play = new Button("Draw Cards");
    public static Button player2Play = new Button("Draw Cards");

    //IMAGES
    public static ImageView heartsPlayer1 = new ImageView("images/hearts.png");
    public static ImageView diamondsPlayer1 = new ImageView("images/diamonds.png");
    public static ImageView clubsPlayer1 = new ImageView("images/clubs.jpg");
    public static ImageView spadesPlayer1 = new ImageView("images/spade.png");
    public static ImageView heartsPlayer2 = new ImageView("images/hearts.png");
    public static ImageView diamondsPlayer2 = new ImageView("images/diamonds.png");
    public static ImageView clubsPlayer2 = new ImageView("images/clubs.jpg");
    public static ImageView spadesPlayer2 = new ImageView("images/spade.png");

    public gamePage() {
        //set layouts
        setLayouts();

        //events
        player1Play.setOnAction(new player1Ready());
        player2Play.setOnAction(new player2Ready());

        //adding to the pane
        this.getChildren().add(player1Box);
        this.getChildren().add(player2Box);
        this.getChildren().add(heartsPlayer1);
        this.getChildren().add(diamondsPlayer1);
        this.getChildren().add(clubsPlayer1);
        this.getChildren().add(spadesPlayer1);
        this.getChildren().add(heartsPlayer2);
        this.getChildren().add(diamondsPlayer2);
        this.getChildren().add(clubsPlayer2);
        this.getChildren().add(spadesPlayer2);

        this.getChildren().add(titleLabel);
        this.getChildren().add(player1Information);
        this.getChildren().add(player2Information);
        this.getChildren().add(roundInformation);
        this.getChildren().add(player1Play);
        this.getChildren().add(player2Play);

        //fonts
        titleLabel.setFont(header1);

        clearGround();

    }

    //sets the layouts for all of the elements
    public void setLayouts() {

        //TOP
        titleLabel.setMinWidth(60);
        titleLabel.setLayoutX(220);
        roundInformation.setMinSize(100, 30);
        roundInformation.setLayoutX(150);
        roundInformation.setLayoutY(40);

        //Rectangles
        player1Box.setLayoutX(20);
        player1Box.setLayoutY(280);
        player2Box.setLayoutX(260);
        player2Box.setLayoutY(280);

        player1Information.setLayoutX(20);
        player1Information.setLayoutY(450);

        player2Information.setLayoutX(20);
        player2Information.setLayoutY(20);

        //player buttons
        player1Play.setMinWidth(60);
        player2Play.setMinWidth(60);

        player1Play.setLayoutX(95);
        player1Play.setLayoutY(430);
        player2Play.setLayoutX(335);
        player2Play.setLayoutY(430);

        //player info fields
        player1Information.setLayoutX(30);
        player2Information.setLayoutX(270);
        player1Information.setLayoutY(290);
        player2Information.setLayoutY(290);
        player2Information.setText("PLAYER 2 INFO");
        player1Information.setText("PLAYER 1 INFO");

        //rectangle
        //images size
        int imageswidth = 120;
        int imagesheight = 140;
        spadesPlayer1.setFitWidth(imageswidth);
        spadesPlayer1.setFitHeight(imagesheight);
        heartsPlayer1.setFitWidth(imageswidth);
        heartsPlayer1.setFitHeight(imagesheight);
        diamondsPlayer1.setFitWidth(imageswidth);
        diamondsPlayer1.setFitHeight(imagesheight);
        clubsPlayer1.setFitWidth(imageswidth);
        clubsPlayer1.setFitHeight(imagesheight);
        spadesPlayer2.setFitWidth(imageswidth);
        spadesPlayer2.setFitHeight(imagesheight);
        heartsPlayer2.setFitWidth(imageswidth);
        heartsPlayer2.setFitHeight(imagesheight);
        diamondsPlayer2.setFitWidth(imageswidth);
        diamondsPlayer2.setFitHeight(imagesheight);
        clubsPlayer2.setFitWidth(imageswidth);
        clubsPlayer2.setFitHeight(imagesheight);

        //setting locations
        int imagesHeight = 120;
        int player1imagesx = 70;
        int player2imagesx = 320;
        spadesPlayer1.setLayoutX(player1imagesx);
        heartsPlayer1.setLayoutX(player1imagesx);
        diamondsPlayer1.setLayoutX(player1imagesx);
        clubsPlayer1.setLayoutX(player1imagesx);

        spadesPlayer2.setLayoutX(player2imagesx);
        heartsPlayer2.setLayoutX(player2imagesx);
        diamondsPlayer2.setLayoutX(player2imagesx);
        clubsPlayer2.setLayoutX(player2imagesx);

        heartsPlayer1.setLayoutY(imagesHeight);
        diamondsPlayer1.setLayoutY(imagesHeight);
        clubsPlayer1.setLayoutY(imagesHeight);
        spadesPlayer1.setLayoutY(imagesHeight);
        spadesPlayer2.setLayoutY(imagesHeight);
        heartsPlayer2.setLayoutY(imagesHeight);
        diamondsPlayer2.setLayoutY(imagesHeight);
        clubsPlayer2.setLayoutY(imagesHeight);

    }

    //ready ups player1, starts the round once both are ready
    public class player1Ready implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            player1ReadyBoolean = true;
            player1.updateCardImage(0);
            if (player2.getPlayerID().equals("CPU")) {
                player2.updateCardImage(0);
                drawCards();
                player2Information.setText(player2.getPlayerID() + "\n\nCPU played a "
                        + player2.hand.get(0).getValue() + " of " + player2.hand.get(0).getSuit().toString()
                        + "\nCPU has " + player2.getSize() + " cards remaining."
                );
            } else if (player1ReadyBoolean == true && player2ReadyBoolean == true) {
                drawCards();
            } else {
                player1Information.setText(player1.getPlayerID() + "\n\nYou played a "
                        + player1.hand.get(0).getValue() + " of " + player1.hand.get(0).getSuit().toString()
                        + "\nYou have " + player1.getSize() + " cards remaining."
                );
                player2Information.setText(player2.getPlayerID() + "\n\nYou played a "
                        + "\nYou have " + player2.getSize() + " cards remaining."
                );
            }
        }
    }

    //ready ups player1, starts the round once both are ready
    public class player2Ready implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            player2ReadyBoolean = true;
            player2.updateCardImage(0);
            if (player1ReadyBoolean == true && player2ReadyBoolean == true) {
                drawCards();
            } else {

                player2Information.setText(player2.getPlayerID() + "\n\nYou played a "
                        + player2.hand.get(0).getValue() + " of " + player2.hand.get(0).getSuit().toString()
                        + "\nYou have " + player2.getSize() + " cards remaining."
                );

                player1Information.setText(player1.getPlayerID() + "\n\nYou played a "
                        + "\nYou have " + player1.getSize() + " cards remaining."
                );

            }
        }
    }

    //draws both of the players cards
    public void drawCards() {

        //try catch statement that checks if the one of the array lsits have no indexes left
        try {
            //make sure the game is still going on
            System.out.println(player1.hand.size());
            if (player1.hand.size() > 0 && player2.hand.size() > 0) {
                player1ReadyBoolean = false;
                player2ReadyBoolean = false;

                System.out.println("Round number: " + roundCounter);
                roundCounter++;

                //compare to see who wins the 2 cards
                switch (Game.compare(player1.hand.get(0), player2.hand.get(0))) {
                    case 1:
                        //player one wins this round
                        player1Information.setText(player1.getPlayerID() + "\n\nYou played a "
                                + player1.hand.get(0).getValue() + " of " + player1.hand.get(0).getSuit().toString()
                                + "\n\nYou won this round! \nYou recieved a "
                                + player2.hand.get(0).getValue().toString() + " of " + player2.hand.get(0).getSuit().toString() + "."
                                + "\nYou have " + player1.getSize() + " cards remaining."
                        );

                        if (player2.getPlayerID().equals("CPU")) {
                            System.out.println("cpu lost");
                            player2Information.setText(player2.getPlayerID() + "\n\nCPU played a "
                                    + player2.hand.get(0).getValue() + " of " + player2.hand.get(0).getSuit().toString()
                                    + "\n\nCPU lost this round! \nCPU lost a "
                                    + player2.hand.get(0).getValue().toString() + " of " + player2.hand.get(0).getSuit().toString() + "."
                                    + "\nCPU has " + player2.getSize() + " cards remaining."
                            );
                        } else {
                            player2Information.setText(player2.getPlayerID() + "\n\nYou played a "
                                    + player2.hand.get(0).getValue() + " of " + player2.hand.get(0).getSuit().toString()
                                    + "\n\nYou lost this round! \nYou loose a "
                                    + player2.hand.get(0).getValue().toString() + " of " + player2.hand.get(0).getSuit().toString() + "."
                                    + "\nYou have " + player2.getSize() + " cards remaining."
                            );
                        }

                        roundInformation.setText("Round Information \nRound number: " + roundCounter + "\n" + player1.getPlayerID() + " won this round.");

                        Game.play(player1, player2, 0);
                        break;
                    case 2:
                        //player two wins this round
                        if (player2.getPlayerID().equals("CPU")) {
                            System.out.println("cpu won");
                            player2Information.setText(player2.getPlayerID() + "\n\nCPU played a "
                                    + player2.hand.get(0).getValue() + " of " + player2.hand.get(0).getSuit().toString()
                                    + "\n\nCPU won this round! \nCPU recieves a "
                                    + player1.hand.get(0).getValue().toString() + " of " + player1.hand.get(0).getSuit().toString() + "."
                                    + "\nCPU has " + player1.getSize() + " cards remaining."
                            );
                        } else {
                            player2Information.setText(player2.getPlayerID() + "\n\nYou played a "
                                    + player2.hand.get(0).getValue() + " of " + player2.hand.get(0).getSuit().toString()
                                    + "\n\nYou won this round! \nYou recieved a "
                                    + player1.hand.get(0).getValue().toString() + " of " + player1.hand.get(0).getSuit().toString() + "."
                                    + "\nYou have " + player1.getSize() + " cards remaining."
                            );
                        }

                        player1Information.setText(player1.getPlayerID() + "\n\nYou played a "
                                + player1.hand.get(0).getValue() + " of " + player1.hand.get(0).getSuit().toString()
                                + "\n\nYou lost this round! \nYou loose a "
                                + player1.hand.get(0).getValue().toString() + " of " + player1.hand.get(0).getSuit().toString() + "."
                                + "\nYou have " + player1.getSize() + " cards remaining."
                        );

                        roundInformation.setText("Round Information \nRound number: " + roundCounter + "\n" + player2.getPlayerID() + " won this round.");

                        Game.play(player2, player1, 0);
                        break;
                    default:
                        //they tie, and have a war
                        System.out.println("WAR!");

                        //number of cards on the ground
                        int ground = 0;

                        //keep adding cards onto the ground until the they stop tieing.
                        while (Game.compare(player1.hand.get(ground), player2.hand.get(ground)) == 0) {
                            System.out.println("comparing");
                            ground = ground + 2;
                        }

                        //find out who wins the war.
                        switch (Game.compare(player1.hand.get(ground), player2.hand.get(ground))) {
                            case 1:
                                //player1 info
                                player1Information.setText(player1.getPlayerID() + "\nYou played a "
                                        + player1.hand.get(ground).getValue() + " of " + player1.hand.get(0).getSuit().toString() + " for the war."
                                        + "\n\nYou won the War!! \nYou recieve... \n");

                                for (int x = 0; x < ground; x++) {
                                    player1Information.setText(player1Information.getText() + player2.hand.get(x).getValue().toString() + " of " + player2.hand.get(x).getSuit().toString() + ".\n");
                                }
                                player1Information.setText(player1Information.getText() + "\nYou have " + player1.getSize() + " cards remaining.");

                                //player 2 info
                                player2Information.setText(player2.getPlayerID() + "\nYou played a "
                                        + player2.hand.get(ground).getValue() + " of " + player2.hand.get(0).getSuit().toString() + " for the war."
                                        + "\n\nYou lost the War!! \nYou loose... \n");

                                for (int x = 0; x < ground; x++) {
                                    player2Information.setText(player2Information.getText() + player2.hand.get(x).getValue().toString() + " of " + player2.hand.get(x).getSuit().toString() + ".\n");
                                }
                                player2Information.setText(player2Information.getText() + "\nYou have " + player1.getSize() + " cards remaining.");

                                roundInformation.setText("Round Information \nRound number: " + roundCounter + "\n" + player2.getPlayerID() + " WON THE WAR AND COLLECTS " + ground + " CARDS!!");
                                Game.play(player1, player2, ground);
                                break;
                            case 2:
                                //player 1 info
                                player1Information.setText(player1.getPlayerID() + "\nYou played a "
                                        + player1.hand.get(ground).getValue() + " of " + player1.hand.get(0).getSuit().toString() + " for the war."
                                        + "\n\nYou lost the War!! \nYou loose... \n");

                                for (int x = 0; x < ground; x++) {
                                    player1Information.setText(player1Information.getText() + player1.hand.get(x).getValue().toString() + " of " + player1.hand.get(x).getSuit().toString() + ".\n");
                                }
                                player1Information.setText(player1Information.getText() + "\nYou have " + player1.getSize() + " cards remaining.");
                                //player 2 info
                                player2Information.setText(player2.getPlayerID() + "\nYou played a "
                                        + player2.hand.get(ground).getValue() + " of " + player2.hand.get(0).getSuit().toString() + " for the war."
                                        + "\n\nYou won the War!! \nYou recieve... \n");

                                for (int x = 0; x < ground; x++) {
                                    player2Information.setText(player2Information.getText() + player1.hand.get(x).getValue().toString() + " of " + player1.hand.get(x).getSuit().toString() + ".\n");
                                }
                                player2Information.setText(player2Information.getText() + "\nYou have " + player1.getSize() + " cards remaining.");

                                roundInformation.setText("Round Information \nRound number: " + roundCounter + "\n" + player2.getPlayerID() + " WON THE WAR AND COLLECTS " + ground + " CARDS!!");

                                Game.play(player2, player1, ground);
                                break;
                        }
                }

            } else {
                //find if there is a winner
                Game.declareWinner();
            }
        } catch (Exception e) {
            Game.declareWinner();
        }

    }

//clears all the card iamges currently being displaed
    public void clearGround() {
        heartsPlayer1.setVisible(false);
        spadesPlayer1.setVisible(false);
        clubsPlayer1.setVisible(false);
        diamondsPlayer1.setVisible(false);
        heartsPlayer2.setVisible(false);
        spadesPlayer2.setVisible(false);
        clubsPlayer2.setVisible(false);
        diamondsPlayer2.setVisible(false);
    }
}
