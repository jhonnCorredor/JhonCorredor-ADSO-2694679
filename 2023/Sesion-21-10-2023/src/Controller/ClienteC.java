/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Cliente;
import Model.Entity.Producto;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class ClienteC {

    public void GuardarRegistro(String nombre, String correo, String telefono, String direccion) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.Agregar();
    }

    public void ModificarRegistro(Long id, String nombre, String correo, String telefono, String direccion) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.Modificar();
    }

    public void EliminarFisicoRegistro(Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.EliminarFisico();
    }

    public void EliminarLogicoRegistro(Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.EliminarLogico();
    }

    public ArrayList<Cliente> ConsultarRegistros() {
        ArrayList<Cliente> listaDeObjetos = new ArrayList<>();
        Cliente cliente = new Cliente();
        listaDeObjetos = cliente.Consultar();
        return listaDeObjetos;
    }

    public String[] BuscarRegistro(Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        String resultado = cliente.ConsultarWhereAnd(); // Llama al método ConsultarWhereAnd para obtener la cadena de datos
        if (resultado != null) {
            String[] valores = resultado.split(","); // Divide la cadena en valores individuales
            return valores;
        } else {
            // Manejar el caso en el que no se encontraron datos en ConsultarWhereAnd
            return null;
        }
    }
}
