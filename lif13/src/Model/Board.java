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
    int HandJ1 = 5;
    int FieldJ1 = 4;
    int BattleJ1 = 3;
    int BattleJ2 = 2;
    int FieldJ2 = 1;
    int HandJ2 = 0;
    
    private Card cardTable[][];
    private Player players[];

    public Board(int length, int width, Player[] players) {
        this.length = length;
        this.width = width;
        this.players = players;
        cardTable = new Card[6][4];
        for (int i=0; i<5;i++){
            for (int j=0 ; j<3 ; j++){
                cardTable[i][j] = new Card();
            }
        }
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
        int field ;
        
        int defend = 0;
        if(phase==defend)
            field = 1;
        else
            field = 4;
        this.cardTable[field][card.getYDépart()]=card;
        card.setX(field);
        card.setY(card.getYDépart());   
        //destroyCard(this.cardTable[card.getX()][card.getY()]);
        card.setAttacking(false);
        card.setDefensing(false);
        if(phase == defend)
            card.setExhausted(true);
        if(phase == 1)
            player.decreaseRessources(card.getCost());
        setChanged();
        notifyObservers();
    }
    
    public void addToBattle(Card card, Player player, int y, int phase){
        int battle = 3;
        int defend = 0;
        int attack = 2;
        if (!card.isExhausted()){
            this.cardTable[battle][y]=card;
            card.setX(battle);
            card.setY(y);
            if (phase==attack){
                card.setAttacking(true);
            }
            if (phase==defend)
                card.setDefensing(true);
            //destroyCard(this.cardTable[card.getX()][card.getY()]);
        }
        setChanged();
        notifyObservers();
    }
    
    public void destroyCard(Card card) {
            this.cardTable[card.getX()][card.getY()].setEmptyTrue();
            setChanged();
            notifyObservers();
    }
    
    
}
