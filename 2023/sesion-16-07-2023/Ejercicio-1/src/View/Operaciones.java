package View;

import Class.Division;
import Class.Modulo;
import Class.Multiplicacion;
import Class.Potencia;
import Class.Raiz;
import Class.Resta;
import Class.Suma;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Operaciones {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i=0, o;
        Double num1,num2=0.0;
        do{
        System.out.println("Selecciones Operacion:");
        System.out.println("1- Suma.");
        System.out.println("2- Resta.");
        System.out.println("3- Multiplicación.");
        System.out.println("4- División.");
        System.out.println("5- Modulo.");
        System.out.println("6- Potencia.");
        System.out.println("7- Raiz.");
        o = scan.nextInt();
        System.out.println("Ingrese numero 1.");
        num1=scan.nextDouble();
        if(o!=7){
        System.out.println("Ingrese numero 2.");
        num2=scan.nextDouble();
        }
        switch (o) {
            case 1:
                Suma suma = new Suma();
                suma.setNum1(num1);
                suma.setNum2(num2);
                System.out.println("La suma es: "+suma.GenrarResultado());
                break;
            case 2:
                Resta resta = new Resta();
                resta.setNum1(num1);
                resta.setNum2(num2);
                System.out.println("La resta es: "+resta.GenrarResultado());
                break;
            case 3:
                Multiplicacion multiplicacion = new Multiplicacion();
                multiplicacion.setNum1(num1);
                multiplicacion.setNum2(num2);
                System.out.println("La multiplicación es: "+multiplicacion.GenrarResultado());
                break;
            case 4:
                Division division = new Division();
                division.setNum1(num1);
                division.setNum2(num2);
                System.out.println("La división es: "+division.GenrarResultado());

                break;
            case 5:
                Modulo modulo = new Modulo();
                modulo.setNum1(num1);
                modulo.setNum2(num2);
                System.out.println("El modulo es: "+modulo.GenrarResultado());
                break;
            case 6:
                Potencia potencia = new Potencia();
                potencia.setNum1(num1);
                potencia.setNum2(num2);
                System.out.println("La potencia es: "+potencia.GenrarResultado());
                break;
            case 7:
                Raiz raiz = new Raiz();
                raiz.setNum1(num1);
                System.out.println("La raiz es: "+raiz.GenrarResultado());
                break;
            default:
                System.out.println("Opcion no valida.");
        }
            System.out.println("1.Terminar programa.");
            System.out.println("2.Continuar programa.");
            i=scan.nextInt();
            if(i!= 1 || i!=2){
                System.out.println("Opcion no valida.");
            }
        }while(i!=1);
    }
}
