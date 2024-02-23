
package View;

import Class.ej1.ej1;
import java.util.Scanner;


 
public class Ej_1 {
    public static void main(String[]args){
        ej1 obj1=new ej1();
        Scanner scan=new Scanner(System.in);
        int edad,segundos;
        System.out.println("Ingrese la edad de la persona:");
        edad=scan.nextInt();
        obj1.setEdad(edad);
        System.out.println("Ingrese los segundos:");
        segundos=scan.nextInt();
        obj1.setSegundos(segundos);
        System.out.println("Las pulsaciones de la persona por "+obj1.getSegundos()+" segundos es: "+obj1.CalculoPulsaciones());
    }
}
