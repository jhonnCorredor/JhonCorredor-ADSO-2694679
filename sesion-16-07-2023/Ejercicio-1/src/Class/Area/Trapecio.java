
package Class.Area;


public class Trapecio extends Area {
    
    public Double base1;
    public Double base2;
    public Double Altura;

    public Double getBase1() {
        return base1;
    }

    public void setBase1(Double base1) {
        this.base1 = base1;
    }

    public Double getBase2() {
        return base2;
    }

    public void setBase2(Double base2) {
        this.base2 = base2;
    }

    public Double getAltura() {
        return Altura;
    }

    public void setAltura(Double Altura) {
        this.Altura = Altura;
    }

    @Override
    public Double AreaFigura() {
        super.setArea((this.getBase1()*this.getBase2())*(this.getAltura()/2));
        return super.getArea();
    }
    
}
