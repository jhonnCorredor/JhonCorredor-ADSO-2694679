
package Class;


public class Ejercicio9 extends Class{

    @Override
    public void Logica() {
        
        if(Math.round(this.getReal())>=200 && Math.round(this.getReal())<=300){
            System.out.println("El entero esta en el rango de 200-300.");
        }else{
            System.out.println("El entero no esta en el rango de 200-300.");
        }
        if(Math.round(this.getReal())%2==0){
            System.out.println("El entero es par.");
        }else{
            System.out.println("El entero es impar.");
        }
    }

    @Override
    public void Lectura() {
        System.out.println("Ingrese un entero:");
        this.setReal(scan.nextDouble());
    }
    
}
