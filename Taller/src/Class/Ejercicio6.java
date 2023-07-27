
package Class;


public class Ejercicio6 extends Class{

    @Override
    public void Logica() {
        if(this.getReal()>=50 && this.getReal()<=100){
            System.out.println("El real esta en el rango de 50 y 100.");
    }else{
            System.out.println("El real no esta en el rango de 50 y 100.");
        }
    }
    
}
