/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war_game;

/**
 *
 * @author Enan
 */
public class Card {
    public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS};
        public enum Value {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
        private final Suit suit;
        private final Value value;
        
        public Card(Suit s, Value v)
        {
           suit =s;
           value= v;
        }
	public Value getValue() {
		return this.value;
	}

	
	public Suit getSuit() {
		return this.suit;
        }
        
        @Override
        public String toString() {
            String toString = value + " of " + suit;
            return toString;
        }
}
