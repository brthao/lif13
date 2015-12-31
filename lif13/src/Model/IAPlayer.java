/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class IAPlayer extends Player{
    
    public void jouerTour(){
        Player adv;
        Player pl[] = getCards().get(0).getGame().getPlayers();
        if(pl[0] == this){
            adv = pl[1];
        }
        else{
            adv = pl[0];
        }
        PartieDeDefJam g = getCards().get(0).getGame();
        boolean dejaDefendu = false;
       
        ArrayList<Integer> YDefendus = new ArrayList<>();
        System.out.println("Debut tour IA");
        
        //pour IA facile on va defendre que si pv < 5 => on ne va pas attacker avec moins de 5 pv
        for(Card c : getCards()){
            if(c.getX() == 4 && !c.isExhausted() && !c.isDestroyed()){//sur le field
                //peut defendre
                
                for(Card atk : adv.getCards()){
                    if(atk.getX() == 2){//pour chaque carte attaquante
                        
                        System.out.println(c.getName()+" defend contre "+atk.getName());
                        for(Integer i : YDefendus){
                            if(i == atk.getY()){
                                dejaDefendu=true;
                                break;
                            }
                        }
                        if(!dejaDefendu){
                            c.setGoingToDefend(true);
                            YDefendus.add(atk.getY());
                            c.getGame().getBoard().addToBattle(c, this, atk.getY(), 0);
                            break;
                        }
                    }
                    dejaDefendu = false;
                }
            }
        }
        g.nextPhase();
        System.out.println("Defense finie");
        
        //Invocation
        for(Card c : getCards()){
            if(c.getX() == 5){//dans la main
                if(getNB_RESSOURCES() >= c.getCost()){
                    System.out.println("On joue "+c.getName());
                    c.getGame().getBoard().addToField(c, this, 1);
                }
            }
        }
        g.nextPhase();
        System.out.println("Invocation finie");
        
        //Attaque
        if(getPOINTS_DE_VIE() > 5 ){
           for(Card c : getCards()){
               if(c.getX() == 4 && !c.isDestroyed()){//sur le field

                       System.out.println("On attaque avec "+c.getName());
                       c.setAttacking(true);
                       c.getGame().getBoard().addToBattle(c, this, c.getY(), 2);

               }
           }
        }
        g.nextPhase();
        
    }
    
}
