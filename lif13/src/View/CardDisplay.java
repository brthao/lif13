/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author p1508674
 */
public class CardDisplay extends javax.swing.JPanel {

    /**
     * Creates new form CardDisp
     */
    public CardDisplay() {
        initComponents();
    }
    public CardDisplay(String nam,int cst,int atk,int def){
        initComponents();
        name.setText(nam);
        cost.setText(String.valueOf(cst));
        attack.setText(String.valueOf(atk));
        defense.setText(String.valueOf(def));
        System.out.println("HELLO");
        this.setVisible(true);
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

        nameLabel.setText("Name :");

        costLabel.setText("Cost : ");

        cost.setText("cost");

        name.setText("name");

        attackLabel.setText("Attack : ");

        attack.setText("atk");

        defenseLabel.setText("Defense :");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
}
