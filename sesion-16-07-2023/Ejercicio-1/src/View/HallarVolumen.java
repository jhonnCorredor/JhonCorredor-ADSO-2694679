
package View;

import Class.CapturaNumero;
import Class.Volumen.Cilindro;
import Class.Volumen.Cono;
import Class.Volumen.Cubo;
import Class.Volumen.Esfera;


public class HallarVolumen {
    public static void main(String[]args){
        int opcion = 0;
        CapturaNumero x = new CapturaNumero();
        do {
            System.out.println("Hallar volumen de:");
            System.out.println("1- Cubo.");
            System.out.println("2- Esfera.");
            System.out.println("3- Cilindro.");
            System.out.println("4- Cono.");
            System.out.println("5- Terminar programa.");
            x.setMensaje("Ingrese una opcion.");
            opcion = (int) x.Capturar();
            switch (opcion) {
                case 1:
                    Cubo cubo=new Cubo();
                    x.setMensaje("Ingrese la altura en metros del cubo:");
                    cubo.setAltura(x.Capturar());
                    x.setMensaje("Ingrese la base en metros del cubo:");
                    cubo.setBase(x.Capturar());
                    x.setMensaje("Ingrese la profundidad en metros del cubo:");
                    cubo.setProfundidad(x.Capturar());
                    System.out.println("Volumen del cubo: "+cubo.HallarVolumen()+" metros cubicos.");
                    break;
                case 2:
                    Esfera esfera=new Esfera();
                    x.setMensaje("Ingrese el radio en metros de la esfera:");
                    esfera.setRadio(x.Capturar());
                    System.out.println("Volumen de la esfera: "+esfera.HallarVolumen()+" metros cubicos.");
                    break;
                case 3:
                    Cilindro cilindro=new Cilindro();
                    x.setMensaje("Ingrese el radio en metros del cilindro:");
                    cilindro.setRadio(x.Capturar());
                    x.setMensaje("Ingrese la altura en metros del cilindro:");
                    cilindro.setAltura(x.Capturar());
                    System.out.println("Volumen del cilindro: "+cilindro.HallarVolumen()+" metros cubicos.");
                    break;
                case 4:
                    Cono cono=new Cono();
                    x.setMensaje("Ingrese el radio en metros del cono:");
                    cono.setRadio(x.Capturar());
                    x.setMensaje("Ingrese la altura en metros del cono:");
                    cono.setAltura(x.Capturar());
                    System.out.println("Volumen del cono: "+cono.HallarVolumen()+" metros cubicos.");
                    break;
                case 5:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    System.out.println("Programa terminado.");
            }
        } while (opcion < 5);
    }
}
