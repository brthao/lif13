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
    int HandJ1 = 0;
    int FieldJ1 = 1;
    int BattleJ1 = 2;
    int BattleJ2 = 3;
    int FieldJ2 = 4;
    int HandJ2 = 5;
    
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
    
    public void initialiseHand(Card J1[], Card J2[]){
        this.cardTable[HandJ1] = J1;
        this.cardTable[HandJ2] = J2;
    }
    
    public void addToField(Card card, Player player, int phase){
        int field;
        int defend = 0;
        if (player == this.players[0])
            field = FieldJ1;
        else
            field = FieldJ2;
        this.cardTable[field][card.getYDépart()]=card;
        this.cardTable[field][card.getYDépart()].setX(field);
        this.cardTable[field][card.getYDépart()].setY(card.getYDépart());   
        this.cardTable[card.getX()][card.getY()] = null;
        this.cardTable[field][card.getYDépart()].setAttacking(false);
        this.cardTable[field][card.getYDépart()].setDefensing(false);
        if(phase == defend)
            this.cardTable[field][card.getYDépart()].setExhausted(true);
    }
    
    public void addToBattle(Card card, Player player, int y, int phase){
        int battle;
        int defend = 0;
        int attack = 2;
        if (player == this.players[0])
            battle = BattleJ1;
        else
            battle = BattleJ2;
        if (this.cardTable[battle][y]==null&&!card.isExhausted()){
            this.cardTable[battle][y]=card;
            this.cardTable[battle][y].setX(battle);
            this.cardTable[battle][y].setY(y);
            if (phase==attack)
                this.cardTable[battle][y].setAttacking(true);
            if (phase==defend)
                this.cardTable[battle][y].setDefensing(true);
            this.cardTable[card.getX()][card.getY()] = null;
        }
    }

    public void destructCard(Card card) {
        this.cardTable[card.getX()][card.getY()]=null;
    }
}
