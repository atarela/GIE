/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecole;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Atar EL AZIZ
 */
public class AttendanceList extends javax.swing.JFrame {

    /**
     * Creates new form AttendanceList
     */
    Connexion conn = new Connexion();
    Statement stm;
    ResultSet Rs;
    
    public AttendanceList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnom = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtid = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtprenom = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtdate = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtseance = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtmotif = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 450));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Absences");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 110, 230, 63);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nom :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 190, 182, 38);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Etudiant ID :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 140, 182, 38);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Date :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 280, 70, 38);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Séance :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 320, 182, 38);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Motif :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, 360, 182, 38);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Prenom :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 230, 182, 38);

        jScrollPane1.setViewportView(txtnom);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 180, 120, 30);

        jScrollPane2.setViewportView(txtid);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(220, 140, 120, 30);

        jScrollPane3.setViewportView(txtprenom);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(220, 220, 120, 30);

        jScrollPane4.setViewportView(txtdate);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(220, 260, 120, 30);

        jScrollPane5.setViewportView(txtseance);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(220, 310, 120, 30);

        jScrollPane6.setViewportView(txtmotif);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(220, 360, 120, 30);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Soumettre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 360, 154, 39);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Menu Principale");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(610, 20, 144, 56);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ecole/icons/check.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(410, 220, 90, 80);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ecole/icons/uncheck.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(510, 220, 110, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ecole/icons/abs.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 760, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String nom=txtnom.getText();
        String prenom=txtprenom.getText();
        String id = txtid.getText();
        String date = txtdate.getText();
        String seance = txtseance.getText();
        String motif = txtmotif.getText();
         
        String requete = "insert into absences(id, Nom, Prenom, date, seance, motif)VALUES('"+
                id+"','"+nom+"','"+prenom+"','"+date+"','"+seance+"','"+motif+"')";
        
        try{
        stm = conn.obtenirConnexion().createStatement();
        stm.executeUpdate(requete);
           JOptionPane.showMessageDialog(null, "l'etudiant est bien ajouter");
           txtid.setText("");
           txtnom.setText("");
           txtprenom.setText("");
           txtdate.setText("");
           txtseance.setText(""); 
           txtmotif.setText("");
        
        }catch(Exception ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PrincipaleProf prin =new PrincipaleProf();
        this.setVisible(false);
        prin.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AttendanceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane txtdate;
    private javax.swing.JTextPane txtid;
    private javax.swing.JTextPane txtmotif;
    private javax.swing.JTextPane txtnom;
    private javax.swing.JTextPane txtprenom;
    private javax.swing.JTextPane txtseance;
    // End of variables declaration//GEN-END:variables
}
