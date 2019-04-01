/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war_game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Enan
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button start;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label points1;
    @FXML
    private Label points2;
    @FXML
    private Label cards1;
    @FXML
    private Label cards2;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label warlabel;
    @FXML
    private Label label6;
    @FXML
    private Label message1;
    @FXML
    private Label message2;
    @FXML
    private Label result;
    @FXML
    private Button btnwar;
    
    Player p1;
    Player p2;
    boolean gameOver;
    Card c1;
    Card c2;
    boolean war;
    

    @FXML
    private void handleButtonAction(ActionEvent event){
            start.setText("Continue");
        
            war = false;
            
            c1 = p1.playCard();
            c2 = p2.playCard();

            cards1.setText(c1.toString());
            cards2.setText(c2.toString());

            war = c1.getValue().ordinal() == c2.getValue().ordinal();
            
            if (war == true){
                warlabel.setText("WAR!!!");
                start.setVisible(false);
                btnwar.setVisible(true);
            }

            if (war == false) {
                warlabel.setText("There is no WAR.");
                message1.setText("");
                if (c1.getValue().ordinal() > c2.getValue().ordinal()) {
                    p1.roundWin();
                    message2.setText("Player 1 Wins 2 points!");
                } else {
                    p2.roundWin();
                    message2.setText("Player 2 Wins 2 points!");
                }
            }

            points1.setText("" + p1.getPoints());
            points2.setText("" + p2.getPoints());

            if (p1.getPoints() >= 26) {
                result.setText("Player 1 WINS THE GAME!!!");
                gameOver = true;
                start.setVisible(false);
            } else if (p2.getPoints() >= 26) {
                result.setText("Player 2 WINS THE GAME!!!");
                gameOver = true;
                start.setVisible(false);
            }
            
            /*if (gameOver == false) {
                System.out.println("Press any key to continue");
                System.in.read();
            }*/

        //} while (gameOver == false);
    }
    
    @FXML
    private void warButtonAction(ActionEvent event1){
                
                p1.WarDiscard();
                p2.WarDiscard();

                message1.setText("Both Players drop 3 more card face down and play a new card.");

                c1 = p1.playCard();
                c2 = p2.playCard();

                cards1.setText(c1.toString());
                cards2.setText(c2.toString());
                
                if (c1.getValue().ordinal() > c2.getValue().ordinal()) {
                    p1.warWin();
                    message2.setText("Player 1 Wins 8 points!");
                    war = false;
                    start.setVisible(true);
                    btnwar.setVisible(false);
                } else if (c1.getValue().ordinal() < c2.getValue().ordinal()) {
                    p2.warWin();
                    message2.setText("Player 2 Wins 8 points!");
                    war = false;
                    start.setVisible(true);
                    btnwar.setVisible(false);
                }
                
                points1.setText("" + p1.getPoints());
                points2.setText("" + p2.getPoints());

                if (p1.getPoints() >= 26) {
                    result.setText("Player 1 WINS THE GAME!!!");
                    gameOver = true;
                    start.setVisible(false);
                } else if (p2.getPoints() >= 26) {
                    result.setText("Player 2 WINS THE GAME!!!");
                    gameOver = true;
                    start.setVisible(false);
                }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameOver = false;

        Deck d = new Deck();
        ArrayList<Card> hand1 = new ArrayList<>(d.dealPlayerOne());
        ArrayList<Card> hand2 = new ArrayList<>(d.dealPlayerTwo());

        p1 = new Player(hand1);
        p2 = new Player(hand2);
        
        btnwar.setVisible(false);
        
        message1.setWrapText(true);
    }    
    
}
