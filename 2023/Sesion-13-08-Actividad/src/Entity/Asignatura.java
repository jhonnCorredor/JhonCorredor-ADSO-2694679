package Entity;

public class Asignatura extends Alumno {

    private int unidades;
    private Double descuento;
    private Double TotalAsignatura;
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotalAsignatura() {
        return TotalAsignatura;
    }

    public void setTotalAsignatura(Double TotalAsignatura) {
        this.TotalAsignatura = TotalAsignatura;
    }

    public Double HallarDescuento() {
        Double descuento=0.0;
        if (this.getCurso() == "preparatoria") {
            if (this.getPromedio() >= 9.5) {
               descuento=0.25;
            } 
            if (this.getPromedio() >= 9 && this.getPromedio() < 9.5) {
                descuento=0.1;
            }
        } 
        if (this.getCurso() == "profesional" && this.getPromedio() >= 9.5) {
            descuento=0.25;
        } else {
            descuento=0.0;
        }
        this.setDescuento(descuento);
        return this.getDescuento();
    }

    public int HallarUnidades() {
        
        if (this.getCurso() == "preparatoria") {
            int unidades;
            if (this.getPromedio() >= 9.5) {
                unidades=55;
            } 
            if (this.getPromedio() >= 9 && this.getPromedio() < 9.5) {
                unidades=50;
            } 
            if (this.getPromedio() > 7 && this.getPromedio() < 9) {
                 unidades=50;
            }
            if (this.getPromedio() <= 7 && this.getMateriasReprobadas() > 4) {
                unidades=40;
            } else {
                 unidades=45;
            }
        }
        if (this.getCurso() == "profesional") {
             unidades=55;
        }
        this.setUnidades(unidades);
        return this.getUnidades();
    }
    
    public Double TotalAsignatura(){
        this.setUnidades(this.getUnidades()/5);

        Double descuento=HallarDescuento();
        if(this.getCurso() == "preparatoria"){
            this.setValor(180);
        }
        if(this.getCurso() == "profesional"){
               this.setValor(300);
        }
        this.setTotalAsignatura(this.getValor()*(double)this.getUnidades());
        descuento=this.getTotalAsignatura()*descuento;
        this.setTotalAsignatura(this.getTotalAsignatura()-descuento);
        return this.getTotalAsignatura();
    }
}
