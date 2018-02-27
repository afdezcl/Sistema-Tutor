/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fernandez
 */
public class Consulta extends Conexion{
    
    /**
     *
     * @param usuario
     * @param pass
     * @return TRUE si el usuario se encuentra en la BD o FALSE si no se encuentra en la BD 
     */
    public boolean autenticacion(String usuario, String pass){ 
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "SELECT * FROM usuarios WHERE USUARIO = ? AND PASS = ?"; //Se pone ? en vez de usuario y pass porque podria sqlinjection
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, usuario); //para los parametros ?
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally{
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
                
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
        
        
        return false;
    }
    /**
     * 
     * @param usuario
     * @param pass
     * @return True si se puede registrar el usuario, FALSE si no se puede
     */
    public boolean registrar(String usuario, String pass, String nombre, String apellido, String correo, String telf){
        
        PreparedStatement pst = null;
        Consulta con = new Consulta();
        try { 
            
            if(!con.autenticacion(usuario, pass)){
                String consulta = "INSERT INTO usuarios (usuario, pass, nombre, apellido, email, telf) VALUES (?,?,?,?,?,?)";
                pst = getConnection().prepareStatement(consulta);
                pst.setString(1, usuario);
                pst.setString(2, pass);
                pst.setString(3, nombre);
                pst.setString(4, apellido);
                pst.setString(5, correo);
                pst.setString(6, telf);
            
                if(pst.executeUpdate() == 1)  {
                    return true;
                }
            
            }
            
                          
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
 
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
        
        return false;
    }
   
}
