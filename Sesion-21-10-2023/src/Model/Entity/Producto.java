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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author srhad
 */
public class Producto implements Accion {

    private Long id;
    private String codigo;
    private String nombre;
    private Double precio;
    private Long cantidad;
    public Conexion conn = new Conexion();

    public Producto() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO producto ("
                + "codigo, "
                + "nombre, "
                + "precio, "
                + "cantidad, "
                + "created_at"
                + ") VALUES ("
                + "' " + this.getCodigo() + "', "
                + "' " + this.getNombre() + "', "
                + this.getPrecio() + ", "
                + this.getCantidad() + ", "
                + " NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

    @Override
    public void Modificar() {
        String sql;

        sql = "UPDATE producto "
                + "SET "
                + "codigo='" + this.getCodigo() + "', "
                + "nombre='" + this.getNombre() + "', "
                + "precio=" + this.getPrecio() + ", "
                + "cantidad=" + this.getCantidad() + ", "
                + "updated_at = now() "
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarLogico() {
        String sql;

        sql = "UPDATE producto "
                + "SET "
                + "deleted_at=now() "
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public ArrayList<Producto> Consultar() {
        ArrayList<Producto> listaDeObjetos = new ArrayList<>();
        String sql;

        sql = "SELECT \n"
                + "	id,\n"
                + "	codigo,\n"
                + "	nombre,\n"
                + "	precio,\n"
                + "	cantidad\n"
                + "FROM  \n"
                + "	producto\n"
                + "WHERE deleted_at is null;";
        conn.ejecutarSQL(sql);

        ResultSet statement = conn.consultarSQL(sql);

        try {
            while (statement.next()) {
                // Procesar los resultados y crear objetos
                Producto objeto = new Producto();
                objeto.setId((long) statement.getInt("id"));
                objeto.setNombre(statement.getString("nombre"));
                objeto.setCodigo(statement.getString("codigo"));
                objeto.setPrecio(statement.getDouble("precio"));
                objeto.setCantidad(Long.parseLong(statement.getString("cantidad")));
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
                + "    id,\n"
                + "    codigo,\n"
                + "    nombre,\n"
                + "    precio,\n"
                + "    cantidad\n"
                + "FROM  \n"
                + "    producto\n"
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);

        ResultSet statement = conn.consultarSQL(sql);

        try {
            while (statement.next()) {
                // Procesar los resultados y crear objetos

                objeto[0] = String.valueOf(statement.getInt("id"));
                objeto[1] = statement.getString("nombre");
                objeto[2] = statement.getString("codigo");
                objeto[3] = String.valueOf(statement.getDouble("precio"));
                objeto[4] = String.valueOf(statement.getLong("cantidad"));
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

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM producto\n"
                + "WHERE \n"
                + "	id= "+this.getId() +";";
        
       conn.ejecutarSQL(sql);
       conn.cerrarConexion();
    }
}
