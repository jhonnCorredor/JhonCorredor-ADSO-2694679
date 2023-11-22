/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.DetalleFactura;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author srhad
 */
public class DetalleFacturaC {

    public void GuardarRegistro(int cantidad, Double valor_pagar, Long producto_id, Long Factura_id) {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setCantidad(cantidad);
        detalleFactura.setValor_pagar(valor_pagar);
        detalleFactura.setProducto_id(producto_id);
        detalleFactura.setFactura_id(Factura_id);
        detalleFactura.Agregar();
    }

    public void ModificarRegistro(Long id, int cantidad, Double valor_pagar, Long producto_id, Long Factura_id) {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setId(id);
        detalleFactura.setCantidad(cantidad);
        detalleFactura.setValor_pagar(valor_pagar);
        detalleFactura.setProducto_id(producto_id);
        detalleFactura.setFactura_id(Factura_id);
        detalleFactura.Modificar();
    }

    public void EliminarFisicoRegistro(Long id) {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setId(id);
        detalleFactura.EliminarFisico();
    }

    public void EliminarLogicoRegistro(Long id) {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setId(id);
        detalleFactura.EliminarLogico();
    }

    public ArrayList<DetalleFactura> ConsultarRegistros() {
        ArrayList<DetalleFactura> listaDeObjetos = new ArrayList<>();
        DetalleFactura detalleFactura = new DetalleFactura();
        listaDeObjetos = detalleFactura.Consultar();
        return listaDeObjetos;
    }

    public String[] BuscarRegistro(Long id) {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setId(id);
        String resultado = detalleFactura.ConsultarWhereAnd(); // Llama al método ConsultarWhereAnd para obtener la cadena de datos
        if (resultado != null) {
            String[] valores = resultado.split(","); // Divide la cadena en valores individuales
            return valores;
        } else {
            // Manejar el caso en el que no se encontraron datos en ConsultarWhereAnd
            return null;
        }
    }
}
