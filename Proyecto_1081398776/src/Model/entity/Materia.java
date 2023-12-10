/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.entity;

import Conexion.Conexion;
import Model.interfase.Crud;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class Materia implements Crud {

    private int id;
    private String descripcion;
    private String descripcion_id;
    private String aula;
    private String horas_duracion;
    public Conexion conn = new Conexion();

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getHoras_duracion() {
        return horas_duracion;
    }

    public void setHoras_duracion(String horas_duracion) {
        this.horas_duracion = horas_duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion_id() {
        return descripcion_id;
    }

    public void setDescripcion_id(String descripcion_id) {
        this.descripcion_id = descripcion_id;
    }

    @Override
    public void Agregar() {
        String sql = "INSERT INTO materia (descripcion, Aula, horas_duracion, created_at) "
                + "VALUES ("
                + "'" + this.getDescripcion() + "', "
                + "'" + this.getAula() + "', '"
                + this.getHoras_duracion() + "', "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String SqlU = "SELECT id "
                + "FROM materia "
                + "WHERE descripcion = '" + this.descripcion_id.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(SqlU);

        System.out.println("modelo id" + descripcion_id);
        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getId());

        String sql = "UPDATE materia SET "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "Aula = '" + this.getAula() + "', "
                + "horas_duracion = '" + this.getHoras_duracion() + "' "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarLogico() {
        String SqlU = "SELECT id "
                + "FROM materia "
                + "WHERE descripcion = '" + this.descripcion.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(SqlU);

        System.out.println("modelo id" + descripcion);
        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getId());

        String sql = "UPDATE materia set"
                + "deleted_at = now() "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Materia> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT * FROM materia ";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Materia continente = new Materia();
                continente.setId(resultSet.getInt("id"));
                continente.setDescripcion(resultSet.getString("descripcion"));
                continente.setAula(resultSet.getString("Aula"));
                continente.setHoras_duracion(resultSet.getString("horas_duracion"));

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
