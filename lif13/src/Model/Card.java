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
    private boolean goingToDefend;
    private boolean empty;
    private int x;
    private int y;
    private int YDépart;
    private Player player;
    private Board board;
    private PartieDeDefJam game;
    private boolean destroyed;

    public Card(){
     this.empty=true;   
    }
    public Card(String name, int cost, int atk, int def) {
        this.name = name;
        this.cost = cost;
        this.atk = atk;
        this.def = def;
        this.empty=false;
        this.goingToDefend=false;
        this.destroyed=false;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        setChanged();
	notifyObservers();
    }

    public int getY() {
        return y;
        
    }

    public void setY(int y) {
        this.y = y;
        setChanged();
	notifyObservers();
    }

    public int getYDépart() {
        return YDépart;
    }

    public void setYDépart(int YDépart) {
        this.YDépart = YDépart;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
   
     public boolean isEmpty() {
        return empty;
    }

    public Board getBoard() {
        return board;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setEmptyTrue() {
        this.empty = true;
        this.atk = 0;
        this.def = 0;
        this.name = "";
        this.cost = 0;
        setChanged();
	notifyObservers();
    }

    public PartieDeDefJam getGame() {
        return game;
    }

    public void setGame(PartieDeDefJam game) {
        this.game = game;
        this.board = game.getBoard();
    }
    
     public boolean isOnField(){
         return this.x==4;
     }

    public boolean isGoingToDefend() {
        return goingToDefend;
    }

    public void setGoingToDefend(boolean goingToDefend) {
        this.goingToDefend = goingToDefend;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
        
    }
    
    
    
}
