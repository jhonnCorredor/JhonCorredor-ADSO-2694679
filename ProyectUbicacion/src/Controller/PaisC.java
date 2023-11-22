/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Pais;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class PaisC {
    
     public void EliminarRegistro(String descripcion){
        Pais pais = new Pais();
        pais.setDescripcion(descripcion);
        pais.EliminarFisico();
     }
    
    public ArrayList<Pais> ConsultarRegistro() {
        Pais pais = new Pais();
        ArrayList<Pais> paises= (ArrayList<Pais>) pais.Consultar();
        return paises;
    }

    public void GuardarRegistro(String codigoPostal1, String descripcion1, String Seleccionado1) {
          Pais pais = new Pais();
        pais.setCodigo_postal(codigoPostal1);
        pais.setDescripcion(descripcion1);
        pais.setDescripcionContinente(Seleccionado1);
        pais.Agregar();
        System.out.println("Controller.PaisC.GuardarRegistro()"+codigoPostal1);

    }

    public void ModificarRegistro(String Seleccionado, String codigoPostal1, String descripcion1, String valSeleccionado) {
           Pais pais = new Pais();
       pais.setIdDescripcion(Seleccionado);
        pais.setCodigo_postal(codigoPostal1);
        pais.setDescripcion(descripcion1);
        pais.setDescripcionContinente(valSeleccionado);
        pais.Modificar();
    }    
}
