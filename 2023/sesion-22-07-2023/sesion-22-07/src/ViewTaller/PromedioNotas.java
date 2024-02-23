
package ViewTaller;

import Class.Taller.Promedio;
import java.util.Scanner;


public class PromedioNotas {
    public static void main(String[]args){
        Promedio a=new Promedio();
        Scanner scan=new Scanner(System.in);
        Double tarea1,tarea2,tarea3,examen;
        System.out.println("Ingrese las notas de las tres tareas y el examen de matematicas:");
        a.CalcularMatematicas(tarea1=scan.nextDouble(),tarea2=scan.nextDouble(),tarea3=scan.nextDouble(),examen=scan.nextDouble() );
        System.out.println("Ingrese las notas de las dos tareas y el examen de fisica:");
        a.CalcularFisica(tarea1=scan.nextDouble(),tarea2=scan.nextDouble(),examen=scan.nextDouble() );
        System.out.println("Ingrese las notas de las tres tareas y el examen de quimica:");
        a.CalcularQuimica(tarea1=scan.nextDouble(),tarea2=scan.nextDouble(),tarea3=scan.nextDouble(),examen=scan.nextDouble() );
        a.PromTotal();
    }
}
