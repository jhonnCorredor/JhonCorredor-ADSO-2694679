/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interface.Accion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class Continente implements Accion {

    private int id;

    public String getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }
    private String codigo_postal;
    private String descripcion;
    public Conexion conn = new Conexion();
    private String idDescripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void Agregar() {
        String sql;
        sql = "INSERT INTO continente (codigo_postal, descripcion) VALUES (";
        sql += "'" + this.getCodigo_postal() + "', ";
        sql += "'" + this.getDescripcion() + "');";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

    @Override
    public void Modificar() {
        String SqlU = "SELECT id "
                + "FROM continente "
                + "WHERE descripcion = '" + this.idDescripcion.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(SqlU);

        System.out.println("modelo id" + idDescripcion);
        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.Pais. id()" + getId());

        String sql = "UPDATE continente SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "' "
                + "WHERE id = " + this.getId() + ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

    @Override
    public void EliminarFisico() {
        String sqll = "SELECT continente.id FROM continente WHERE continente.descripcion = '" + this.descripcion + "'";
        ResultSet resultSet1 = conn.RjecutarSQL(sqll);

        try {
            while (resultSet1.next()) {
                this.setId(resultSet1.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

// Eliminar registros en la tabla "ciudad" que dependen de los estados
        String sql1 = "DELETE FROM ciudad WHERE estado_id IN (SELECT id FROM estado WHERE pais_id IN (SELECT id FROM pais WHERE contiente_id = " + getId() + "))";
        conn.ejecutarSQL(sql1);

// Eliminar registros en la tabla "estado" que dependen de los países
        String sql2 = "DELETE FROM estado WHERE pais_id IN (SELECT id FROM pais WHERE contiente_id = " + getId() + ")";
        conn.ejecutarSQL(sql2);

// Eliminar registros en la tabla "pais" que dependen del continente
        String sql3 = "DELETE FROM pais WHERE contiente_id = " + getId();
        conn.ejecutarSQL(sql3);

// Finalmente, puedes eliminar el registro del continente
        String sql4 = "DELETE FROM continente WHERE id = " + getId();
        conn.ejecutarSQL(sql4);

        conn.cerrarConexion();

    }

    @Override
    public Object Consultar() {
        ArrayList<Continente> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT * FROM continente";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Continente continente = new Continente();
                continente.setId(resultSet.getInt("id"));
                continente.setCodigo_postal(resultSet.getString("codigo_postal"));
                continente.setDescripcion(resultSet.getString("descripcion"));

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
