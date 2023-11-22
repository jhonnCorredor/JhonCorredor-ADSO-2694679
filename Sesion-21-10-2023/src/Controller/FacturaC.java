/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Factura;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author srhad
 */
public class FacturaC {

    public void GuardarRegistro(String codigo, Double valor_total,Date fecha, Long cliente_id) {
        Factura factura = new Factura();
        factura.setCodigo(codigo);
        factura.setValor_total(valor_total);
        factura.setFecha(fecha);
        factura.setCliente_id(cliente_id);
        factura.Agregar();
    }

    public void ModificarRegistro(Long id, String codigo, Date fecha, Double valor_total, Long cliente_id) {
        Factura factura = new Factura();
        factura.setId(id);
        factura.setCodigo(codigo);
        factura.setFecha(fecha);
        factura.setValor_total(valor_total);
        factura.setCliente_id(cliente_id);
        factura.Modificar();
    }

    public void EliminarFisicoRegistro(Long id) {
        Factura factura = new Factura();
        factura.setId(id);
        factura.EliminarFisico();
    }

    public void EliminarLogicoRegistro(Long id) {
        Factura factura = new Factura();
        factura.setId(id);
        factura.EliminarLogico();
    }

    public ArrayList<Factura> ConsultarRegistros() {
        ArrayList<Factura> listaDeObjetos = new ArrayList<>();
        Factura factura = new Factura();
        listaDeObjetos = factura.Consultar();
        return listaDeObjetos;
    }

    public String[] BuscarRegistro(Long id) {
        Factura factura = new Factura();
        factura.setId(id);
        String resultado = factura.ConsultarWhereAnd(); // Llama al método ConsultarWhereAnd para obtener la cadena de datos
        if (resultado != null) {
            String[] valores = resultado.split(","); // Divide la cadena en valores individuales
            return valores;
        } else {
            // Manejar el caso en el que no se encontraron datos en ConsultarWhereAnd
            return null;
        }
    }
}
