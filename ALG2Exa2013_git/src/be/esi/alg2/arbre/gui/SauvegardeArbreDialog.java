/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.db.ArbreDbException;
import be.esi.alg2.arbre.dto.ArbreCompletDto;
import be.esi.alg2.arbre.metier.ArbreBinaireFacade;
import be.esi.alg2.arbre.metier.ArbreMetierException;
import be.esi.alg2.arbre.mvc.Modele;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marty
 */
public class SauvegardeArbreDialog extends javax.swing.JDialog {

    /**
     * Creates new form SauvegardeArbreDialog
     */
    private Modele modele ;
    private String nomArbre;

    public String getNomArbre() {
        return nomArbre;
    }
    public SauvegardeArbreDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modele = ArbreBinaireFacade.getModele();
        nomArbre="";
    }
    public SauvegardeArbreDialog(java.awt.Frame parent, boolean modal,String str) {
        super(parent, modal);
        initComponents();
        modele = ArbreBinaireFacade.getModele();
        this.nomArbreField.setText(str);
        nomArbre="";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomArbreField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sauvegarde d'un arbre");

        jLabel1.setText("Nom de l'arbre à Sauver :");
        jPanel1.add(jLabel1);

        nomArbreField.setColumns(30);
        jPanel1.add(nomArbreField);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        saveButton.setText("Sauvegarder");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel2.add(saveButton, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        ArbreCompletDto dto = new ArbreCompletDto(this.nomArbreField.getText(),new Date(),modele.getArbre());
        try {
            ArbreBinaireFacade.persisteArbre(dto);
            JOptionPane.showMessageDialog(this,"Sauvegardé !");
            nomArbre=dto.getId();
            this.dispose();
        } catch (ArbreMetierException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            nomArbre="";
        }catch ( ArbreDbException ex){
            if(JOptionPane.showConfirmDialog(this,"Voulez vous écrasé la sauvegarde existente ?")==JOptionPane.YES_OPTION){
                try {
                    boolean b = ArbreBinaireFacade.deleteArbre(dto);
                    ArbreBinaireFacade.persisteArbre(dto);
                    JOptionPane.showMessageDialog(this,"Sauvegardé !");
                    nomArbre=dto.getId();
                    this.dispose();
                } catch (ArbreDbException | ArbreMetierException ex1) {
                    JOptionPane.showMessageDialog(this,ex1.getMessage());
                    nomArbre="";
                }
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SauvegardeArbreDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SauvegardeArbreDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SauvegardeArbreDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SauvegardeArbreDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SauvegardeArbreDialog dialog = new SauvegardeArbreDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nomArbreField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
