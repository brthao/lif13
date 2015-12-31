/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.CardDisplay;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author p1508674
 */
public class MouseAction extends MouseAdapter{
    
    private java.awt.Component j;
    
    public MouseAction(CardDisplay j) {
        this.j=j;
    }
    
    public MouseAction(JPanel j){
        this.j = j;
    }

    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        //j.setBackground(Color.red);
         if(j instanceof CardDisplay){
            
        }
        
        else{
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(j instanceof CardDisplay){
            
            j.setBackground(Color.LIGHT_GRAY);
        }
        
        else{
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color color = new Color(r, g, b);
            j.setBackground(color);
            //j.setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(j instanceof CardDisplay){
            
            j.setBackground(Color.white);
        }
        else{
            
            j.setBackground(Color.white);
        }
    }
    
    
    
    
    
}
