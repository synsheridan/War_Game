/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war_game;

import java.util.*;

/**
 *
 * @author Enan
 */
public class Deck {
    private final int deckSize = 52;
    public Card[] cards = new Card[deckSize];
    ArrayList<Card> deck;
    
    public Deck() {
        int countCards = 0;
        for(Card.Suit s: Card.Suit.values()){
            for(Card.Value v: Card.Value.values()){
                cards[countCards] = (new Card(s,v));
                countCards++;
            }
        }
        deck = new ArrayList<>(Arrays.asList(cards));
        
        Collections.shuffle(deck);
        
        
    }
    
    public List<Card> dealPlayerOne(){
        return deck.subList(0, 25);
    }
    
    public List<Card> dealPlayerTwo(){
        return deck.subList(26, 51);
    }
    
    // split into 2 equal ArrayLists which will later be given to each player (containing unique random cards)
}
