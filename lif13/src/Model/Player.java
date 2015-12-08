/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author p1511624
 */
public class Player extends Observable{

    
    private String NOM;
    private int POINTS_DE_VIE;
    private int NB_RESSOURCES;
    private int NB_RESSOURCES_MAX;
    private ArrayList<Card> Cards;
    private boolean hasPlayed;
    private boolean attacking = false;

    

    public Player(String Nom){
        this.NOM=Nom;
        this.POINTS_DE_VIE = 10;
        this.NB_RESSOURCES = 1;
        this.NB_RESSOURCES_MAX = 1;
        Cards=new ArrayList<>();
    }
    
    public Player(){
        this.POINTS_DE_VIE = 10;
        this.NB_RESSOURCES = 1;
        this.NB_RESSOURCES_MAX = 1;
        Cards=new ArrayList<>();
    }
    public void setNOM(String NOM) {
        this.NOM = NOM;
    }
    

   
    public void upRessources(){
        this.setNB_RESSOURCES_MAX(this.getNB_RESSOURCES_MAX()+1);
        this.setNB_RESSOURCES(this.getNB_RESSOURCES_MAX());
    }
    
    public void decreaseRessources(int i){
        this.setNB_RESSOURCES(this.getNB_RESSOURCES()-i);
    }
    
    public void decreasePdv(int i){
        this.setPOINTS_DE_VIE(this.getPOINTS_DE_VIE()-i);
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

    public ArrayList<Card> getCards() {
        return Cards;
    }

    public void setCards(ArrayList<Card>Cards) {
        this.Cards = Cards;
    }

    public boolean isHasPlayed() {
        return hasPlayed;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
    
    
}
