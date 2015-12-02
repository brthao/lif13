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
    
    public PartieDeDefJam(Player Player1, Player Player2){
        this.Players = new Player[2];
        this.Players[0]= Player1;
        this.Players[1]= Player2;
        this.board= new Board(5,4,this.Players);
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

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public Boolean getPartieTerminee() {
        return PartieTerminee;
    }

    public void setPartieTerminee(Boolean PartieTerminee) {
        this.PartieTerminee = PartieTerminee;
    }
    
    
}
