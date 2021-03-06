/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.metier.ArbreBinaireFacade;
import be.esi.alg2.arbre.mvc.Modele;
import be.esi.alg2.arbre.mvc.NoeudBinaire;
import be.esi.alg2.arbre.mvc.ProfondeurMaximaleAtteinteException;
import be.esi.alg2.arbre.mvc.Valeur;
import javax.swing.JOptionPane;

/**
 *
 * @author marty
 */
public class AjoutNoeudDialog extends javax.swing.JDialog {

    /**
     * Creates new form AjoutNoeudGUI
     */
    private NoeudBinaire noeud;
    private Modele modele;

    public AjoutNoeudDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.modele = ArbreBinaireFacade.getModele();
    }

    public Modele getModele() {
        return modele;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NorthPanel = new javax.swing.JPanel();
        libellePane = new javax.swing.JPanel();
        LibelleLab = new javax.swing.JLabel();
        libField = new javax.swing.JTextField();
        clePane = new javax.swing.JPanel();
        cleLab = new javax.swing.JLabel();
        cleField = new javax.swing.JTextField();
        CenterPanel = new javax.swing.JPanel();
        erreurLabel = new javax.swing.JLabel();
        SouthPanel = new javax.swing.JPanel();
        valideButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajout d'un noeud");
        setMinimumSize(new java.awt.Dimension(149, 139));

        NorthPanel.setLayout(new java.awt.BorderLayout());

        LibelleLab.setText("Libellé : ");
        libellePane.add(LibelleLab);

        libField.setColumns(20);
        libellePane.add(libField);

        NorthPanel.add(libellePane, java.awt.BorderLayout.PAGE_END);

        clePane.setMinimumSize(new java.awt.Dimension(46, 46));

        cleLab.setText("Clé : ");
        clePane.add(cleLab);

        cleField.setColumns(20);
        clePane.add(cleField);

        NorthPanel.add(clePane, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(NorthPanel, java.awt.BorderLayout.NORTH);

        CenterPanel.add(erreurLabel);

        getContentPane().add(CenterPanel, java.awt.BorderLayout.CENTER);

        SouthPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        valideButton.setText("Valider");
        valideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valideButtonActionPerformed(evt);
            }
        });
        SouthPanel.add(valideButton);

        cancelButton.setText("Annuler");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        SouthPanel.add(cancelButton);

        getContentPane().add(SouthPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valideButtonActionPerformed
        // TODO add your handling code here:
        if (verif()) {
            this.erreurLabel.setText("");
            Valeur val = new Valeur(
                    Integer.parseInt(this.cleField.getText()),
                    this.libField.getText());
            try {
                modele.addValeur(val);
                this.dispose();
            } catch (ProfondeurMaximaleAtteinteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            this.repaint();
        }else{
            this.erreurLabel.setText("la clé doit etre >= à 0");
        }
    }//GEN-LAST:event_valideButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public NoeudBinaire getNoeud() {
        return noeud;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjoutNoeudDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutNoeudDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutNoeudDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutNoeudDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                AjoutNoeudDialog dialog = new AjoutNoeudDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JLabel LibelleLab;
    private javax.swing.JPanel NorthPanel;
    private javax.swing.JPanel SouthPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cleField;
    private javax.swing.JLabel cleLab;
    private javax.swing.JPanel clePane;
    private javax.swing.JLabel erreurLabel;
    private javax.swing.JTextField libField;
    private javax.swing.JPanel libellePane;
    private javax.swing.JButton valideButton;
    // End of variables declaration//GEN-END:variables

    private boolean verif() {
        if (this.cleField.getText().matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }
}
