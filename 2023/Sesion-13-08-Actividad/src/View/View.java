
package View;

import Entity.Asignatura;
import Utils.FunctionNumeric;
import Utils.FunctionString;


public class View {
    public static void main(String[]args){
        FunctionNumeric fn=new FunctionNumeric();
        FunctionString fs=new FunctionString();
        Asignatura as=new Asignatura();
        
        as.setCurso(fs.InputScannerRange("Ingrese si el alumno es de preparatoria o profesional.", "preparatoria", "profesional"));
        as.setPromedio(fn.InputDoubleNumericRangeScanner("Ingrese el promedio del alumno:", 0.0, 10.0));
        as.setMateriasReprobadas(fn.InputIntegerNumericPositiveScanner("Ingrese las materias que reprobo el alumno:"));
        fs.ShowScanner(String.valueOf(as.HallarDescuento()));
        fs.ShowScanner(String.valueOf(as.HallarUnidades()));
        fs.ShowScanner("El total de la asignatura es: $"+as.TotalAsignatura());
    }
}
