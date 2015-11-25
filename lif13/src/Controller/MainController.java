/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
        MainView mv = new MainView(p1,p2);
        mv.setVisible(true);
    }
    
}
