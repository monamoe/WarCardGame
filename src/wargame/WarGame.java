package wargame;

import content.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import panes.*;

/**
 *
 * @author monamoe
 * @author rileygray
 */
public class WarGame extends Application {

    public static Stage primaryStage = new Stage();
    public static Scene homePageScene = new Scene(new homePage(), 700, 600);
    public static Scene gamePageScene = new Scene(new gamePage(), 700, 600);
    public static Scene gameOverPageScene = new Scene(new gameOverPage(), 700, 600);

    //creating the game object
    public static Game warCardGame;

    @Override
    public void start(Stage uselessStage) {
        //initial setup
        primaryStage.setTitle("War Game");
        primaryStage.setScene(homePageScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Changes the scene in the program
     *
     * @param inputScene
     */
    public static void changeScene(String inputScene) {
        switch (inputScene) {
            case "main":
                primaryStage.setScene(gamePageScene);
                break;
            case "winner":
                primaryStage.setScene(gameOverPageScene);
                break;
            default:
                break;

        }
    }

    public static void createGame() {
        warCardGame = new Game();
    }
}
