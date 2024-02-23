package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Sorteo {

    Random random = new Random();
    private Boleto boGnador;
    ArrayList<Boleto> boleto = new ArrayList<>(50);
    ArrayList<Oyente> oyente = new ArrayList<>(50);
    Map<String, List<Canciones>> cancionesPorArtista = Encuesta.ConsultaLista();
    
    public ArrayList<Boleto> getBoleto() {
        return boleto;
    }
    
    public String CrearRandom(String[] variable) {
        int index = random.nextInt(variable.length);
        return variable[index];
    }

    public String GenRandom() {
        String[] nombres = {"Masculino", "Femenino"};
        return this.CrearRandom(nombres);
    }

    public String NomRandom(String a) {
        if ("Masculino".equals(a)) {
            String[] nombres1 = {"Juan", "Daniel", "Pedro", "José", "Manuel", "David", "Carlos"};
            return this.CrearRandom(nombres1);
        }
        if ("Femenino".equals(a)) {
            String[] nombres = {"Ana", "Sofía", "María", "Laura", "Lizeth", "Elizabeth", "Julieta"};
            return this.CrearRandom(nombres);
        }
        return null;
    }

    public String DocRandom() {
        int e;
        e = (int) (Math.random() * (999999999 - 111111111)) + 111111111;
        String a = "1" + e;
        return a;
    }

    public String NumRandom() {
        int e, c;
        c = (int) (Math.random() * (99 - 11)) + 11;
        e = (int) (Math.random() * (9999999 - 1111111)) + 1111111;
        String a = "3" + c + " " + e;
        return a;
    }

    public ArrayList<Boleto> CrearBoletos() {
        int a;
        int e;
        String b;
        for (int i = 0; i < 50; i++) {
            b = GenRandom();
            e = (int) (Math.random() * (70 - 15)) + 15;
            Oyente h = new Oyente(DocRandom(), NomRandom(b), b, e, NumRandom());
            h.setCanciones(this.GenRespuesta());
            oyente.add(h);
            a = (int) (Math.random() * (5 - 1)) + 1;
            Boleto bo = new Boleto(i + 1, a, oyente.get(i));
            boleto.add(bo);
        }
        return boleto;
    }

    public List<Canciones> GenRespuesta() {
        List<Canciones> canciones = new ArrayList<>();
        String[] artista = {"Michael Joseph Jackson", "Van Gogh", "Pablo Picasso", "Andy Warhol", "Salvador Dalí", "Frida Kahlo", "Andy Warhol", "Claude Monet", "Georgia O'Keeffe", "Jackson Pollock"};
        String a = this.CrearRandom(artista);
        for (int i = 0; i < 3; i++) {
            List<Canciones> cancion = cancionesPorArtista.get(a);
            int e = (int) (Math.random() * 4);
            cancion.get(e).addVoto();
            canciones.add(cancion.get(e));
            
        }
        return canciones;
    }

    public Boleto CrearGanador(ArrayList<Boleto> boleto) {
        int ganador = (int) (Math.random() * boleto.size());
        boGnador = boleto.get(ganador);
        return boGnador;
    }
}
