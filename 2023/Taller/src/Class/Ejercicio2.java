
package Class;


public class Ejercicio2 extends Class{

    @Override
    public void Logica() {
        if(Math.pow(this.getReal(), 2)>5000){
            System.out.println("El cuadrado es "+Math.round(Math.pow(this.getReal(),2)*100)/100+" y es mayor a 5000.");
        }else{
             System.out.println("El cuadrado es "+Math.round(Math.pow(this.getReal(),2)*100)/100+" y es menor a 5000.");
        }
    }
    
}
