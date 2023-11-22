
package Class.Volumen;


public class Esfera extends Volumen{
    public Double radio;

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double HallarVolumen() {
        super.setVolumen((4/3)*Math.PI*Math.pow(this.getRadio(), 3));
        return super.getVolumen();
    }
    
    
}
