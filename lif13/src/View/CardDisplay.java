/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CardController;
import Model.Card;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 *
 * @author p1508674
 */
public class CardDisplay extends javax.swing.JPanel implements ActionListener, Observer{

    private Card card;
    private int xpos;
    private int ypos;

    public Card getCard() {
        return card;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

   
    
    /**
     * Creates new form CardDisp
     */
    public CardDisplay() {
        this.card = new Card();
        initComponents();
    }
    public CardDisplay(Card card){
        this.card = card;
        initComponents();
        this.card.addObserver(this);
        this.addMouseListener(new CardController(this.card));
        name.setText(card.getName());
        cost.setText(String.valueOf(card.getCost()));
        attack.setText(String.valueOf(card.getAtk()));
        defense.setText(String.valueOf(card.getDef()));
        this.setVisible(true);
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        cost = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        attackLabel = new javax.swing.JLabel();
        attack = new javax.swing.JLabel();
        defenseLabel = new javax.swing.JLabel();
        defense = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setFocusable(false);
        setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        nameLabel.setText("Name :");

        costLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        costLabel.setText("Cost : ");

        cost.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cost.setText("cost");

        name.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        name.setText("name");

        attackLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        attackLabel.setText("Attack : ");

        attack.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        attack.setText("atk");

        defenseLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        defenseLabel.setText("Defense :");

        defense.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        defense.setText("def");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(attackLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(costLabel)
                        .addGap(7, 7, 7)
                        .addComponent(cost))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(defenseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(defense)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(costLabel)
                    .addComponent(cost)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attackLabel)
                    .addComponent(attack)
                    .addComponent(defenseLabel)
                    .addComponent(defense))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attack;
    private javax.swing.JLabel attackLabel;
    private javax.swing.JLabel cost;
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel defense;
    private javax.swing.JLabel defenseLabel;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setBackground(Color.red);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (card.isEmpty()){
            name.setText("");
            cost.setText("");
            attack.setText("");
            defense.setText("");
            nameLabel.setText("");
            costLabel.setText("");
            defenseLabel.setText("");
            attackLabel.setText("");
      }
        else{
        name.setText(card.getName());
        cost.setText(String.valueOf(card.getCost()));
        attack.setText(String.valueOf(card.getAtk()));
        defense.setText(String.valueOf(card.getDef()));
        nameLabel.setText("Name: ");
            costLabel.setText("Cost :");
            defenseLabel.setText("Defense : ");
            attackLabel.setText("Attack : ");
            setXpos(card.getX());
            setYpos(card.getY());
            
        }
        
    }

    public JLabel getAttack() {
        return attack;
    }

    public void setAttack(JLabel attack) {
        this.attack = attack;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
}
