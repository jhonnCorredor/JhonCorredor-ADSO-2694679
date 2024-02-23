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
public class Pais implements Accion {

    private String DescripcionContinente;

    private int id;

    public String getDescripcionContinente() {
        return DescripcionContinente;
    }

    public void setDescripcionContinente(String DescripcionContinente) {
        this.DescripcionContinente = DescripcionContinente;
    }
    private String idDescripcion;

    public String getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }
    private String codigo_postal;
    private String descripcion;
    private int id_continente;
    private String descripcion_continente;
    public Conexion conn = new Conexion();

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

    public int getId_continente() {
        return id_continente;
    }

    public void setId_continente(int id_continente) {
        this.id_continente = id_continente;
    }

    public String getDescripcion_continente() {
        return descripcion_continente;
    }

    public void setDescripcion_continente(String descripcion_continente) {
        this.descripcion_continente = descripcion_continente;
    }

    @Override
    public void Agregar() {

        String sql = "SELECT continente.id "
                + "FROM continente "
                + "WHERE continente.descripcion = '" + this.DescripcionContinente.toString() + "'";

        ResultSet resultSet = conn.RjecutarSQL(sql);

        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.Pais.Agregar()" + getId());

        sql = "INSERT INTO pais (codigo_postal, descripcion, contiente_id ) VALUES (";
        sql += "'" + this.getCodigo_postal() + "', ";
        sql += "'" + this.getDescripcion() + "', ";

        sql += "'" + this.getId() + "');";
        System.out.println("Model.Entity.Pais.Agregar()" + getId());
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

    @Override

    public void Modificar() {

        String sql = "SELECT continente.id "
                + "FROM continente "
                + "WHERE continente.descripcion = '" + this.DescripcionContinente.toString() + "'";

        ResultSet resultSet1 = conn.RjecutarSQL(sql);

        try {
            while (resultSet1.next()) {
                this.setId_continente(resultSet1.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.Pais.id_continentge()" + getId_continente());

        String idSql = "SELECT id "
                + "FROM pais "
                + "WHERE descripcion = '" + this.idDescripcion.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(idSql);

        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.Pais. id()" + getId());

        sql = "UPDATE pais SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "contiente_id = '" + this.getId_continente() + "' "
                + "WHERE id = " + this.getId() + ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        // Obtener el ID del país
        String sqll = "SELECT pais.id FROM pais WHERE pais.descripcion = '" + this.descripcion + "'";
        ResultSet resultSet1 = conn.RjecutarSQL(sqll);

        try {
            while (resultSet1.next()) {
                this.setId(resultSet1.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Eliminar registros en la tabla ciudad que hacen referencia al estado del país
        String sql1 = "DELETE FROM ciudad WHERE estado_id IN (SELECT id FROM estado WHERE pais_id = " + this.getId() + ")";
        conn.ejecutarSQL(sql1);

        // Eliminar registros en la tabla estado que hacen referencia al país
        String sql2 = "DELETE FROM estado WHERE pais_id = " + this.getId();
        conn.ejecutarSQL(sql2);

        // Finalmente, eliminar el registro del país
        String sql3 = "DELETE FROM pais WHERE id = " + this.getId();
        conn.ejecutarSQL(sql3);

        // Cerrar la conexión
        conn.cerrarConexion();

    }

    @Override
    public Object Consultar() {
        ArrayList<Pais> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT pais.id, pais.codigo_postal, pais.descripcion, pais.contiente_id, continente.descripcion AS continenteDescripcion \n"
                + "FROM pais \n"
                + "INNER JOIN continente ON pais.contiente_id = continente.id \n"
                + ";";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Pais pais = new Pais();
                pais.setId(resultSet.getInt("id"));
                pais.setCodigo_postal(resultSet.getString("codigo_postal"));
                pais.setDescripcion(resultSet.getString("descripcion"));
                pais.setId_continente(resultSet.getInt("contiente_id"));
                pais.setDescripcion_continente(resultSet.getString("continenteDescripcion"));

                listaDeObjetos.add(pais);
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
