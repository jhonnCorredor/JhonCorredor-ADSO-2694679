/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interface.Accion;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author srhad
 */
public class Ciudad implements Accion{
    private String DescripcionEstado;
    private int id;
    private String codigo_postal;
    private String idDescripcion;
    public String getDescripcionEstado() {
        return DescripcionEstado;
    }

    public String getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public void setDescripcionEstado(String DescripcionEstado) {
        this.DescripcionEstado = DescripcionEstado;
    }
    private String descripcion;
    private int id_estado;
    private String descripcion_estado;
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

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getDescripcion_estado() {
        return descripcion_estado;
    }

    public void setDescripcion_estado(String descripcion_estado) {
        this.descripcion_estado = descripcion_estado;
    }


    @Override
    public void Agregar() {
       String sql = "SELECT estado.id " +
        "FROM estado " +
        "WHERE estado.descripcion = '" + this.DescripcionEstado.toString() + "'";

        ResultSet resultSet = conn.RjecutarSQL(sql);

        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       System.out.println("Model.Entity.Pais.Agregar()"+getId());
    

            sql = "INSERT INTO ciudad (codigo_postal, descripcion, estado_id) VALUES (";
         sql += "'" + this.getCodigo_postal() + "', ";
         sql += "'" + this.getDescripcion() + "', ";
         System.out.println("Model.Entity.Pais.Agregar()"+getId());
         sql += "'" + this.getId() + "');";
             conn.ejecutarSQL(sql);
             conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
      
       String sql = "SELECT estado.id " +
        "FROM estado " +
        "WHERE estado.descripcion = '" + this.DescripcionEstado.toString() + "'";

        ResultSet resultSet1 = conn.RjecutarSQL(sql);

          try {
            while (resultSet1.next()) {
                this.setId_estado(resultSet1.getInt("id"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          System.out.println("Model.Entity.Pais.id_continentge()"+getId_estado());
       

        
         String idSql = "SELECT id " +
        "FROM ciudad " +
        "WHERE descripcion = '" + this.idDescripcion.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(idSql);

        try {
            while (resultSet.next()) {
                this.setId(resultSet.getInt("id"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       System.out.println("Model.Entity.Pais. id()"+getId());
       

      
        
        
       sql = "UPDATE ciudad SET "
     + "codigo_postal = '" + this.getCodigo_postal() + "', "
     + "descripcion = '" + this.getDescripcion() + "', "
     + "estado_id = '" + this.getId_estado()+ "' "
     + "WHERE id = " + this.getId()+ ";";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM ciudad\n"
                + "WHERE \n"
                + "descripcion= '" + this.getDescripcion()+ "';";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Ciudad> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT ciudad.id, ciudad.codigo_postal, ciudad.descripcion, ciudad.estado_id, estado.descripcion AS eDescripcion \n"
                + "FROM ciudad \n"
                + "INNER JOIN estado ON ciudad.estado_id = estado.id \n"
                + ";";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId(resultSet.getInt("id"));
                ciudad.setCodigo_postal(resultSet.getString("codigo_postal"));
                ciudad.setDescripcion(resultSet.getString("descripcion"));
                ciudad.setId_estado(resultSet.getInt("estado_id"));
                ciudad.setDescripcion_estado(resultSet.getString("eDescripcion"));
                
                listaDeObjetos.add(ciudad);
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
