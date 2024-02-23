/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Interface;

/**
 *
 * @author srhad
 */
public interface Accion {

    void Agregar();

    void Modificar();

    void EliminarFisico();

    Object Consultar();

    String ConsultarWhereAnd();
}
