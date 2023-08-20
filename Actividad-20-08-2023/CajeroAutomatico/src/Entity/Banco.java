
package Entity;


public class Banco {
    private String nombreBanco;

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
    
    public Banco(String nombre){
        this.nombreBanco=nombre;
    }
}
