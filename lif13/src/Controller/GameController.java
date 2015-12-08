/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Card;
import Model.PartieDeDefJam;
import View.GameView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author p1508674
 */
public class GameController {

    private MainController mc;
    private GameView gv;
    private PartieDeDefJam game;
    
    private ArrayList<JPanel> listPanel;
    
    public GameController(MainController mc) {
        this.mc = mc;
        listPanel  = new ArrayList<>();
        
        initialize();
    }
    
    public final void initialize(){
        gv = new GameView(this);
        gv.setVisible(true);
        
        
        listPanel = gv.getTabPanels();
        listPanel.stream().forEach((j) -> {
            j.addMouseListener(new MouseAction(j));
         });
        this.game = new PartieDeDefJam(mc.getP1(),mc.getP2());
        gv.getTour().setText(String.valueOf(game.getTour()));
        gv.setGame(game);
        gv.getGame().initiateObserver(gv);
        gv.getJoueurAct().setText(gv.getGame().getActivePlayer().getNOM());
        gv.getNbRessources().setText(gv.getGame().getActivePlayer().getNB_RESSOURCES()+"/"+gv.getGame().getActivePlayer().getNB_RESSOURCES_MAX());
        gv.getPdv().setText(String.valueOf(gv.getGame().getActivePlayer().getPOINTS_DE_VIE()));
        for(Card c : game.getPlayers()[0].getCards()){
            c.setBoard(game.getBoard());
        }
        for(Card c : game.getPlayers()[1].getCards()){
            c.setBoard(game.getBoard());
        }
        
        GestionPartie();
        
        
    }
    
    public void GestionPartie(){
        
        
        
        
    }

    public MainController getMc() {
        return mc;
    }
    
    
}
