/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import content.Game;
import static content.Game.player1;
import static content.Game.player2;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Abdulrahman
 */
public class gamePage extends Pane {

    //round counter
    int roundCounter = 1;

    //holds the user's name, cards remaining
    public static Label player1Information = new Label("");
    public static Label player2Information = new Label("");
    public static Label roundInformation = new Label("Round Information: ");

    private Button playerPlay = new Button("Draw Cards");
    private Button playerSurrender = new Button("Surrender");

    //IMAGES
    private ImageView heartsImage = new ImageView("images/hearts.png");
    private ImageView diamondsImage = new ImageView("images/diamonds.png");
    private ImageView clubsImage = new ImageView("images/clubs.jpg");
    private ImageView spadesImage = new ImageView("images/spade.png");
    private Pane cardIcon = new Pane();

    public gamePage() {
        //set layouts
        setLayouts();

        //updating the text in the info labels
        updateInfoLabels();

        playerPlay.setOnAction(new playTurn());

        //adding to the pane
        this.getChildren().add(player1Information);
        this.getChildren().add(player2Information);
        this.getChildren().add(playerPlay);
        this.getChildren().add(playerSurrender);
        this.getChildren().add(roundInformation);

        //images
        this.getChildren().add(spadesImage);
        this.getChildren().add(heartsImage);
        this.getChildren().add(diamondsImage);
        this.getChildren().add(clubsImage);

    }

    //sets the layouts for all of the elements
    public void setLayouts() {
        player1Information.setLayoutX(20);
        player2Information.setLayoutX(20);
        player1Information.setLayoutY(450);
        player2Information.setLayoutY(20);
        roundInformation.setLayoutX(500);
        roundInformation.setLayoutY(20);

        //player buttons
        playerPlay.setLayoutX(400);
        playerPlay.setLayoutY(400);
        playerSurrender.setLayoutX(400);
        playerSurrender.setLayoutY(200);

        int imageslayoutx = 250;
        int imageslayouty = 200;
        int imageswidth = 150;
        int imagesheight = 200;

        spadesImage.setLayoutX(imageslayoutx);
        spadesImage.setLayoutY(imageslayouty);
        spadesImage.setFitWidth(imageswidth);
        spadesImage.setFitHeight(imagesheight);
        
        heartsImage.setLayoutX(imageslayoutx);
        heartsImage.setLayoutY(imageslayouty);
        heartsImage.setFitWidth(imageswidth);
        heartsImage.setFitHeight(imagesheight);
        
        diamondsImage.setLayoutX(imageslayoutx);
        diamondsImage.setLayoutY(imageslayouty);
        diamondsImage.setFitWidth(imageswidth);
        diamondsImage.setFitHeight(imagesheight);
        
        clubsImage.setLayoutX(imageslayoutx);
        clubsImage.setLayoutY(imageslayouty);
        clubsImage.setFitWidth(imageswidth);
        clubsImage.setFitHeight(imagesheight);
        
        
        

    }

    //updates the information in the users labels
    public static void updateInfoLabels() {
        try {
            player1Information.setText("Player 1 Information: \n" + Game.player1.getPlayerID() + "\n" + Game.player1.getSize() + " Cards Remaining.");
            player2Information.setText("Player 2 Information: \n" + Game.player2.getPlayerID() + "\n" + Game.player2.getSize() + " Cards Remaining.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //action event for drawing a card
    public class playTurn implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //try catch statement that checks if the one of the array lsits have no indexes left
            try {
                //make sure the game is still going on
                System.out.println(player1.hand.size());
                if (player1.hand.size() > 0 && player2.hand.size() > 0) {
                    System.out.println("Round number: " + roundCounter);
                    roundCounter++;

                    //compare to see who wins the 2 cards
                    System.out.println("playing a round");
                    switch (Game.compare(player1.hand.get(0), player2.hand.get(0))) {
                        case 1:
                            System.out.println("player 1 wins!");
                            //player one wins this round
                            Game.play(player1, player2, 1);
                            roundInformation.setText("Round Information: \n---------------"
                                    + "Round Number: " + roundCounter + "\n"
                                    + player1.getPlayerID() + " Won this round!");
                            updateInfoLabels();
                            break;
                        case 2:
                            System.out.println("player 2 wins!");
                            //player two wins this round
                            Game.play(player2, player1, 1);
                            roundInformation.setText("Round Information: \n---------------"
                                    + "Round Number: " + roundCounter + "\n"
                                    + player2.getPlayerID() + " Won this round!");
                            updateRoundInfo(player2.getPlayerID() + " Won this round!");
                            updateInfoLabels();
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
                                    updateRoundInfo(player1.getPlayerID() + " won the war");
                                    Game.play(player1, player2, 1);
                                    break;
                                case 2:
                                    updateRoundInfo(player2.getPlayerID() + " won the war!");
                                    Game.play(player2, player1, 1);
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
            updateInfoLabels();
        }
    }

    //updates the round information label
    public void updateRoundInfo(String input) {
        roundInformation.setText("Round Information: \n---------------\n" + input);
    }
}
