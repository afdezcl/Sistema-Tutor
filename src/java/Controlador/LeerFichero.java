/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Fernandez
 */
public class LeerFichero {
    public static String readFichero(String archivo) throws FileNotFoundException, IOException{
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      StringBuilder sb = new StringBuilder();
      while((cadena = b.readLine()) != null) {
          sb.append(cadena + "\n");
      }
      b.close();
      return sb.toString();
    }
}
