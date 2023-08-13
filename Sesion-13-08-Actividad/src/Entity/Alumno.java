
package Entity;


public class Alumno {
    private String Curso;
    private Double promedio;
    private int MateriasReprobadas;

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public int getMateriasReprobadas() {
        return MateriasReprobadas;
    }

    public void setMateriasReprobadas(int MateriasReprobadas) {
        this.MateriasReprobadas = MateriasReprobadas;
    }
    
}
