/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war_game;

import java.util.ArrayList;

/**
 *
 * @author Enan
 */
public class Player {
    ArrayList<Card> hand = new ArrayList<>();
    
    private int points = 0;
    
    public Player(ArrayList<Card> list) {
        hand.addAll(list);
    }
    
    public int getPoints() {
        return points;
    }
    
    public void roundWin() {
        points += 2; //can only win 2s each turn
    }
    
    public void warWin() {
        points += 8; //can only win 2s each turn
    }
    
    public int getHandSize() {
        return hand.size();
    }
    
    public Card playCard() {
        Card playedCard = hand.get(hand.size() - 1); //Saves card to be returned
        hand.remove(hand.size() - 1); //deletes card
        return playedCard; //returns deleted card
    }
    
    public void WarDiscard() { // discards 3 cards
        
        for(int i = 0; i < 3; i++){
            hand.remove(hand.size() - 1);
        }
    }
}
