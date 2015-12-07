/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PartieDeDefJam;
import Model.Player;
import View.GameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
            j.addMouseListener(new OnClick(j));
         });
        this.game = new PartieDeDefJam(mc.getP1(),mc.getP2());
        gv.getTour().setText(String.valueOf(game.getTour()));
        gv.setGame(game);
        gv.getGame().addObserver(gv);
        gv.getNextTurn().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gv.getGame().upTour();
            }
        });
    }

    public MainController getMc() {
        return mc;
    }
    
    
}
