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
public class Matricula implements Crud {

    private int id;
    private int estudiante_id;
    private String codigo;
    private String codigo_id;
    private String documento_estudiante;
    private int materia_id;
    private String materia_descripcion;
    private int nota;
    public Conexion conn = new Conexion();

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public String getDocumento_estudiante() {
        return documento_estudiante;
    }

    public void setDocumento_estudiante(String documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
    }

    public int getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(int materia_id) {
        this.materia_id = materia_id;
    }

    public String getMateria_descripcion() {
        return materia_descripcion;
    }

    public void setMateria_descripcion(String materia_descripcion) {
        this.materia_descripcion = materia_descripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_id() {
        return codigo_id;
    }

    public void setCodigo_id(String codigo_id) {
        this.codigo_id = codigo_id;
    }

    @Override
    public void Agregar() {
        String SqlU = "SELECT id "
                + "FROM estudiantes "
                + "WHERE documento = '" + this.documento_estudiante.toString() + "'";
        ResultSet resultSet = conn.consultarSQL(SqlU);

        System.out.println("modelo id" + documento_estudiante);
        try {
            while (resultSet.next()) {
                this.setEstudiante_id(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getEstudiante_id());

        String SqlUI = "SELECT id "
                + "FROM materia "
                + "WHERE descripcion = '" + this.materia_descripcion.toString() + "'";
        ResultSet resultSet2 = conn.consultarSQL(SqlUI);

        System.out.println("modelo id" + materia_descripcion);
        try {
            while (resultSet2.next()) {
                this.setMateria_id(resultSet2.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + this.getMateria_id());

        String sql = "Insert Into matricula(codigo,estudiante_id,materia_id,nota,created_at)"
                + " values("
                + "'" + this.getCodigo() + "',"
                + "" + this.getEstudiante_id() + ","
                + "" + this.getMateria_id() + ","
                + "" + this.getNota() + ","
                + "NOW()"
                + "); ";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String SqlUII = "SELECT id "
                + "FROM matricula "
                + "WHERE codigo = '" + this.codigo_id.toString() + "'";
        ResultSet resultSet3 = conn.RjecutarSQL(SqlUII);

        System.out.println("modelo id" + codigo_id);
        try {
            while (resultSet3.next()) {
                this.setId(resultSet3.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getId());

        String SqlU = "SELECT id "
                + "FROM estudiantes "
                + "WHERE documento = '" + this.documento_estudiante.toString() + "'";
        ResultSet resultSet = conn.RjecutarSQL(SqlU);

        System.out.println("modelo id" + documento_estudiante);
        try {
            while (resultSet.next()) {
                this.setEstudiante_id(resultSet.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getEstudiante_id());

        String SqlUI = "SELECT id "
                + "FROM materia "
                + "WHERE descripcion = '" + this.materia_descripcion.toString() + "'";
        ResultSet resultSet2 = conn.RjecutarSQL(SqlUI);

        System.out.println("modelo id" + materia_descripcion);
        try {
            while (resultSet2.next()) {
                this.setMateria_id(resultSet2.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getMateria_id());

        String sql = "UPDATE materia SET "
                + "codigo = '" + this.getEstudiante_id() + "', "
                + "estudiante_id = '" + this.getEstudiante_id() + "', "
                + "materia_id = '" + this.getMateria_id() + "', "
                + "nota = '" + this.getNota() + "', "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarLogico() {
        String SqlUII = "SELECT id "
                + "FROM matricula "
                + "WHERE codigo = '" + this.codigo.toString() + "'";
        ResultSet resultSet3 = conn.RjecutarSQL(SqlUII);

        System.out.println("modelo id" + codigo);
        try {
            while (resultSet3.next()) {
                this.setId(resultSet3.getInt("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Model.Entity.estudiante. id()" + getId());

        String sql = "UPDATE matricula set"
                + "deleted_at = now() "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Matricula> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT matricula.estudiante_id, matricula.materia_id, matricula.codigo, matricula.nota, "
                + "(SELECT materia.descripcion FROM materia WHERE matricula.materia_id = materia.id), "
                + "(SELECT estudiantes.documento FROM estudiantes WHERE matricula.estudiante_id = estudiantes.id) "
                + "FROM matricula;";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Matricula pais = new Matricula();
                String documentoEstudiante = resultSet.getString(6); // El documento del estudiante se encuentra en la sexta columna (índice 6).
                String descripcionMateria = resultSet.getString(5);
                pais.setId(resultSet.getInt("id"));
                pais.setCodigo(resultSet.getString("codigo"));
                pais.setDocumento_estudiante(documentoEstudiante);
                pais.setMateria_descripcion(descripcionMateria);
                pais.setNota(resultSet.getInt("nota"));

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
