/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Producto;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class ProductoC {
     public void GuardarRegistro(String codigo, String nombre, Double precio, Long cantidad){
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.Agregar();
    }
    
    public void ModificarRegistro(Long  id, String codigo, String nombre, Double precio, Long cantidad){
        Producto producto = new Producto();
        producto.setId(id);
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.Modificar();
    }
    
    public void EliminarFisicoRegistro(Long id){
        Producto producto = new Producto();
        producto.setId(id);
        producto.EliminarLogico();
    }
    
    public void EliminarLogicoRegistro(Long id){
        Producto producto = new Producto();
        producto.setId(id);
        producto.EliminarLogico();
    }
    
    public ArrayList<Producto> ConsultarRegistros(){
        ArrayList<Producto> listaDeObjetos = new ArrayList<>();
        Producto producto = new Producto();
        listaDeObjetos=producto.Consultar();
        return listaDeObjetos;
    }
    
    public String[] BuscarRegistro(Long id){
        Producto producto = new Producto();
        producto.setId(id);
        String resultado = producto.ConsultarWhereAnd(); // Llama al método ConsultarWhereAnd para obtener la cadena de datos
    if (resultado != null) {
        String[] valores = resultado.split(","); // Divide la cadena en valores individuales
        return valores;
    } else {
        // Manejar el caso en el que no se encontraron datos en ConsultarWhereAnd
        return null;
    }
    }
}
