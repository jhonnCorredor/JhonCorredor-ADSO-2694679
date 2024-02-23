
package Class;

import Interface.Interface;
import java.util.Scanner;


public abstract class Class implements Interface{
    private Double real;
    
    Scanner scan=new Scanner(System.in);

    public Double getReal() {
        return real;
    }

    public void setReal(Double real) {
        this.real = real;
    }
    
    @Override
    public void Lectura() {
        System.out.println("Ingrese un real:");
        this.setReal(scan.nextDouble());
    }

    @Override
    public void Logica() {
    }
    
}
