
package Class.ej1;


public class ej1 {
    public Double pulsaciones;
    public int edad;
    public int segundos;

    public int getSegundos() {
        return this.segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    protected Double getPulsaciones() {
        return this.pulsaciones;
    }

    protected void setPulsaciones(Double pulsaciones) {
        this.pulsaciones = pulsaciones;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Double CalculoPulsaciones(){
        this.setPulsaciones((double)(220-this.getEdad())/this.getSegundos());
        return this.getPulsaciones();
    }
}
