/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author jeanc
 */
public class conexionBD {
   
    
       public static Connection con; 
        
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:33061/confecciones?characterEncoding=utf8";
        String driver = "com.mysql,cj.jdbc.Driver";
       
       public Connection conectar(){
           con = null;
           
           try {
               con = (Connection) DriverManager.getConnection(url, user, pass);
               if(con!=null){
                   
               }
           } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Error" + e.toString());
           }
           return con;
       } 
       
    
}
