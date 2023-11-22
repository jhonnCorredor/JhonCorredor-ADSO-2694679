package View;

import Class.CapturaNumero;

public class Tienda {

    public static void main(String[] args) {
        Integer cantidad, i, contApr, contDes;
        Double porApr, porDes, nota;

        CapturaNumero cap = new CapturaNumero();

        cap.setMensaje("Digite la cantidad de Aprendices: ");
        cantidad = (int) cap.Capturar();

        i = 0;
        contApr = 0;
        contDes = 0;
        while (i < cantidad) {
            nota = 0.0;
            i++;
            do {
                cap.setMensaje("Digite la nota del aprendiz " + i + ": ");
                nota = cap.Capturar();
            } while (nota <= 0 || nota > 100);

            if (nota >= 70) {
                contApr++;
            } else {
                contDes++;
            }
        }

        porApr = (double) (contApr * 100 / cantidad);
        porDes = (double) (contDes * 100 / cantidad);

        System.out.println("De " + cantidad + " aprobo %" + porApr);
        System.out.println("De " + cantidad + " desaprobo %" + porDes);
    }
}
