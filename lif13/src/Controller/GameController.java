/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;

/**
 *
 * @author p1508674
 */
public class GameController {

    private Player p1;
    private Player p2;
    
    public GameController(Player p1,Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        initialize();
    }
    
    public void initialize(){
        
    }
    
    
}
