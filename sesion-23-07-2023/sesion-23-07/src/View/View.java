
package View;

import Class.MyClass;
import java.util.Scanner;


public class View {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        Double num1,num2;
        System.out.println("Ingrese dos numeros.");
        MyClass a=new MyClass(num1=scan.nextDouble(),num2=scan.nextDouble());
        a.Suma();
        a.Resta();
        a.Multiplicacion();
        a.Division();
        
    }
}
