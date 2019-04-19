package content;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Riley
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
            System.out.println("Adding card number: " + x);
            hand.add(Game.gameDeck.cards.get(0));
            Game.gameDeck.cards.remove(0);
        }
    }

    //shuffle the player's hand
    public void shuffle() {
        Collections.shuffle(hand);
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
