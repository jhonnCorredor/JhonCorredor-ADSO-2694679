
package Class.Taller;


public class Inversionistas {
    private int inversion1;
    private int inversion2;
    private int inversion3;
    private Double porcentaje1;
    private Double porcentaje2;
    private Double porcentaje3;

    public int getInversion1() {
        return inversion1;
    }

    public void setInversion1(int inversion1) {
        this.inversion1 = inversion1;
    }

    public int getInversion2() {
        return inversion2;
    }

    public void setInversion2(int inversion2) {
        this.inversion2 = inversion2;
    }

    public int getInversion3() {
        return inversion3;
    }

    public void setInversion3(int inversion3) {
        this.inversion3 = inversion3;
    }

    public Double getPorcentaje1() {
        return porcentaje1;
    }

    private void setPorcentaje1(Double porcentaje1) {
        this.porcentaje1 = porcentaje1;
    }

    public Double getPorcentaje2() {
        return porcentaje2;
    }

    private void setPorcentaje2(Double porcentaje2) {
        this.porcentaje2 = porcentaje2;
    }

    public Double getPorcentaje3() {
        return porcentaje3;
    }

    private void setPorcentaje3(Double porcentaje3) {
        this.porcentaje3 = porcentaje3;
    }
    
    public void CalculoPorcentajes(){
        int total=(this.getInversion1()+this.getInversion2()+this.getInversion3());
        this.setPorcentaje1(((double)this.getInversion1()/total)*100);
        this.setPorcentaje2(((double)this.getInversion2()/total)*100);
        this.setPorcentaje3(((double)this.getInversion3()/total)*100);
        System.out.println("El porcentaje de la primera persona es: "+this.getPorcentaje1()+"%.");
        System.out.println("El porcentaje de la segunda persona es: "+this.getPorcentaje2()+"%.");
        System.out.println("El porcentaje de la tercera persona es: "+this.getPorcentaje3()+"%.");
    }
}
