
package Class;


public class Raiz extends NumeroReal {

    @Override
    public Double GenrarResultado() {
        this.setResultado(Math.sqrt(super.getNum1()));
        return super.getResultado();
    }
    
    
}
