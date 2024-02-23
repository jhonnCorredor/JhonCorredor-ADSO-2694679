
package Class.Area;


public class Rombo extends Area {
    public Double dglmayor;
    public Double dglmenor;

    public Double getDglmayor() {
        return dglmayor;
    }

    public void setDglmayor(Double dglmayor) {
        this.dglmayor = dglmayor;
    }

    public Double getDglmenor() {
        return dglmenor;
    }

    public void setDglmenor(Double dglmenor) {
        this.dglmenor = dglmenor;
    }

    @Override
    public Double AreaFigura() {
        super.setArea(this.getDglmayor()*this.getDglmenor()/2);
        return super.getArea();
    }
    
}
