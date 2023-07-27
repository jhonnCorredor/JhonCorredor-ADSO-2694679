
package Class;


public class Ejercicio3 extends Class{

    @Override
    public void Logica() {
        if(this.getReal()<0){
            this.setReal(this.getReal()*-1);
        }
        System.out.println("El valor absoluto del real es: "+this.getReal());
    }
    
}
