/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Card;
import Model.Player;
import View.MainView;

/**
 *
 * @author p1508674
 */
public class MainController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Player p1 = new Player();
        Player p2 = new Player();
        
        Card c1 = new Card("Orelsan",2,2,3);
        Card c2= new Card("Eminem",3,5,2);
        Card c3 = new Card("Snoop Dog",4,4,4);
        Card c4 = new Card("Nekfeu",1,2,2);
        p1.getCards().add(c1);
        p1.getCards().add(c2);
        p1.getCards().add(c3);
        p1.getCards().add(c4);
        
        Card c5 = new Card("Justin Bieber",1,3,1);
        Card c6 = new Card("Taylor Swift",2,2,3);
        Card c7 = new Card("Katy Perry",3,1,5);
        Card c8 = new Card("Lana Del Rey",4,4,4);
        p2.getCards().add(c5);
        p2.getCards().add(c6);
        p2.getCards().add(c7);
        p2.getCards().add(c8);
        
        
        MainView mv = new MainView(p1,p2);
        mv.setVisible(true);
    }
    
}
