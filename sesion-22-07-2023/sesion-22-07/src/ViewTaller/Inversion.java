
package ViewTaller;

import Class.Taller.Inversionistas;
import java.util.Scanner;


public class Inversion {
    public static void main(String[]args){
        Inversionistas a=new Inversionistas();
        Scanner scan=new Scanner(System.in);
        int inversion;
        System.out.println("Ingrese la inversion de la primera persona:");
        a.setInversion1(inversion=scan.nextInt());
        System.out.println("Ingrese la inversion de la segunda persona:");
        a.setInversion2(inversion=scan.nextInt());
        System.out.println("Ingrese la inversion de la tercera persona:");
        a.setInversion3(inversion=scan.nextInt());
        a.CalculoPorcentajes();
    }
}
