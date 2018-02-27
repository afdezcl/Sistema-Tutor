/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fernandez
 */
public class Conexion {
    private String USERNAME = "sql11212851";
    private String PASSWORD = "kRetfdUjQt";
    private String HOST = "sql11.freesqldatabase.com"; //localhost
    //private String HOST = "proxy.lcc.uma.es:3128/sql11.freesqldatabase.com"; //localhost
    private String PORT = "3306";
    private String DATABASE = "sql11212851"; //login -- nombre base datos
    private String CLASSNAME = "com.mysql.jdbc.Driver"; //driver de mysql
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private Connection con;
    
    public Conexion(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("ERROR: " + e);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
 
}
