
package Class.Area;


public class Cuadrado extends Area {
    public Double Base;

    public Double getBase() {
        return Base;
    }

    public void setBase(Double Base) {
        this.Base = Base;
    }

    @Override
    public Double AreaFigura() {
        super.setArea(Math.pow(this.getBase(), 2));
        return super.getArea();
    }
    
}
