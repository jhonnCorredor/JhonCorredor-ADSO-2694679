/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Ciudad;
import java.util.ArrayList;


/**
 * @author juan
 */
public class CiudadC {
     public void GuardarRegistro(String codigo_postal, String descripcion, String selecionado){
        Ciudad ciudad = new Ciudad();
        ciudad.setCodigo_postal(codigo_postal);
        ciudad.setDescripcion(descripcion);
        ciudad.setDescripcionEstado(selecionado);
        ciudad.Agregar();
     }
     public void EliminarRegistro(String descripcion){
        Ciudad ciudad = new Ciudad();
        ciudad.setDescripcion(descripcion);
        ciudad.EliminarFisico();
     }
    
     public ArrayList<Ciudad> ConsultarRegistro() {
        Ciudad ciudad = new Ciudad();
        ArrayList<Ciudad> ciudades= (ArrayList<Ciudad>) ciudad.Consultar();
        return ciudades;
    }

   

    public void ModificarRegistro(String Seleccionado, String codigoPostal, String descripcion, String valSeleccionado) {
             Ciudad ciudad = new Ciudad();
        ciudad.setIdDescripcion(Seleccionado);
        ciudad.setCodigo_postal(codigoPostal);
        ciudad.setDescripcion(descripcion);
        ciudad.setDescripcionEstado(valSeleccionado);
        ciudad.Modificar();

    }
}
