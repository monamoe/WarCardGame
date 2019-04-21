package wargame;

/**
 *
 * @author rileygray
 * @editor monamoe
 */
public class Game {

    //the two player objects references
    public static WarPlayer player1;
    public static WarPlayer player2;

    //builds and shuffles the player decks
    public static Deck gameDeck = new Deck(52);

    //moves cards from the winner to the loser
    public static void play(WarPlayer winner, WarPlayer loser, int amount) {
        for (int i = 0; i < amount + 1; i++) {
            //add the won card to the Winner's hand
            winner.hand.add(loser.hand.get(0));
            //remove lost card from the loser
            loser.hand.remove(0);
        }
        winner.shuffle();
        loser.shuffle();
    }

    //finds out which card is worth more.
    public static int compare(Card one, Card two) {

        int pOne = 0;
        int pTwo = 0;
        switch (one.getValue()) {
            case two:
                pOne = 2;
                break;
            case three:
                pOne = 3;
                break;
            case four:
                pOne = 4;
                break;
            case five:
                pOne = 5;
                break;
            case six:
                pOne = 6;
                break;
            case seven:
                pOne = 7;
                break;
            case eight:
                pOne = 8;
                break;
            case nine:
                pOne = 9;
                break;
            case ten:
                pOne = 10;
                break;
            case jack:
                pOne = 11;
                break;
            case queen:
                pOne = 12;
                break;
            case king:
                pOne = 13;
                break;
            case ace:
                pOne = 14;
                break;

        }
        switch (two.getValue()) {
            case two:
                pTwo = 2;
                break;
            case three:
                pTwo = 3;
                break;
            case four:
                pTwo = 4;
                break;
            case five:
                pTwo = 5;
                break;
            case six:
                pTwo = 6;
                break;
            case seven:
                pTwo = 7;
                break;
            case eight:
                pTwo = 8;
                break;
            case nine:
                pTwo = 9;
                break;
            case ten:
                pTwo = 10;
                break;
            case jack:
                pTwo = 11;
                break;
            case queen:
                pTwo = 12;
                break;
            case king:
                pTwo = 13;
                break;
            case ace:
                pTwo = 14;
                break;
        }
        if (pOne > pTwo) {
            return 1;
        } else if (pOne < pTwo) {
            return 2;
        }
        return 0;
    }

    //checks to see if there is a winner for the game
    public static void declareWinner() {
        if (player1.hand.size() > 0) {
            gameOverPage.updateLabel();
            WarGame.changeScene("winner");
        } else if (player2.hand.size() > 0) {
            gameOverPage.updateLabel();
            WarGame.changeScene("winner");
        }
    }

    //sets up the data for the players
    public static void setPlayers() {
        //user enters in text fields
        //retrives the data from the textfields, creates the player objects
        player1 = new WarPlayer(homePage.getPlayer1Name());
        player2 = new WarPlayer(homePage.getPlayer2Name());

        //sets up the hands for both players
        player1.play();
        player2.play();

    }
}
