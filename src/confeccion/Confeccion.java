/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package confeccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeanc
 */
public class Confeccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:33061/registro";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql,cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Confeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            
            /*INGRESAR DATOS*/
            statement.executeUpdate("INSERT INTO DATOS(userName,password) VALUES ('Pepe','fsbsds')" );
             rs = statement.executeQuery("SELECT * FROM DATOS");
             rs.next();
             
             do{
                 System.out.println(rs.getInt("id") + " : " + rs.getString("userName"));
             } while (rs.next());
            
            
            /*ACTUALIZAR DATOS*/
            /*String actualizar = "UPDATE datos set userName = 'Carlitos' WHERE id = 1"; 
            statement.executeUpdate(actualizar);
            System.out.println("Se acaba de actualizar un usuario");*/
            
            
            /*ELIMINAR UN DATO*/
          /*  String eliminar = "DELETE from datos WHERE id = 7";
            statement.executeUpdate(eliminar);
            System.out.println("Se acaba de eliminar un usuario");*/
            
        } catch (SQLException ex) {
            Logger.getLogger(Confeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
