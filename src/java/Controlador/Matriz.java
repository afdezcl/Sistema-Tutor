/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Fernandez
 */
public class Matriz {
    static String[][] matriz = new String[5][5]; //Creamos matriz de tam 5x5   
   
    /**
    * 
    * @param test Recibe por parametro el nombre del test para abrir ese txt y hacerle la extraccion
    * @return Una matriz 5x5, 5 preguntas cada una con: 1->nombre pregunta, 2->respuesta correcta
    *                                                   3->respuesta A,   4->respuesta B,     5->respuesta C
    */
    public static String[][] ObtenerMatriz(String test){
      Scanner sc;        
      try{
          File fichero = new File(test);            
          sc = new Scanner(fichero);            
          int fila = 0;
          int columna = 0;
          while(sc.hasNext()){
            String titulo = sc.nextLine();
            String correcto = sc.nextLine();
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            matriz[fila][columna] = titulo;            
            columna++;
            matriz[fila][columna] = correcto;
            columna++;
            matriz[fila][columna] = a;
            columna++;
            matriz[fila][columna] = b;
            columna++;
            matriz[fila][columna] = c;
            columna = 0;
            fila++;
          }                       
         sc.close();            
      } catch (FileNotFoundException e) {
        System.out.println("ERROR: " + e);
      }      
      return matriz;
    }
    
    //*******GET DE LA MATRIZ*********\\
    public static String getTituloPregunta(int pos){
        return matriz[pos][0];
    }
    public static int getPreguntaCorrecta(int pos){               
        return Integer.parseInt(matriz[pos][1]);
    }
    public static String getRespuestaA(int pos){
        return matriz[pos][2];
    }
    public static String getRespuestaB(int pos){
        return matriz[pos][3];
    }
    public static String getRespuestaC(int pos){
        return matriz[pos][4];
    }
    public static String getTituloCorrecto(int pos,int resC){
        return matriz[pos][resC+1];
    }
}
