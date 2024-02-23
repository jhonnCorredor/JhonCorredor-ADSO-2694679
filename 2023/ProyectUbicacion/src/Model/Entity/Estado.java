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
public class Estado implements Accion {

    public String getDescripcionPais() {
        return DescripcionPais;
    }

    public String getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public void setDescripcionPais(String DescripcionPais) {
        this.DescripcionPais = DescripcionPais;
    }
    private String idDescripcion;
    private String DescripcionPais;
    private int id;
    private String codigo_postal;
    private String descripcion;
    private int id_pais;
    private String Descripcion_pais;
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

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getDescripcion_pais() {
        return Descripcion_pais;
    }

    public void setDescripcion_pais(String Descripcion_pais) {
        this.Descripcion_pais = Descripcion_pais;
    }

    @Override
    public void Agregar() {
        String sql = "SELECT pais.id "
                + "FROM pais "
                + "WHERE pais.descripcion = '" + this.DescripcionPais.toString() + "'";

        ResultSet resultSet = conn.RjecutarSQL(sql);

        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.Pais.Agregar()" + getId());

        sql = "INSERT INTO estado (codigo_postal, descripcion, pais_id ) VALUES (";
        sql += "'" + this.getCodigo_postal() + "', ";
        sql += "'" + this.getDescripcion() + "', ";
        System.out.println("Model.Entity.Pais.Agregar()" + getId());
        sql += "'" + this.getId() + "');";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {

        String sql = "SELECT pais.id "
                + "FROM pais "
                + "WHERE pais.descripcion = '" + this.DescripcionPais.toString() + "'";

        ResultSet resultSet1 = conn.RjecutarSQL(sql);

        try {
            while (resultSet1.next()) {
                this.setId_pais(resultSet1.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.Pais.id_continentge()" + getId_pais());

        String idSql = "SELECT id "
                + "FROM estado "
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

        sql = "UPDATE estado SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "pais_id = '" + this.getId_pais() + "' "
                + "WHERE id = " + this.getId() + ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        // Obtener el ID del estado
        String sqll = "SELECT estado.id FROM estado WHERE estado.descripcion = '" + this.descripcion + "'";
        ResultSet resultSet1 = conn.RjecutarSQL(sqll);

        try {
            while (resultSet1.next()) {
                this.setId(resultSet1.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Eliminar registros en la tabla ciudad que hacen referencia al estado
        String sql1 = "DELETE FROM ciudad WHERE estado_id = " + this.getId();
        conn.ejecutarSQL(sql1);

        // Finalmente, eliminar el registro del estado
        String sql2 = "DELETE FROM estado WHERE id = " + this.getId();
        conn.ejecutarSQL(sql2);

        // Cerrar la conexión
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Estado> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT estado.id, estado.codigo_postal, estado.descripcion, estado.pais_id, pais.descripcion AS pDescripcion \n"
                + "FROM estado \n"
                + "INNER JOIN pais ON estado.pais_id = pais.id \n"
                + ";";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("id"));
                estado.setCodigo_postal(resultSet.getString("codigo_postal"));
                estado.setDescripcion(resultSet.getString("descripcion"));
                estado.setId_pais(resultSet.getInt("pais_id"));
                estado.setDescripcion_pais(resultSet.getString("pDescripcion"));

                listaDeObjetos.add(estado);
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
