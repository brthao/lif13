/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;

/**
 *
 * @author p1511624
 */
public class Player extends Observable{

    
    private final String NOM;
    private int POINTS_DE_VIE;
    private int NB_RESSOURCES;
    private int NB_RESSOURCES_MAX;
    

   

    public Player(String Nom){
        this.NOM=Nom;
        this.POINTS_DE_VIE = 10;
        this.NB_RESSOURCES = 0;
    }
    
    public void upRessources(){
        this.setNB_RESSOURCES_MAX(this.getNB_RESSOURCES_MAX()+1);
        this.setNB_RESSOURCES(this.getNB_RESSOURCES_MAX);
    }
    
    public int getNB_RESSOURCES_MAX() {
        return NB_RESSOURCES_MAX;
    }
    
    public void setNB_RESSOURCES_MAX(int NB_RESSOURCES_MAX) {
        this.NB_RESSOURCES_MAX = NB_RESSOURCES_MAX;
    }
    
    
    
    public int getPOINTS_DE_VIE() {
        return POINTS_DE_VIE;
    }

    public void setPOINTS_DE_VIE(int POINTS_DE_VIE) {
        this.POINTS_DE_VIE = POINTS_DE_VIE;
    }

    public int getNB_RESSOURCES() {
        return NB_RESSOURCES;
    }

    public void setNB_RESSOURCES(int NB_RESSOURCES) {
        this.NB_RESSOURCES = NB_RESSOURCES;
    }
    
    public String getNOM(){
        return this.NOM;
    }
}
