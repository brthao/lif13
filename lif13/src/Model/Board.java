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
    private int length;
    private int width;
    int MainJ1 = 0;
    int FieldJ1 = 1;
    int BattleJ1 = 2;
    int BattleJ2 = 3;
    int FieldJ2 = 4;
    int MainJ2 = 5;
    
    private Card cardTable[][];
    private Player players[];

    public Board(int length, int width, Player[] players) {
        this.length = length;
        this.width = width;
        this.players = players;
        cardTable = new Card[6][4];
    }

    public Card[][] getCardTable() {
        return cardTable;
    }

    public void setCardTable(Card[][] cardTable) {
        this.cardTable = cardTable;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
    public void initialiseMain(Card J1[], Card J2[]){
        this.cardTable[MainJ1] = J1;
        this.cardTable[MainJ2] = J2;
    }
    
    public void addToField(Card card, Player player){
        int field;
        if (player == this.players[0])
            field = FieldJ1;
        else
            field = FieldJ2;
        this.cardTable[field][card.getYDépart()]=card;
        this.cardTable[field][card.getYDépart()].setX(field);
        this.cardTable[field][card.getYDépart()].setY(card.getYDépart());   
        this.cardTable[card.getX()][card.getY()] = null;

    }
    
    public void addToBattle(Card card, Player player, int y){
        int battle;
        if (player == this.players[0])
            battle = BattleJ1;
        else
            battle = BattleJ2;
        int i =0;
        while(this.cardTable[battle][i]!=null || i<4){
            i++;
        }
        if(this.cardTable[battle][i]!=null){
            this.cardTable[battle][i]=card;
            this.cardTable[battle][i].setX(battle);
            this.cardTable[battle][i].setY(i);
            this.cardTable[card.getX()][card.getY()] = null;
        }
    }
}
