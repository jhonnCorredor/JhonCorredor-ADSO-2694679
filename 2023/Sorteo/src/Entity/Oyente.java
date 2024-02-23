package Entity;

import java.util.ArrayList;
import java.util.List;

public class Oyente {

    private String documento;
    private String nombre;
    private String genero;
    private int edad;
    private String telefono;
    List<Canciones> canciones = new ArrayList<>();

    public Oyente(String documento, String nombre, String genero, int edad, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.telefono = telefono;
    }

    public List<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Canciones> canciones) {
        this.canciones = canciones;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
