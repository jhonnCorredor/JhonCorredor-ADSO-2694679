
package Class;

import Interface.Interface;


public class MyClass implements Interface {
    public Double num1;
    public Double num2;

    public MyClass(Double num1,Double num2){
        this.num1=num1;
        this.num2=num2;
    }
    @Override
    public void Suma() {
        System.out.println("La suma es: "+(this.num1+this.num2));
    }

    @Override
    public void Resta() {
        System.out.println("La resta es: "+(this.num1-this.num2));
    }

    @Override
    public void Multiplicacion() {
       System.out.println("La multiplicacion es: "+(this.num1*this.num2));
    }

    @Override
    public void Division() {
        System.out.println("La division es: "+Math.round((this.num1/this.num2)*100.0)/100.0);
    }
    
}
