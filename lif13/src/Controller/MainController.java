/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Card;
import Model.Player;
import View.CardDisplay;
import View.MainView;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author p1508674
 */
public class MainController {

        private GameController g;
        private ArrayList<CardDisplay> visuCard1;
        private ArrayList<CardDisplay> visuCard2;
        private Player p1;
        private Player p2;

    public ArrayList<CardDisplay> getVisuCard1() {
        return visuCard1;
    }

    public ArrayList<CardDisplay> getVisuCard2() {
        return visuCard2;
    }

    public void setG(GameController g) {
        this.g = g;
    }

        
    public GameController getG() {
        return g;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public MainController() {
        initialize();
    }
    
    public void initialize(){
         p1 = new Player();
         p2 = new Player();
        
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
        visuCard1 = new ArrayList<>();
        
        visuCard2 = new ArrayList<>();
        
          for(Card c : p1.getCards()){
            CardDisplay cd = new CardDisplay(c);
            cd.setVisible(true);
            cd.addMouseListener(new MouseAction(cd));
            visuCard1.add(cd);
            
        }
        
        for(Card c : p2.getCards()){
            CardDisplay cd = new CardDisplay(c);
            cd.setVisible(true);
            cd.addMouseListener(new MouseAction(cd));
            visuCard2.add(cd);
            
        }
        
    }
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        
        MainController mc = new MainController();
        
        //MainView mv = new MainView(mc.getP1(),mc.getP2(),mc.getG());
        MainView mv = new MainView(mc);
        mv.setVisible(true);
    }
    
}
