/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Board;
import Model.Card;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Nathan
 */
public class CardController extends MouseAdapter {
    private Card card;
    
    public CardController(Card card){
        this.card=card;
    }
    
    public void mouseClicked(MouseEvent e) {
        if(this.card.getBoard() == null){
            return;
        }
        this.card.getBoard().addToBattle(this.card, card.getPlayer(),3 ,3);
    }
}
