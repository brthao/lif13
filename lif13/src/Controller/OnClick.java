/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author p1508674
 */
public class OnClick extends MouseAdapter{
    
    private JPanel j;
    
    public OnClick(JPanel j) {
        this.j=j;
    }

    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        j.setBackground(Color.red);
    }
    
    
}
