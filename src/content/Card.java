/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

/**
 *
 * @author rileygray
 */
public class Card {

    public enum Suit {
        hearts, spades, clubs, diamonds
    }

    public enum Value {
        two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace
    }
    private Suit suit;
    private Value value;

    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
