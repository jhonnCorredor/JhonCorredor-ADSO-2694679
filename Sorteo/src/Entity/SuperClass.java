/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class SuperClass {
     static Sorteo s = new Sorteo();
     public static void iniciacion(){
       s.CrearBoletos();  
     }
     
     public static ArrayList<Boleto> listaboletos(){
         return s.getBoleto();
     }
     
     public static Boleto Ganador(){
         return s.CrearGanador(s.getBoleto());
     }
}
