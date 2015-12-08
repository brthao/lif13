/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;
import java.util.Observer;

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
        this.Phase = Defense;
        this.ActivePlayer=Players[0];
    }

    
    public void playerAttacked(Card card, Player playerAttacking,Player playerDefending ){
        boolean defenseActive=false;
        for(Card c : board.getCardTable()[3])
            if(c.isDefensing()&&c.getY()==card.getY()){
                playerDefend(card, c);
                defenseActive=true;
                break;
            }
        if(defenseActive==false){
            playerDefending.decreasePdv(card.getAtk()); 
            this.board.addToField(card, ActivePlayer, this.Phase);
        }
                 
        if (playerDefending.getPOINTS_DE_VIE()<=0)
           this.setPartieTerminee(true);
        setChanged();
	notifyObservers();
    }
    
    public void playerDefend(Card cardAttack, Card cardDefense) {
        if (cardAttack.getAtk()>=cardDefense.getDef()&&cardAttack.getDef()>cardDefense.getAtk()){
            this.board.destroyCard(cardDefense);
            this.board.addToField(cardAttack, ActivePlayer, this.Phase);}
        if (cardAttack.getAtk()>=cardDefense.getDef()&&cardAttack.getDef()<=cardDefense.getAtk()){
            this.board.destroyCard(cardAttack);
            this.board.destroyCard(cardDefense);
        }
        if (cardAttack.getAtk()<cardDefense.getDef()&&cardAttack.getDef()<=cardDefense.getAtk())
            this.board.destroyCard(cardAttack);
        setChanged();
	notifyObservers();
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
        if(Phase == Defense){
            if(ActivePlayer==Players[0]){
                for(Card c : Players[1].getCards()){
                    if(c.isAttacking())
                        playerAttacked(c,c.getPlayer(),ActivePlayer);
                }
            }
            if(ActivePlayer==Players[1]){
                for(Card c : Players[0].getCards()){
                    if(c.isAttacking())
                        playerAttacked(c,c.getPlayer(),ActivePlayer);
                }
            }}
        if (this.Phase != Attaque)
            this.Phase = this.Phase+1;
        else{
            this.Phase = 0;
            nextPlayer();
        }
       setChanged();
        notifyObservers();
    }
    
    public int getTour() {
        return tour;
    }

    public void upTour() {
        Players[0].setHasPlayed(false);
        Players[1].setHasPlayed(false);
        Players[0].upRessources();
        Players[1].upRessources();
        this.tour = tour+1;
    }
    
    public void initiateObserver(Observer o){
        this.addObserver(o);
        this.getBoard().addObserver(o);
        this.getPlayers()[0].addObserver(o);
        this.getPlayers()[1].addObserver(o);
    }

    public Boolean getPartieTerminee() {
        return PartieTerminee;
    }

    public void setPartieTerminee(Boolean PartieTerminee) {
        this.PartieTerminee = PartieTerminee;
        setChanged();
	notifyObservers();
    }

    public Player[] getPlayers() {
        return Players;
    }


    public void nextPlayer(){
        this.ActivePlayer.setHasPlayed(true);
        if(Players[0].isHasPlayed()&&Players[1].isHasPlayed())
            upTour();
        if(this.ActivePlayer==Players[0])
            this.ActivePlayer=Players[1];
        else
            this.ActivePlayer=Players[0];
        setChanged();
        notifyObservers("Changement");
    }
    
}
