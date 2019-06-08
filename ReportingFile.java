/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecole;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.ResultSet;

/**
 *
 * @author Atar EL AZIZ
 */
public class ReportingFile extends javax.swing.JFrame {

    /**
     * Creates new form ReportingFile
     */
    
    Connexion conn = new Connexion();
    Statement stm;
    ResultSet Rs;
    public ReportingFile() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(715, 530));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Page d'accueil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 0, 140, 40);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 153));
        jButton4.setText("Physique");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(550, 450, 80, 40);

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(78, 206, 129));
        jButton5.setText("Info");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(460, 450, 80, 40);

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(239, 8, 8));
        jButton6.setText("Maths");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(370, 450, 80, 40);

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 102, 0));
        jButton7.setText("ING1 - ING2 - ING3");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(120, 450, 210, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setText("Reporting");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 50, 170, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ecole/icons/histo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 710, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //méthode pour les étudiant ayant plus que 10
    public int getPhysiquePlus(){
    String lsSQL = "Select count(*) from etudiant where note >=10 and branche= 'Physique' ";
        String lsAdresse = "";
        int i = 0;
        
       try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    
    
    //méthode pour les étudiant ayant moins que 10
    public int getPhysqueMoins(){
    String lsSQL = "Select count(*) from etudiant where note<10 and branche ='Physique'";
        String lsAdresse = "";
        int i = 0;
        
       try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }  
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Reporting matiére physique
        int resulta = getPhysiquePlus();
        int resultat = getPhysqueMoins();
       
       
        
       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
       HashMap<String,Integer> noteEleves = new HashMap<String,Integer>();
       noteEleves.put("note >= 10", resulta);
       noteEleves.put("note < à 10 ", resultat);
       //noteEleves.put("Atar", 12);
       //noteEleves.put("Nasser", 22);
       noteEleves.forEach((k,v) -> dataset.setValue(v, "Marks", k));
        //dataset.setValue(90, "Marks", "Student4");
        JFreeChart chart = ChartFactory.createBarChart("Histogramme de Physique", "taux de réussite", "Nombre des étudiants", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar Chart for student", chart);
        frame.setVisible(true);
        frame.setSize(450,350);
   
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    
    //méthode pour les étudiant ayant plus que 10
    public int getInfoPlus(){
    String lsSQL = "Select count(*) from etudiant where note >=10 and branche= 'INFO' ";
        String lsAdresse = "";
        int i = 0;
        
       try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    //méthode pour les étudiant ayant moins que 10
    public int getInfoMoins(){
    String lsSQL = "Select count(*) from etudiant where note<10 and branche ='Info'";
        String lsAdresse = "";
        int i = 0;
        
       try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         int resulta = getInfoPlus();
        int resultat = getInfoMoins();
       
       
        
       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
       HashMap<String,Integer> noteEleves = new HashMap<String,Integer>();
       noteEleves.put("note Supérieur ou = 10", resulta);
       noteEleves.put("note Inférieur à 10 ", resultat);
       //noteEleves.put("Atar", 12);
       //noteEleves.put("Nasser", 22);
       noteEleves.forEach((k,v) -> dataset.setValue(v, "Marks", k));
        //dataset.setValue(90, "Marks", "Student4");
        JFreeChart chart = ChartFactory.createBarChart("Histogramme de Informatique", "taux de réussite", "Nombre des étudiants", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Histogramme Informatique", chart);
        frame.setVisible(true);
        frame.setSize(450,350);
    }//GEN-LAST:event_jButton5ActionPerformed

    //méthode pour les étudiant ayant plus que 10
    public int getMathsPlus(){
    String lsSQL = "Select count(*) from etudiant where note >=10 and branche= 'Maths' ";
        String lsAdresse = "";
        int i = 0;
        
       try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    //méthode pour les étudiant ayant moins que 10
    public int getMathsMoins(){
    String lsSQL = "Select count(*) from etudiant where note<10 and branche ='Maths'";
        String lsAdresse = "";
        int i = 0;
        
       try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        // Reporting matiére physique
        int resulta = getMathsPlus();
        int resultat = getMathsMoins();
       
       
        
       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
       HashMap<String,Integer> noteEleves = new HashMap<String,Integer>();
       noteEleves.put("note >= 10", resulta);
       noteEleves.put("note < à 10 ", resultat);
       //noteEleves.put("Atar", 12);
       //noteEleves.put("Nasser", 22);
       noteEleves.forEach((k,v) -> dataset.setValue(v, "Marks", k));
        //dataset.setValue(90, "Marks", "Student4");
        JFreeChart chart = ChartFactory.createBarChart("Histogramme de Maths", "taux de réussite", "Nombre des étudiants", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Histogrammes Mathématiques", chart);
        frame.setVisible(true);
        frame.setSize(450,350);
    }//GEN-LAST:event_jButton6ActionPerformed

    
    public int getING1(){
     String lsSQL = "Select count(*) from etudiant where niveau ='ING1' ";
        String lsAdresse = "";
        int i = 0;
         try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    public int getING2(){
     String lsSQL = "Select count(*) from etudiant where niveau ='ING2' ";
        String lsAdresse = "";
        int i = 0;
         try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    public int getING3(){
     String lsSQL = "Select count(*) from etudiant where niveau ='ING3' ";
        String lsAdresse = "";
        int i = 0;
         try{
            stm = conn.obtenirConnexion().createStatement();
       ResultSet result = stm.executeQuery(lsSQL);
       result.next();
       lsAdresse = result.getString(1);
       result.close();
       stm.close();
       
       i= Integer.parseInt(lsAdresse);
       
       }catch(Exception e){lsAdresse ="Introuvable";}
       return i;
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int ing1 = getING1();
        int ing2 = getING2();
        int ing3 = getING3();
       
       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
       HashMap<String,Integer> noteEleves = new HashMap<String,Integer>();
       noteEleves.put("ING1", ing1);
       noteEleves.put("ING2", ing2);
       noteEleves.put("ING3", ing3);
       
       //noteEleves.put("Atar", 12);
       //noteEleves.put("Nasser", 22);
       noteEleves.forEach((k,v) -> dataset.setValue(v, "Nb étudiants", k));
        //dataset.setValue(90, "Marks", "Student4");
        JFreeChart chart = ChartFactory.createBarChart("Histogramme des niveaux", "Niveau", "Nombre des étudiants", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Histogramme des étudiants", chart);
        frame.setVisible(true);
        frame.setSize(450,350);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PageAccueil page = new PageAccueil();
        this.setVisible(false);
        page.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportingFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportingFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportingFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportingFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportingFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
