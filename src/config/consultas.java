/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import login.Iniciar_sesion;



/**
 *
 * @author jeanc
 */
public class consultas {
    //Guardar el registro
    public void guardarRegistro(String tipoDocumento, String nDocumento,String nombre,String apellido, String telefono, String correo,String direccion,String contraseña){
        conexionBD db = new conexionBD();
        String sql = "INSERT INTO REGISTRO( tipoDocumento, nDocumento, nombre, apellido, telefono, correo, direccion, contraseña)"+ " values ('" + tipoDocumento + "', '" + nDocumento + "', '" + nombre +"', '" + apellido + "', '" + telefono +"', '" + correo + "', '" + direccion + "', '" + contraseña +"');";
        Statement st;
        Connection conexion = db.conectar();
        try {
        st = conexion.createStatement();
        int rs = st.executeUpdate(sql);
        
        JOptionPane.showMessageDialog(null, "Guardado correctamente \n Ya puede iniciar sesion");
        
     
            Iniciar_sesion objetoPrincipal = new Iniciar_sesion();
                objetoPrincipal.setVisible(true);
            
             
        }catch (SQLException e){
            System.out.println(e);
        }
        
        
    }
    
    

    
    
    //Haceder al usuario
   public void consultarUsuario(JTextField textUser, JPasswordField textPas){
       
       try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            
            config.conexionBD objetoConexion = new config.conexionBD();
            
            String consulta =" SELECT * FROM REGISTRO WHERE registro.nDocumento =(?)  and registro.contraseña =(?)";
            ps = objetoConexion.conectar().prepareStatement(consulta);
            
            String contraseñ = String.valueOf(textPas.getPassword());
       
            
            ps.setString(1, textUser.getText());
            ps.setString(2, contraseñ);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                
                JOptionPane.showMessageDialog(null, "Bienvenido ");
            } else {
                
                 JOptionPane.showMessageDialog(null, "El Usuario o Contraseña son incorrectos");    
            }
                         
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erreor: " + e.toString());
       }
           
      
       
       
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
