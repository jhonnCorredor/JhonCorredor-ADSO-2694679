/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.entity.Estudiantes;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class EstudiantesC {

    public void Guardar(String nombre, String edad, String documento, String telefono, String correo) {
        Estudiantes estudiante = new Estudiantes();
        estudiante.setNombre(nombre);
        estudiante.setEdad(edad);
        estudiante.setDocumento(documento);
        estudiante.setTelefono(telefono);
        estudiante.setCorreo(correo);
        estudiante.Agregar();
    }

    public void Modificar(String documento_id, String nombre, String edad, String documento, String telefono, String correo) {
        Estudiantes estudiante = new Estudiantes();
        estudiante.setDocumento_id(documento_id);
        estudiante.setNombre(nombre);
        estudiante.setEdad(edad);
        estudiante.setDocumento(documento);
        estudiante.setTelefono(telefono);
        estudiante.setCorreo(correo);
        estudiante.Modificar();
    }

    public void EliminarLogico(String documento) {
        Estudiantes estudiante = new Estudiantes();
        estudiante.setDocumento(documento);
        estudiante.EliminarLogico();
    }
    
    public ArrayList<Estudiantes> ConsultarRegistro() {
        Estudiantes continente = new Estudiantes();
        ArrayList<Estudiantes> continentes = (ArrayList<Estudiantes>) continente.Consultar();
        return continentes;
    }
}
