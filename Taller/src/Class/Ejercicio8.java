
package Class;


public class Ejercicio8 extends Class{

    @Override
    public void Lectura() {
        System.out.println("Ingrese un entero:");
        this.setReal(scan.nextDouble());
    }

    @Override
    public void Logica() {
        if(Math.round(this.getReal())%2==0){
            System.out.println("El entero es par.");
        }else{
            System.out.println("El entero es impar.");
        }
        if(Math.round(this.getReal())==0){
            System.out.println("El entero es neutro");
        }if(Math.round(this.getReal())<0){
            System.out.println("El entero es negativo.");
        }else{
            System.out.println("El entero es positivo.");
        }
    }
    
}
