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
    private Card MainJ1[];
    private Card MainJ2[];
    private Card FieldJ1[];
    private Card FieldJ2[];
    private Card BattleJ1[];
    private Card BattleJ2[];
    private Card cardTable[][];
    private Player players[];

    public Board(int length, int width, Player[] players) {
        this.length = length;
        this.width = width;
        this.players = players;
        MainJ1 = new Card[4];
        MainJ2 = new Card[4];
        FieldJ1 = new Card[4];
        FieldJ2 = new Card[4];
        BattleJ1 = new Card[4];
        BattleJ2 = new Card[4];
        cardTable = new Card[6][4];
    }

    public Card[] getMainJ1() {
        return MainJ1;
    }

    public void setMainJ1(Card[] MainJ1) {
        this.MainJ1 = MainJ1;
    }

    public Card[] getMainJ2() {
        return MainJ2;
    }

    public void setMainJ2(Card[] MainJ2) {
        this.MainJ2 = MainJ2;
    }

    public Card[] getFieldJ1() {
        return FieldJ1;
    }

    public void setFieldJ1(Card[] FieldJ1) {
        this.FieldJ1 = FieldJ1;
    }

    public Card[] getFieldJ2() {
        return FieldJ2;
    }

    public void setFieldJ2(Card[] FieldJ2) {
        this.FieldJ2 = FieldJ2;
    }

    public Card[] getBattleJ1() {
        return BattleJ1;
    }

    public void setBattleJ1(Card[] BattleJ1) {
        this.BattleJ1 = BattleJ1;
    }

    public Card[] getBattleJ2() {
        return BattleJ2;
    }

    public void setBattleJ2(Card[] BattleJ2) {
        this.BattleJ2 = BattleJ2;
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
    
    
}
