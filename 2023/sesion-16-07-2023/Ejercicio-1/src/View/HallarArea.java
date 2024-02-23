package View;

import Class.Area.Circuferencia;
import Class.Area.Cuadrado;
import Class.Area.Rectangulo;
import Class.Area.Rombo;
import Class.Area.Trapecio;
import Class.Area.Triangulo;
import Class.CapturaNumero;

public class HallarArea {

    public static void main(String[] args) {

        int opcion = 0;
        CapturaNumero x = new CapturaNumero();
        do {
            System.out.println("Hallar area de:");
            System.out.println("1- Triangulo.");
            System.out.println("2- Rectangulo.");
            System.out.println("3- Circuferencia.");
            System.out.println("4- Trapecio.");
            System.out.println("5- Rombo.");
            System.out.println("6- Cuadrado.");
            System.out.println("7- Terminar programa.");
            x.setMensaje("Ingrese una opcion.");
            opcion = (int) x.Capturar();
            switch (opcion) {
                case 1:
                    Triangulo triangulo = new Triangulo();
                    x.setMensaje("Ingrese la altura en metros del triangulo:");
                    triangulo.setAltura(x.Capturar());
                    x.setMensaje("Ingrese la base en metros del triangulo:");
                    triangulo.setBase(x.Capturar());
                    System.out.println("Area del triangulo: "+triangulo.AreaFigura()+" metros cuadrados.");
                    break;
                case 2:
                    Rectangulo rectangulo = new Rectangulo();
                    x.setMensaje("Ingrese la altura en metros del rectangulo:");
                    rectangulo.setAltura(x.Capturar());
                    x.setMensaje("Ingrese la base en metros del rectangulo:");
                    rectangulo.setBase(x.Capturar());
                    System.out.println("Area del rectangulo: "+rectangulo.AreaFigura()+" metros cuadrados.");
                    break;
                case 3:
                    Circuferencia circuferencia = new Circuferencia();
                    x.setMensaje("Ingrese el radio en metros de la circuferencia:");
                    circuferencia.setRadio(x.Capturar());
                    System.out.println("Area de la circuferencia: "+circuferencia.AreaFigura()+" metros cuadrados");
                    break;
                case 4:
                    Trapecio trapecio = new Trapecio();
                    x.setMensaje("Ingrese la base 1 en metros del trapecio:");
                    trapecio.setBase1(x.Capturar());
                    x.setMensaje("Ingrese la base 2 en metros del trapecio:");
                    trapecio.setBase2(x.Capturar());
                    x.setMensaje("Ingrese la altura en metros del trapecio:");
                    trapecio.setAltura(x.Capturar());
                    System.out.println("Area del trapecio: "+trapecio.AreaFigura()+" metros cuadrados.");
                    break;
                case 5:
                    Rombo rombo = new Rombo();
                    x.setMensaje("Ingrese la diagonal mayor en metros del rombo:");
                    rombo.setDglmayor(x.Capturar());
                    x.setMensaje("Ingrese la diagonal menor en metros del rombo:");
                    rombo.setDglmenor(x.Capturar());
                    System.out.println("Area del rombo: "+rombo.AreaFigura()+" metros cuadrados.");
                    break;
                case 6:
                    Cuadrado cuadrado = new Cuadrado();
                    x.setMensaje("Ingrese la base en metros del cuadrado.");
                    cuadrado.setBase(x.Capturar());
                    System.out.println("Area del cuadrado: "+cuadrado.AreaFigura()+" metros cuadrados.");
                    break;
                case 7:
                    System.out.println("Programa terminado.");
                default:
                    System.out.println("Opcion no valida.");
                    System.out.println("Programa terminado.");
            }
        } while (opcion < 7);
    }
}
