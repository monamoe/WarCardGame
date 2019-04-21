package wargame;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author monamoe
 */
public class gameOverPage extends Pane {

    //basic font sizes
    private Font header1 = new Font("Courier", 20);

    public static Label winnerLabel = new Label();

    public gameOverPage() {
        this.getChildren().add(winnerLabel);

        winnerLabel.setMaxSize(100, 900);
        winnerLabel.setLayoutX(200);
        winnerLabel.setLayoutY(200);

        winnerLabel.setFont(header1);
    }

    //update the labels to the winner's name
    public static void updateLabel() {
        if (Game.player1.hand.size() > 0) {
            winnerLabel.setText(Game.player1.getPlayerID() + " Wins!");
        }
        if (Game.player2.hand.size() > 0) {
            winnerLabel.setText(Game.player2.getPlayerID() + " Wins!");
        }
    }

}
