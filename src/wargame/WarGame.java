package wargame;

import static wargame.Game.player2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rileygray
 * @editor monamoe
 */
public class WarGame extends Application {

    public static Stage primaryStage = new Stage();
    public static Scene homePageScene = new Scene(new homePage(), 500, 500);
    public static Scene gamePageScene = new Scene(new gamePage(), 500, 500);
    public static Scene gameOverPageScene = new Scene(new gameOverPage(), 500, 500);

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
                System.out.println("BEFORE TRY");
                try {
                    System.out.println("players2 name is:  " + player2.getPlayerID());
                    if (player2.getPlayerID().equals("CPU")) {
                        gamePage.player2Play.setVisible(false);
                    }
                } catch (Exception e) {

                }
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
