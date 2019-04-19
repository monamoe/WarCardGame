package panes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Abdulrahman
 */
public class gameOverPage extends Pane {

    public static Label winnerLabel = new Label();
    private Button endProgram = new Button("Exit");

    public gameOverPage() {
        this.getChildren().add(winnerLabel);
        this.getChildren().add(endProgram);

        winnerLabel.setLayoutX(100);
        winnerLabel.setLayoutY(100);
        endProgram.setLayoutX(100);
        endProgram.setLayoutY(200);

    }

}
