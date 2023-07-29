
package Trabajo;

import java.util.Scanner;


public class Class {
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
        for(int i=0;i==nTrabajos;i++){
            System.out.println("Ingrese la nota del trabajo:"+(i++));
                notas[i]=scan.nextDouble();
                Double nota=notas[i];
                if(nota<0.0 || nota>5.0){
                    System.out.println("Solo se admiten valores entre 0.0 y 5.0");
                    i--;
                }
        }
        Double Trabajos=0.0;
        for(int i=0;i==nTrabajos;i++){
            Trabajos=(Trabajos+notas[i]);
        }
        Trabajos=Trabajos/nTrabajos;
       this.setTotalTrabajos(Trabajos*0.4);
    }
    
    public void Parcial(){
        Double[] notas=new Double[3];
        for(int i=0;i==3;i++){
            System.out.println("Ingrese la nota del parcial "+(i++));
                notas[i]=scan.nextDouble();
                Double nota=notas[i];
                if(nota<0.0 || nota>5.0){
                    System.out.println("Solo se admiten valores entre 0.0 y 5.0");
                    i--;
                }
        }
        Double Parcial=0.0;
        for(int i=0;i==3;i++){
            Parcial=(Parcial+notas[i]);
        }
       this.setTotalTrabajos((Parcial/3)*0.6);
    }
    
    public void TotalMateria(){
        Double definitiva=(this.getTotalTrabajos())+(this.getTotalParcial());
        System.out.println("-----------------------------");
        System.out.println("La nota definitica de la materia es: "+definitiva);
    }
}
