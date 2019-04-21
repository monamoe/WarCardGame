package wargame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author rileygray
 * @editor monamoe
 */
public class WarPlayer extends Player {

    public ArrayList<Card> hand = new ArrayList();
    private int handSize;

    public WarPlayer(String name) {
        super(name);
        this.handSize = 26;
    }

    //sets up the player's hand
    @Override
    public void play() {
        System.out.println("Moving cards form the deck to the player's hand");
        //loops through the player's hand
        for (int x = 0; x < this.handSize; x++) {
            hand.add(Game.gameDeck.cards.get(0));
            Game.gameDeck.cards.remove(0);
        }
    }

    //shuffle the player's hand
    public void shuffle() {
        Collections.shuffle(hand);
    }

    //update the card image
    public void updateCardImage(int input) {
        try {
            //if the player is player1
            if (this.getPlayerID() == Game.player1.getPlayerID()) {
                gamePage.heartsPlayer1.setVisible(false);
                gamePage.spadesPlayer1.setVisible(false);
                gamePage.clubsPlayer1.setVisible(false);
                gamePage.diamondsPlayer1.setVisible(false);
                switch (this.hand.get(input).getSuit().toString()) {
                    case "hearts":
                        gamePage.heartsPlayer1.setVisible(true);
                        break;
                    case "spades":
                        gamePage.spadesPlayer1.setVisible(true);
                        break;
                    case "clubs":
                        gamePage.clubsPlayer1.setVisible(true);
                        break;
                    case "diamonds":
                        gamePage.diamondsPlayer1.setVisible(true);
                        break;
                }
            } else {
                gamePage.heartsPlayer2.setVisible(false);
                gamePage.spadesPlayer2.setVisible(false);
                gamePage.clubsPlayer2.setVisible(false);
                gamePage.diamondsPlayer2.setVisible(false);
                switch (this.hand.get(input).getSuit().toString()) {
                    case "hearts":
                        gamePage.heartsPlayer2.setVisible(true);
                        break;
                    case "spades":
                        gamePage.spadesPlayer2.setVisible(true);
                        break;
                    case "clubs":
                        gamePage.clubsPlayer2.setVisible(true);
                        break;
                    case "diamonds":
                        gamePage.diamondsPlayer2.setVisible(true);
                        break;
                }
            }
        } catch (Exception e) {

        }

    }

//    @Override
//    //print statement for the player
//    public String toString() {
//        String output = "" + ;
//        return output;
//    }
//setters and getters//
    public int getSize() {
        if (this.hand.size() > 0) {
            return this.hand.size();
        } else {
            return 0;
        }
    }

    public void setSize(int size) {
        this.handSize = size;
    }

}
