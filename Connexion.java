/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecole;

import java.sql.*;
import java.sql.DriverManager;




/**
 *
 * @author Atar EL AZIZ
 */
public class Connexion {
    Connection con;
    ResultSet Rs=null;
    PreparedStatement ps=null;
    public Connexion(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException e){
    System.err.println(e);
    //pour afficher l'erreur
    }
    try{
    con = DriverManager.getConnection("jdbc:mysql://localhost/projet.java","root","");
    }catch(SQLException e){System.err.println(e);}
    }
    Connection obtenirConnexion(){
    return con;
    }

}
