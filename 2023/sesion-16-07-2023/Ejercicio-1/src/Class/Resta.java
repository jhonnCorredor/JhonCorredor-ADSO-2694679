
package Class;


public class Resta extends NumeroReal {

    @Override
    public Double GenrarResultado() {
        this.setResultado(super.getNum1()-super.getNum2());
        return super.getResultado();
    }
    
    
}
