
package Class.Area;


public class Rectangulo extends Area{
    
    public Double base;
    public Double altura;

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public Double AreaFigura() {
        super.setArea(this.getAltura()*this.getBase());
        return super.getArea();
    }
    
}
