package View;

import Class.Ejercicio1;
import Class.Ejercicio10;
import Class.Ejercicio2;
import Class.Ejercicio3;
import Class.Ejercicio4;
import Class.Ejercicio5;
import Class.Ejercicio6;
import Class.Ejercicio7;
import Class.Ejercicio8;
import Class.Ejercicio9;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {

        Ejercicio1 ej1 = new Ejercicio1();
        Ejercicio2 ej2 = new Ejercicio2();
        Ejercicio3 ej3 = new Ejercicio3();
        Ejercicio4 ej4 = new Ejercicio4();
        Ejercicio5 ej5 = new Ejercicio5();
        Ejercicio6 ej6 = new Ejercicio6();
        Ejercicio8 ej8 = new Ejercicio8();
        Ejercicio7 ej7 = new Ejercicio7();
        Ejercicio9 ej9 = new Ejercicio9();
        Ejercicio10 ej10 = new Ejercicio10();
        Scanner scan = new Scanner(System.in);
        int a;

        System.out.println("Elige una opcion:\n"
                + 
                "1.Desarrollar ejercicio 1. \n"
                + 
                "2.Desarrollar ejercicio 2. \n"
                + 
                "3.Desarrollar ejercicio 3. \n"
                + 
                "4.Desarrollar ejercicio 4. \n"
                + 
                "5.Desarrollar ejercicio 5. \n"
                + 
                "6.Desarrollar ejercicio 6. \n"
                + 
                "7.Desarrollar ejercicio 7. \n"
                + 
                "8.Desarrollar ejercicio 8.\n"
                + 
                "9.Desarrollar ejercicio 9. \n"
                + 
                "10.Desarrollar ejercicio 10.");
        a=scan.nextInt();
        switch(a){
            case 1:
        System.out.println("-Ejercicio 1: Leer un real e imprimir si el número es mayor a 5.");
        ej1.Lectura();
        ej1.Logica();
        break;
            case 2:
        System.out.println("-Ejercicio 2: Leer un real e imprimir si su cuadrado es mayor a 5000.");
        ej2.Lectura();
        ej2.Logica();
        break;
            case 3:
        System.out.println("-Ejercicio 3: Leer un real e imprimir su valor absoluto.");
        ej3.Lectura();
        ej3.Logica();
        break;
            case 4:
        System.out.println("-Ejercicio 4: Leer un real e imprimir si el número es positivo o negativo.");
        ej4.Lectura();
        ej4.Logica();
        break;
            case 5:
        System.out.println("-Ejercicio 5: Leer un real e imprimir si el número es mayor a 200 o no.");
        ej5.Lectura();
        ej5.Logica();
        break;
            case 6:
        System.out.println("-Ejercicio 6: Leer un real e imprimir si el número está en el rango de 50 y 100.");
        ej6.Lectura();
        ej6.Logica();
        break;
            case 7:
        System.out.println("-Ejercicio 7: Leer un real e imprimir si el número es par o impar.");
        ej7.Lectura();
        ej7.Logica();
        break;
            case 8:
        System.out.println("-Ejercicio 8: Leer un entero e imprimir si el números par o impar y si es positivo o no.");
        ej8.Lectura();
        ej8.Logica();
        break;
            case 9:
        System.out.println("-Ejercicio 9: Leer un entero e imprimir si el número está dentro del rango 200-300 y si es asi imprimir si es par o impar.");
        ej9.Lectura();
        ej9.Logica();
        break;
            case 10:
        System.out.println("-Ejercicio 10: Leer dos números e imprimir cuál de los dos números es mayor y cual es menor.");
        ej10.Lectura();
        ej10.Logica();
        break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
}
