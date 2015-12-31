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

/**
 *
 * @author Bryan
 */
public class CaseController extends MouseAdapter {
private final PartieDeDefJam game;
private final int y;
public CaseController(int y, PartieDeDefJam game){
    this.y = y;
    this.game = game;
}
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Bonjour"+" "+game.getPhase());
        if(game.getPhase()==0){
            for(Card c : game.getBoard().getCardTable()[4]){
                if(c==null || c.getName()== null || "".equals(c.getName())){
                    System.out.println("continue");
                continue;
                }

                System.out.println(c.getName()+"is going to defend ? "+c.isGoingToDefend());
                if(c.isGoingToDefend()){
                    c.setGoingToDefend(false);
                    for(int i = 0 ; i < 6 ; i++){
                        for(int j = 0 ; j < 4 ; j++){
                            if(game.getBoard().getCardTable()[i][j] == null){
                                continue;
                            }
                            System.out.println("TAB["+i+"]["+j+"] = "+game.getBoard().getCardTable()[i][j].getName());
                        }
                    }
                    try {
                    //System.out.println("yolo :"+game.getBoard().getCardTable()[2][y].getName()+" is attacking ?"+game.getBoard().getCardTable()[2][y].isAttacking()+" is dead? "+ game.getBoard().getCardTable()[2][y].isDestroyed());
                    if(game.getBoard().getCardTable()[2][y].isAttacking()){
                        System.out.println("il y a bien une carte en face à Y= "+y);
                        game.getBoard().addToBattle(c, c.getPlayer(), y, game.getPhase());
                    }
                    }
                    catch(NullPointerException n){
                        System.out.println("Pas de carte adverse");
                    }

                }
            }
        }
    }

    
}
