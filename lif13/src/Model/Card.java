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
public class Card extends Observable{
    
    private String name;
    private int cost;
    private int atk;
    private int def;
    private boolean exhausted;
    private boolean attacking;
    private boolean defensing;

    public Card(String name, int cost, int atk, int def) {
        this.name = name;
        this.cost = cost;
        this.atk = atk;
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public boolean isExhausted() {
        return exhausted;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public boolean isDefensing() {
        return defensing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setExhausted(boolean exhausted) {
        this.exhausted = exhausted;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public void setDefensing(boolean defensing) {
        this.defensing = defensing;
    }
   
    
    
}
