
package Class.Volumen;


public class Cilindro extends Volumen{
    public Double radio;
    public Double altura;

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public Double HallarVolumen() {
        super.setVolumen(Math.PI*Math.pow(this.getRadio(), 2)*this.getAltura());
        return super.getVolumen();
    }
    
}
