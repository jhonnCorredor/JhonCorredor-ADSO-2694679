package Entity;

public class Canciones {

    private String titulo;
    private Artista artista;
    private int voto;

    public Canciones(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
        this.voto = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public void addVoto(){
        this.voto = this.voto +1;
    }
}
