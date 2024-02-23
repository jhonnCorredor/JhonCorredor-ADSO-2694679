
package Class.Area;


public class Circuferencia extends Area {
    
    public Double radio;

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double AreaFigura() {
        super.setArea(Math.round((Math.PI*Math.pow(getRadio(),2))*100.0)/100.0);
        return super.getArea();
    }
    
}
