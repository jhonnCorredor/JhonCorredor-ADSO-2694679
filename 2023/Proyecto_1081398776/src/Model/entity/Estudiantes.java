/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.entity;

import Conexion.Conexion;
import Model.interfase.Crud;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class Estudiantes implements Crud {

    private int id;
    private String nombre;
    private String edad;
    private String documento;
    private String documento_id;
    private String telefono;
    private String correo;
    public Conexion conn = new Conexion();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento_id() {
        return documento_id;
    }

    public void setDocumento_id(String documento_id) {
        this.documento_id = documento_id;
    }

    @Override
    public void Agregar() {
        String sql = "INSERT INTO estudiantes (nombre, edad, documento, telefono, correo, created_at) "
                + "VALUES ('" + this.getNombre() + "', "
                + this.getEdad() + ", '"
                + this.getDocumento() + "', '"
                + this.getTelefono() + "', '"
                + this.getCorreo() + "', "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String SqlU = "SELECT id "
                + "FROM estudiantes "
                + "WHERE documento = '" + this.documento_id.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(SqlU);

        System.out.println("modelo id" + documento_id);
        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getId());

        String sql = "UPDATE estudiantes SET "
                + "nombre = '" + this.getNombre() + "', "
                + "edad = '" + this.getEdad() + "', "
                + "documento = '" + this.getDocumento() + "', "
                + "telefono = '" + this.getTelefono() + "', "
                + "correo = '" + this.getCorreo() + "' "
                + "WHERE id = " + this.getId() + ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarLogico() {
        String SqlU = "SELECT id "
                + "FROM estudiantes "
                + "WHERE documento = '" + this.documento.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(SqlU);

        System.out.println("modelo id" + documento);
        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getId());

        String sql = "UPDATE estudiantes set"
                + "deleted_at = now() "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Estudiantes> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Estudiantes continente = new Estudiantes();
                continente.setId(resultSet.getInt("id"));
                continente.setNombre(resultSet.getString("nombre"));
                continente.setEdad(resultSet.getString("edad"));
                continente.setDocumento(resultSet.getString("documento"));
                continente.setTelefono(resultSet.getString("telefono"));
                continente.setCorreo(resultSet.getString("correo"));

                listaDeObjetos.add(continente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeObjetos;
    }

    @Override
    public String ConsultarWhereAnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
