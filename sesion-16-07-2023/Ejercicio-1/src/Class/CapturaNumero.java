package Class;

import java.util.Scanner;

public class CapturaNumero {

    private Double numero;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    private void setNumero(Double numero) {
        this.numero = numero;
    }

    private Double getNumero() {
        return this.numero;
    }

    public double Capturar() {
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.println(this.getMensaje());
                this.setNumero(Double.parseDouble(scan.next()));
                if (this.getNumero() <= 0) {
                    System.out.println("Dato no valido,solo numeros positivos.");
                }
            } catch (Exception e) {
                System.out.println("Dato no valido, no se admite caracteres alfanumericos.");
                this.setNumero(Double.parseDouble("0"));
            }
        } while (this.getNumero() <= 0);

        return this.getNumero();
    }
}
