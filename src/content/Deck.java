package content;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rileygray
 * @editor monamoe
 */
public class Deck {

    //The group of cards, stored in an ArrayList
    public static ArrayList<Card> cards = new ArrayList();
    private int size;//the size of the grouping
    Card one;

    //creates the deck
    public Deck(int givenSize) {
        this.size = givenSize;
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Value v : Card.Value.values()) {
                one = new Card();
                one.setValue(v);
                one.setSuit(s);
                cards.add(one);
            }
        }
        Collections.shuffle(cards);
    }

}
