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
    private final int length;
    private final int width;
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
        System.out.println("AddToField "+card.getName());
        int field ;
        
        int defend = 0;
        if(phase==defend && card.getX()==2)
            field = 1;
        else if(phase==defend && card.getX()==3)
            field = 4;
        else
            field = 4;
        
        System.out.println("field = "+field+" Card  = "+card.getName());
        card.setX(field);
        card.setY(card.getYDépart());
        card.setAttacking(false);
        card.setDefensing(false);
        card.setExhausted(false);
        if(phase == defend)
            card.setExhausted(true);
        if(phase != 1) {
        } else {
            player.decreaseRessources(card.getCost());
        }
        this.cardTable[field][card.getYDépart()]=card;
        setChanged();
        notifyObservers();
    }
    
    public void addToBattle(Card card, Player player, int y, int phase){
        System.out.println("AddToBattle "+card.getName());
        int battle = 3;
        int defend = 0;
        int attack = 2;
        if (!card.isExhausted()){

            card.setX(battle);
            card.setY(y);
            if (phase==attack){
                card.setAttacking(true);
                System.out.println(card.getName() +" is attacking "+ card.isAttacking());
            }
            else if (phase==defend)
                card.setDefensing(true);
        this.cardTable[battle][y]=card;
        }
        setChanged();
        notifyObservers();
    }
    
    public void destroyCard(Card card) {
            System.out.println("Je détruit "+card.getName());
            try{
            System.out.println("NOM ="+cardTable[card.getX()][card.getY()].getName());
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("carte deja détruite");
            }
            card.setX(30);
            card.setY(30);
            card.setDestroyed(true);
            System.out.println(card.getName());
            
            setChanged();
            notifyObservers();
    }
    
    
}
