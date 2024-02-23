
package Utils;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class FunctionString {
    
    private String data;

    private String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }

    public void ShowScanner(String mensaje) {
        System.out.print(mensaje);
    }

    public String InputScanner(String mensaje) {
        Scanner scanner = new Scanner(System.in);

        ShowScanner(mensaje);
        this.setData(scanner.next());
        return this.getData();
    }

    public void ShowJOptionPane(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String InputJOptionPane(String mensaje) {
        this.setData(JOptionPane.showInputDialog(null, mensaje));
        return this.getData();
    }
    
    public String InputScannerRange(String mensaje, String opcion1, String opcion2) {
        do {            
            InputScanner(mensaje);
        } while (this.getData() == opcion1 || this.getData()== opcion2);
        
        return this.getData();
    }
    
    public String InputJoptionRange(String mensaje, String opcion1, String opcion2) {
        do {            
            InputJOptionPane(mensaje);
        } while (this.getData() == opcion1 || this.getData()== opcion2);
        
        return this.getData();
    }
}
