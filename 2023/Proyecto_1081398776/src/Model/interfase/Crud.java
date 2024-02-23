/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.interfase;

/**
 *
 * @author srhad
 */
public interface Crud {
    void Agregar();

    void Modificar();

    void EliminarLogico();

    Object Consultar();

    String ConsultarWhereAnd();
}
