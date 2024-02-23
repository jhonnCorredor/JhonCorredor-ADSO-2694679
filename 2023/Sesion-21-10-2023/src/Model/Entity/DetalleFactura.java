/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interfase.Accion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author srhad
 */
public class DetalleFactura implements Accion {

    private Long id;
    private int cantidad;
    private Double valor_pagar;
    private Long producto_id;
    private Long factura_id;
    public Conexion conn = new Conexion();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(Double valor_pagar) {
        this.valor_pagar = valor_pagar;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(Long factura_id) {
        this.factura_id = factura_id;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO factura_detalle ("
                + "cantidad, "
                + "valor_pagar, "
                + "producto_id, "
                + "factura_id, "
                + "created_at"
                + ") VALUES ("
                + "' " + this.getCantidad() + "', "
                + "' " + this.getValor_pagar() + "', "
                + this.getProducto_id() + ", "
                + this.getFactura_id() + ", "
                + " NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;

        sql = "UPDATE factura_detalle "
                + "SET "
                + "cantidad='" + this.getCantidad() + "', "
                + "valor_pagar='" + this.getValor_pagar() + "', "
                + "prodcuto_id =" + this.getProducto_id() + ", "
                + "factura_id=" + this.getFactura_id() + ", "
                + "updated_at = now() "
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM factura_detalle\n"
                + "WHERE \n"
                + "	id= " + this.getId() + ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarLogico() {
        String sql;

        sql = "UPDATE factura_detalle "
                + "SET "
                + "deleted_at=now() "
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public ArrayList<DetalleFactura> Consultar() {
        ArrayList<DetalleFactura> listaDeObjetos = new ArrayList<>();
        String sql;

        sql = "SELECT \n"
                + "	id,\n"
                + "	cantidad,\n"
                + "	valor_pagar,\n"
                + "	producto_id,\n"
                + "	factura_id\n"
                + "FROM  \n"
                + "	factura\n"
                + "WHERE deleted_at is null;";
        conn.ejecutarSQL(sql);

        ResultSet statement = conn.consultarSQL(sql);

        try {
            while (statement.next()) {
                // Procesar los resultados y crear objetos
                DetalleFactura objeto = new DetalleFactura();
                objeto.setId((long) statement.getInt("id"));
                objeto.setCantidad(statement.getInt("cantidad"));
                objeto.setValor_pagar(statement.getDouble("valor_pagar"));
                objeto.setProducto_id(statement.getLong("producto_id"));
                objeto.setFactura_id(statement.getLong("factura_id"));
                // Agregar el objeto a la lista
                listaDeObjetos.add(objeto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn.cerrarConexion();

        return listaDeObjetos; // Mueve el return fuera del bucle
    }

    @Override
    public String ConsultarWhereAnd() {
        String[] objeto = new String[5];
        String sql;

        sql = "SELECT \n"
                + "	id,\n"
                + "	cantidad,\n"
                + "	valor_pagar,\n"
                + "	producto_id,\n"
                + "	factura_id\n"
                + "FROM  \n"
                + "	factura\n"
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);

        ResultSet statement = conn.consultarSQL(sql);

        try {
            while (statement.next()) {
                // Procesar los resultados y crear objetos

                objeto[0] = String.valueOf(statement.getInt("id"));
                objeto[1] = String.valueOf(statement.getInt("cantidad"));
                objeto[2] = String.valueOf(statement.getDouble("valor_pagar"));
                objeto[3] = String.valueOf(statement.getLong("producto_id"));
                objeto[4] = String.valueOf(statement.getLong("factura_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return null; // Puedes manejar el error de una forma más adecuada aquí
        } finally {
            conn.cerrarConexion();
        }

        // Empaquetar los valores en una sola cadena separada por algún carácter, por ejemplo, ","
        return String.join(",", objeto);
    }

}
