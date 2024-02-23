
package Class.ej1;


public class ClassRuta {
    public Double t_lunes;
    public Double t_miercoles;
    public Double t_viernes;
    public Double promedio;
    
    public Double getT_lunes() {
        return t_lunes;
    }

    public void setT_lunes(Double t_lunes) {
        this.t_lunes = t_lunes;
    }

    public Double getT_miercoles() {
        return t_miercoles;
    }

    public void setT_miercoles(Double t_miercoles) {
        this.t_miercoles = t_miercoles;
    }

    public Double getT_viernes() {
        return t_viernes;
    }

    public void setT_viernes(Double t_viernes) {
        this.t_viernes = t_viernes;
    }

    protected Double getPromedio() {
        return promedio;
    }

    protected void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
    
    public Double Mostrar(){
        this.setPromedio((this.getT_lunes()+this.getT_miercoles()+this.getT_viernes())/3);
        return this.getPromedio();
    }
}
