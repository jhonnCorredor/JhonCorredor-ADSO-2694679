/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Estado;
import java.util.ArrayList;


/**
 *
 * @author juan
 */
public class EstadoC {
   
     public void EliminarRegistro(String descripcion){
        Estado estado = new Estado();
        estado.setDescripcion(descripcion);
        estado.EliminarFisico();
     }
  
    public ArrayList<Estado> ConsultarRegistro() {
        Estado estado = new Estado();
        ArrayList<Estado> estados= (ArrayList<Estado>) estado.Consultar();
        return estados; 
    }

    public void Agregar(String codigoPostal, String descripcion, String Seleccionado) {
            Estado estado = new Estado();
        estado.setCodigo_postal(codigoPostal);
        estado.setDescripcion(descripcion);
        estado.setDescripcionPais(Seleccionado);
        estado.Agregar();

    }

  

    public void ModificarRegistro(String Seleccionado, String codigoPostal, String descripcion, String valSeleccionado) {
         Estado estado = new Estado();
        estado.setIdDescripcion(Seleccionado);
        estado.setCodigo_postal(codigoPostal);
        estado.setDescripcion(descripcion);
        estado.setDescripcionPais(valSeleccionado);
        estado.Modificar();

    }
}
