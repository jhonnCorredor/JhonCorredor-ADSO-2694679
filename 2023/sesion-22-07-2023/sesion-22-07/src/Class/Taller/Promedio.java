package Class.Taller;

public class Promedio {

    private Double Prom_examen;
    private Double Prom_tareas;
    private Double prom_matematicas;
    private Double prom_fisica;
    private Double prom_quimica;
    private Double prom_total;

    public Double getProm_examen() {
        return Prom_examen;
    }

    private void setProm_examen(Double Prom_examen) {
        this.Prom_examen = Prom_examen;
    }

    public Double getProm_tareas() {
        return Prom_tareas;
    }

    private void setProm_tareas(Double Prom_tareas) {
        this.Prom_tareas = Prom_tareas;
    }

    public Double getProm_matematicas() {
        return prom_matematicas;
    }

    private void setProm_matematicas(Double prom_matematicas) {
        this.prom_matematicas = prom_matematicas;
    }

    public Double getProm_fisica() {
        return prom_fisica;
    }

    private void setProm_fisica(Double prom_fisica) {
        this.prom_fisica = prom_fisica;
    }

    public Double getProm_quimica() {
        return prom_quimica;
    }

    private void setProm_quimica(Double prom_quimica) {
        this.prom_quimica = prom_quimica;
    }

    public Double getProm_total() {
        return prom_total;
    }

    private void setProm_total(Double prom_total) {
        this.prom_total = prom_total;
    }

    public void CalcularMatematicas(Double tarea1, Double tarea2, Double tarea3, Double examen) {
        this.setProm_examen(examen * 0.9);
        this.setProm_tareas(((tarea1 + tarea2 + tarea3))/3 * 0.1);
        this.setProm_matematicas(this.getProm_tareas() + this.getProm_examen());
        System.out.println("El promedio del area matematicas es: " + this.getProm_matematicas());
    }

    public void CalcularFisica(Double tarea1, Double tarea2, Double examen) {
        this.setProm_examen(examen * 0.8);
        this.setProm_tareas(((tarea1 + tarea2))/2 * 0.2);
        this.setProm_fisica(this.getProm_tareas() + this.getProm_examen());
        System.out.println("El promedio del area fisica es: "+this.getProm_fisica());
    }
    
    public void CalcularQuimica(Double tarea1, Double tarea2, Double tarea3, Double examen){
        this.setProm_examen(examen * 0.85);
        this.setProm_tareas(((tarea1 + tarea2 + tarea3)/3 )* 0.15);
        this.setProm_quimica(this.getProm_tareas() + this.getProm_examen());
        System.out.println("El promedio del area quimica es: "+this.getProm_quimica());
    }
    
    public void PromTotal(){
        this.setProm_total((this.getProm_matematicas()+this.getProm_fisica()+this.getProm_quimica())/3);
        System.out.println("El promedio general en las tres materias es de: "+this.getProm_total());
    }
}
