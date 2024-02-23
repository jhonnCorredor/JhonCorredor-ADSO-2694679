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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author srhad
 */
public class Factura implements Accion {

    private Long id;
    private String codigo;
    private Date fecha;
    private Double valor_total;
    private Long cliente_id;
    public Conexion conn = new Conexion();

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO factura ("
                + "codigo, "
                + "fecha, "
                + "valor_total, "
                + "cliente_id, "
                + "created_at"
                + ") VALUES ("
                + "' " + this.getCodigo() + "', "
                + "' " + this.getFecha() + "', "
                + this.getValor_total() + ", "
                + this.getCliente_id() + ", "
                + " now()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;

        sql = "UPDATE factura "
                + "SET "
                + "codigo='" + this.getCodigo() + "', "
                + "fecha='" + this.getFecha() + "', "
                + "valor_total =" + this.getValor_total() + ", "
                + "cliente_id=" + this.getCliente_id() + ", "
                + "updated_at = now() "
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM factura\n"
                + "WHERE \n"
                + "	id= " + this.getId() + ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarLogico() {
        String sql;

        sql = "UPDATE factura "
                + "SET "
                + "deleted_at=now() "
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public ArrayList<Factura> Consultar() {
        ArrayList<Factura> listaDeObjetos = new ArrayList<>();
        String sql;

        sql = "SELECT \n"
                + "	id,\n"
                + "	codigo,\n"
                + "	fecha,\n"
                + "	valor_total,\n"
                + "	cliente_id\n"
                + "FROM  \n"
                + "	factura\n"
                + "WHERE deleted_at is null;";
        conn.ejecutarSQL(sql);

        ResultSet statement = conn.consultarSQL(sql);

        try {
            while (statement.next()) {
                // Procesar los resultados y crear objetos
                Factura objeto = new Factura();
                objeto.setId((long) statement.getInt("id"));
                objeto.setCodigo(statement.getString("codigo"));
                objeto.setFecha(statement.getDate("fecha"));
                objeto.setValor_total(statement.getDouble("valor_total"));
                objeto.setCliente_id(statement.getLong("cliente_id"));
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
                + "	codigo,\n"
                + "	fecha,\n"
                + "	valor_total,\n"
                + "	cliente_id\n"
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
                objeto[1] = statement.getString("codigo");
                objeto[2] = String.valueOf(statement.getDate("fecha"));
                objeto[3] = String.valueOf(statement.getDouble("valor_total"));
                objeto[4] = String.valueOf(statement.getInt("cliente_id"));
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
