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
public class Cliente implements Accion {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    public Conexion conn = new Conexion();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO cliente ("
                + "nombre, "
                + "correo, "
                + "telefono, "
                + "direccion, "
                + "created_at"
                + ") VALUES ("
                + "' " + this.getNombre() + "', "
                + "' " + this.getCorreo() + "', "
                + "' " + this.getTelefono() + "', "
                + "' " + this.getDireccion() + "', "
                + " NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;

        sql = "UPDATE cliente SET "
                + "nombre = '" + this.getNombre() + "', "
                + "correo = '" + this.getCorreo() + "', "
                + "telefono = " + this.getTelefono() + ", "
                + "direccion = '" + this.getDireccion() + "', "
                + "updated_at = NOW() "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM cliente\n"
                + "WHERE \n"
                + "	id= " + this.getId() + ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarLogico() {
        String sql;

        sql = "UPDATE cliente "
                + "SET "
                + "deleted_at=now() "
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public ArrayList<Cliente> Consultar() {
        ArrayList<Cliente> listaDeObjetos = new ArrayList<>();
        String sql;

        sql = "SELECT \n"
                + "	id,\n"
                + "	nombre,\n"
                + "	correo,\n"
                + "	telefono,\n"
                + "	direccion\n"
                + "FROM  \n"
                + "	cliente\n"
                + "WHERE deleted_at is null;";
        conn.ejecutarSQL(sql);

        ResultSet statement = conn.consultarSQL(sql);

        try {
            while (statement.next()) {
                // Procesar los resultados y crear objetos
                Cliente objeto = new Cliente();
                objeto.setId((long) statement.getInt("id"));
                objeto.setNombre(statement.getString("nombre"));
                objeto.setCorreo(statement.getString("correo"));
                objeto.setTelefono(statement.getString("telefono"));
                objeto.setDireccion(statement.getString("direccion"));
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
                + "    nombre,\n"
                + "    correo,\n"
                + "    telefono,\n"
                + "    direccion\n"
                + "FROM  \n"
                + "    cliente\n"
                + "WHERE "
                + "id=" + this.getId() + ";";
        conn.ejecutarSQL(sql);

        ResultSet statement = conn.consultarSQL(sql);

        try {
            while (statement.next()) {
                // Procesar los resultados y crear objetos

                objeto[0] = String.valueOf(statement.getInt("id"));
                objeto[1] = statement.getString("nombre");
                objeto[2] = statement.getString("correo");
                objeto[3] = statement.getString("telefono");
                objeto[4] = statement.getString("direccion");
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
