
package Class;


public class Potencia extends NumeroReal {

    @Override
    public Double GenrarResultado() {
        this.setResultado(Math.pow(super.getNum1(),super.getNum2()));
        return super.getResultado();
    }
    
    
    
}
