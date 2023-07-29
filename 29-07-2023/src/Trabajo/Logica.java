
package Trabajo;

import java.util.Scanner;


public class Logica {
    private Double totalParcial;
    private Double totalTrabajos;
    
    Scanner scan=new Scanner(System.in);
    
    
    public Double getTotalParcial() {
        return totalParcial;
    }

    public void setTotalParcial(Double totalParcial) {
        this.totalParcial = totalParcial;
    }

    public Double getTotalTrabajos() {
        return totalTrabajos;
    }

    public void setTotalTrabajos(Double totalTrabajos) {
        this.totalTrabajos = totalTrabajos;
    }
    
    public void Trabajo(){
        System.out.println("Ingrese el numero de trabajos.");
        int nTrabajos=scan.nextInt();
        Double[] notas=new Double[nTrabajos];
        int i=0;
                Double Trabajos=0.0;
        do{
            System.out.println("Ingrese la nota del trabajo:"+(i+1));
                notas[i]=scan.nextDouble();
                Double nota=notas[i];
                if(nota<0.0 || nota>5.0){
                    System.out.println("Solo se admiten valores entre 0.0 y 5.0");
                    i--;
                }else{
                    Trabajos=(Trabajos+notas[i]);
                }
                i=i+1;
        }while(i!=nTrabajos);
        Trabajos=(Trabajos/nTrabajos)*0.4;
        System.out.println("El porcentaje de los trabajos es: "+Trabajos);
       this.setTotalTrabajos(Trabajos);
    }
    
    public void Parcial(){
        Double[] notas=new Double[3];
        int i=0;
        Double Parcial=0.0;
        do{
            System.out.println("Ingrese la nota del parcial:"+(i+1));
                notas[i]=scan.nextDouble();
                Double nota=notas[i];
                if(nota<0.0 || nota>5.0){
                    System.out.println("Solo se admiten valores entre 0.0 y 5.0");
                    i--;
                }else{
                  Parcial=(Parcial+notas[i]);  
                }
                i=i+1;
        }while(i!=3);
        Parcial=(Parcial/3)*0.6;
        System.out.println("El porcentaje de los parciales es: "+Parcial);
       this.setTotalParcial(Parcial);
    }
    
    public void TotalMateria(){
        Double definitiva=(this.getTotalTrabajos())+(this.getTotalParcial());
        System.out.println("-----------------------------");
        System.out.println("La nota definitica de la materia es: "+definitiva);
    }
}
