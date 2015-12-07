/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;
import View.GameView;
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

    private Player p1;
    private Player p2;
    private GameView gv;
  
    
    private ArrayList<JPanel> tabPanels;
    
    public GameController(Player p1,Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        tabPanels  = new ArrayList<>();
        
        initialize();
    }
    
    public final void initialize(){
        gv = new GameView();
        gv.setVisible(true);
        
        
        tabPanels = gv.getTabPanels();
        tabPanels.stream().forEach((j) -> {
            j.addMouseListener(new OnClick(j));
         });
        
    }
    
    
}
