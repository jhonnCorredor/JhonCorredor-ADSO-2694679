
package View;

import Class.ej1.ClassRuta;


public class Mostrar {
    public static void main(String[]args){
        ClassRuta objt1=new ClassRuta();
        objt1.setT_lunes(20.1);
        objt1.setT_miercoles(15.4);
        objt1.setT_viernes(8.7);
        System.out.println(objt1.Mostrar());
    }
}
