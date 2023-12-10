/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.entity.Materia;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class MateriaC {

    public void Guardar(String descripcion, String aula, String horaas_duracion) {
        Materia materia = new Materia();
        materia.setDescripcion(descripcion);
        materia.setAula(aula);
        materia.setHoras_duracion(horaas_duracion);
        materia.Agregar();
    }

    public void Modificar(String descripcion_id, String descripcion, String aula, String horaas_duracion) {
        Materia materia = new Materia();
        materia.setDescripcion_id(descripcion_id);
        materia.setDescripcion(descripcion);
        materia.setAula(aula);
        materia.setHoras_duracion(horaas_duracion);
        materia.Modificar();
    }

    public void EliminarLogico(String descripcion) {
        Materia materia = new Materia();
        materia.setDescripcion(descripcion);
        materia.EliminarLogico();
    }

    public ArrayList<Materia> ConsultarRegistro() {
        Materia continente = new Materia();
        ArrayList<Materia> continentes = (ArrayList<Materia>) continente.Consultar();
        return continentes;
    }
}
