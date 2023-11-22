package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Encuesta {

    static ArrayList<Artista> artistas = new ArrayList<>();
    static ArrayList<Canciones> canciones = new ArrayList<>();
    // Crear un mapa para agrupar las canciones por artista
    static Map<String, List<Canciones>> cancionesPorArtista = new HashMap<>();
    public static Map<String, List<Canciones>> getCancionesPorArtista() {
        return cancionesPorArtista;
    }

    public static void setCancionesPorArtista(Map<String, List<Canciones>> cancionesPorArtista) {
        Encuesta.cancionesPorArtista = cancionesPorArtista;
    }

    static public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public static void setArtistas(ArrayList<Artista> artistas) {
        Encuesta.artistas = artistas;
    }

    static public ArrayList<Canciones> getCanciones() {
        return canciones;
    }

    static public void setCanciones(ArrayList<Canciones> canciones) {
        Encuesta.canciones = canciones;
    }

    public static void CrearCanciones(){
       // Crear una lista de artistas
        artistas.add(new Artista("Michael Joseph Jackson"));
        artistas.add(new Artista("Van Gogh"));
        artistas.add(new Artista("Pablo Picasso"));
        artistas.add(new Artista("Andy Warhol"));
        artistas.add(new Artista("Salvador Dalí"));
        artistas.add(new Artista("Frida Kahlo"));
        artistas.add(new Artista("Andy Warhol"));
        artistas.add(new Artista("Claude Monet"));
        artistas.add(new Artista("Georgia O'Keeffe"));
        artistas.add(new Artista("Jackson Pollock"));

        // Crear una lista de canciones y asociarlas a artistas
        canciones.add(new Canciones("Thriller", artistas.get(0)));
        canciones.add(new Canciones("Billie Jean", artistas.get(0)));
        canciones.add(new Canciones("Beat it", artistas.get(0)));
        canciones.add(new Canciones("Black or White", artistas.get(0)));
        canciones.add(new Canciones("We are the world", artistas.get(0)));
        canciones.add(new Canciones("Night Sky Symphony", artistas.get(1)));
        canciones.add(new Canciones("Starry Starry Night", artistas.get(1)));
        canciones.add(new Canciones("Vincent's Dreams", artistas.get(1)));
        canciones.add(new Canciones("Sunflower Waltz", artistas.get(1)));
        canciones.add(new Canciones("Café Terrace Sonata", artistas.get(1)));
        canciones.add(new Canciones("Guernica's Echoes", artistas.get(2)));
        canciones.add(new Canciones("Blue Hues Harmony", artistas.get(2)));
        canciones.add(new Canciones("Dance of Demons", artistas.get(2)));
        canciones.add(new Canciones("Palette of Picasso", artistas.get(2)));
        canciones.add(new Canciones("Bullfight Rhapsody", artistas.get(2)));
        canciones.add(new Canciones("Leonardo's Legacy", artistas.get(3)));
        canciones.add(new Canciones("Van Gogh's Whispers", artistas.get(3)));
        canciones.add(new Canciones("Canvas of Stars	", artistas.get(3)));
        canciones.add(new Canciones("Mysteries of Art", artistas.get(3)));
        canciones.add(new Canciones("The Artistic Journey	", artistas.get(3)));
        canciones.add(new Canciones("Starry Nights", artistas.get(4)));
        canciones.add(new Canciones("Flower Power", artistas.get(4)));
        canciones.add(new Canciones("Dali's Dreams", artistas.get(4)));
        canciones.add(new Canciones("Surreal Symphony", artistas.get(4)));
        canciones.add(new Canciones("Melting Time", artistas.get(4)));
        canciones.add(new Canciones("Frida's Tears", artistas.get(5)));
        canciones.add(new Canciones("Diego's Love", artistas.get(5)));
        canciones.add(new Canciones("Mexican Masterpiece", artistas.get(5)));
        canciones.add(new Canciones("Self-Portrait Serenade", artistas.get(5)));
        canciones.add(new Canciones("Viva La Vida", artistas.get(5)));
        canciones.add(new Canciones("Warhol's Pop", artistas.get(6)));
        canciones.add(new Canciones("Factory of Colors", artistas.get(6)));
        canciones.add(new Canciones("Soup Can Sonata", artistas.get(6)));
        canciones.add(new Canciones("15 Minutes of Fame", artistas.get(6)));
        canciones.add(new Canciones("Andy's Imagination", artistas.get(6)));
        canciones.add(new Canciones("Water Lilies Waltz", artistas.get(7)));
        canciones.add(new Canciones("Garden of Colors", artistas.get(7)));
        canciones.add(new Canciones("Garden of Colors", artistas.get(7)));
        canciones.add(new Canciones("Claude's Reflections", artistas.get(7)));
        canciones.add(new Canciones("Bridge Over Dreams", artistas.get(7)));
        canciones.add(new Canciones("O'Keeffe's Abstraction", artistas.get(8)));
        canciones.add(new Canciones("Georgia's Desert Blues", artistas.get(8)));
        canciones.add(new Canciones("Flowers in Close-up", artistas.get(8)));
        canciones.add(new Canciones("Skull and Petals", artistas.get(8)));
        canciones.add(new Canciones("Red Hills Rhapsody", artistas.get(8)));
        canciones.add(new Canciones("Drip Art Symphony", artistas.get(9)));
        canciones.add(new Canciones("Pollock's Chaos", artistas.get(9)));
        canciones.add(new Canciones("Splatter Serenade", artistas.get(9)));
        canciones.add(new Canciones("Number 5 Tango", artistas.get(9)));
        canciones.add(new Canciones("Abstract Expressions", artistas.get(9)));

        // Llenar el mapa con las canciones asociadas a cada artista
        for (Canciones cancion : canciones) {
            String nombreArtista = cancion.getArtista().getNombre();
            if (!cancionesPorArtista.containsKey(nombreArtista)) {
                cancionesPorArtista.put(nombreArtista, new ArrayList<>());
            }
            cancionesPorArtista.get(nombreArtista).add(cancion);
        }
 
    }
    static public Map<String, List<Canciones>> ConsultaLista() {
        return cancionesPorArtista;
    }
}
