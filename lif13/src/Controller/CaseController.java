/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Card;
import Model.PartieDeDefJam;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Bryan
 */
public class CaseController extends MouseAdapter {
private PartieDeDefJam game;
private int y;
public CaseController(int y, PartieDeDefJam game){
    this.y = y;
    this.game = game;
}
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Bonjour"+" "+game.getPhase());
        if(game.getPhase()==0){
        for(Card c : game.getBoard().getCardTable()[4]){
            if(c==null){
            continue;
            }
            if(c.isGoingToDefend()){
                System.out.println("Hello !");
                c.setGoingToDefend(false);
                game.getBoard().addToBattle(c, c.getPlayer(), y, game.getPhase());
                
            }
        }
        }
    }

    
}
