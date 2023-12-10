/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.entity.Matricula;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class MatriculaC {
    public void Guardar(String codigo, String documento_estudiante, String descripcion_materia) {
        Matricula matricula = new Matricula();
        matricula.setCodigo(codigo);
        matricula.setDocumento_estudiante(documento_estudiante);
        matricula.setMateria_descripcion(descripcion_materia);
        matricula.Agregar();
    }

    public void Modificar(String codigo_id,String codigo, String documento_estudiante, String descripcion_materia) {
        Matricula matricula = new Matricula();
        matricula.setCodigo_id(codigo_id);
        matricula.setCodigo(codigo);
        matricula.setDocumento_estudiante(documento_estudiante);
        matricula.setMateria_descripcion(descripcion_materia);
        matricula.Modificar();
    }

    public void EliminarLogico(String descripcion_id) {
        Matricula matricula = new Matricula();
        matricula.setCodigo_id(descripcion_id);
        matricula.EliminarLogico();
    } 
    
    public ArrayList<Matricula> ConsultarRegistro() {
        Matricula continente = new Matricula();
        ArrayList<Matricula> continentes = (ArrayList<Matricula>) continente.Consultar();
        return continentes;
    }
}
