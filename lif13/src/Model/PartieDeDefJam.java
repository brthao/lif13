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
public class PartieDeDefJam extends Observable{
    private Player[] Players ;
    private Board board;
    private Player ActivePlayer;
    private int Phase;
    private int tour;
    private Boolean PartieTerminee = false;
    int Defense = 0;
    int Invocation = 1;
    int Attaque = 2;
    
    
    
    public PartieDeDefJam(Player Player1, Player Player2){
        this.Players = new Player[2];
        this.Players[0]= Player1;
        this.Players[1]= Player2;
        this.board= new Board(5,4,this.Players);
        this.tour = 1;
    }

    
    public void playerAttacked(Card card, Player player, int x, int y){
        if (this.board.getCardTable()[x][y]!=null)
            playerDefending(card, this.board.getCardTable()[x][y]);
        else
            player.decreasePdv(card.getAtk());
        if (player.getPOINTS_DE_VIE()<=0)
            this.setPartieTerminee(true);
    }
    
    public void playerDefending(Card cardAttack, Card cardDefense) {
        if (cardAttack.getAtk()>=cardDefense.getDef()&&cardAttack.getDef()>cardDefense.getAtk())
            this.board.destructCard(cardDefense);
        if (cardAttack.getAtk()>=cardDefense.getDef()&&cardAttack.getDef()<=cardDefense.getAtk()){
            this.board.destructCard(cardAttack);
            this.board.destructCard(cardDefense);
        }
        if (cardAttack.getAtk()<cardDefense.getDef()&&cardAttack.getDef()<=cardDefense.getAtk())
            this.board.destructCard(cardAttack);
    }
    
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getActivePlayer() {
        return ActivePlayer;
    }

    public void setActivePlayer(Player ActivePlayer) {
        this.ActivePlayer = ActivePlayer;
    }

    public int getPhase() {
        return Phase;
    }

    public void setPhase(int Phase) {
        this.Phase = Phase;
    }

    public void nextPhase(){
        if (this.Phase != Attaque)
            this.Phase = this.Phase+1;
        else
            this.Phase = 0;
    }
    
    public int getTour() {
        return tour;
    }

    public void upTour() {
        this.tour = tour+1;
        setChanged();
	notifyObservers();
    }

    public Boolean getPartieTerminee() {
        return PartieTerminee;
    }

    public void setPartieTerminee(Boolean PartieTerminee) {
        this.PartieTerminee = PartieTerminee;
    }


    
    
}
