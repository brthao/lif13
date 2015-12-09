/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Board;
import Model.Card;
import Model.PartieDeDefJam;
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
        if(this.card.getGame().getBoard() == null){
            return;
        }
      if(this.card.getGame().getPhase()==1 && card.getPlayer().getNB_RESSOURCES() >= card.getCost()&&this.card.getX()==5 && e.getClickCount()==2 && !e.isConsumed()){
            this.card.getGame().getBoard().addToField(this.card, card.getPlayer(),card.getGame().getPhase());   
        }
      if(this.card.isOnField()&&card.getGame().getPhase()==2&&!this.card.isExhausted()){
          this.card.getGame().getBoard().addToBattle(card, card.getPlayer(), card.getY(), card.getGame().getPhase());
      }
      if(card.getGame().getPhase()==0&&!this.card.isExhausted()){
          this.card.setGoingToDefend(true);
          System.out.println("YO ! "+this.card.getName() + "is going to defend ?"+this.card.isGoingToDefend());
      }
      
    }
    
    
}
