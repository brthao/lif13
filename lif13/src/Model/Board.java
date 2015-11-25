/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;

/**
 *
 * @author p1508674
 */
public class Board extends Observable{
    private int lenght;
    private int width;
    private Card cardTable[][];

    public Board(int lenght, int width) {
        this.lenght = lenght;
        this.width = width;
    }
    
   public void initialize(){
       
   }
    
}
