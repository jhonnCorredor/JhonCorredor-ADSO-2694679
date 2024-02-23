
package Class;


public class Division extends NumeroReal {

    @Override
    public Double GenrarResultado() {
        if(super.getNum2()==0){
            System.out.println("no se puede dividr por 0.");
            super.setResultado(0.0);
        }else{
        this.setResultado(super.getNum1()/super.getNum2());       
        }
        return super.getResultado();
    }
    
    
}
