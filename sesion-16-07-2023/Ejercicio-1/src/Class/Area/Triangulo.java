
package Class.Area;


public class Triangulo extends Area {
    
    public Double altura;
    public Double base;

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    
    @Override
    public Double AreaFigura() {
        super.setArea((this.getBase()*this.getAltura())/2);
        return super.getArea();
    }
    
    
}
