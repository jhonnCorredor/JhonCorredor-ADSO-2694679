package Utils;

public class FunctionNumeric {

    private Double numero;
    private int entero;

    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }

    private Double getNumero() {
        return numero;
    }

    private void setNumero(Double numero) {
        this.numero = numero;
    }

    public Double InputNumericScanner(String mensaje) {
        InputNumeric(mensaje, 1);
        return this.getNumero();
    }

    public Double InputNumericJOptionPane(String mensaje) {
        InputNumeric(mensaje, 2);
        return this.getNumero();
    }

    private void InputNumeric(String mensaje, int tipo) {
        Boolean validar = false;
        FunctionString fs = new FunctionString();

        //Validar que se ingrese el dato correcto
        while (validar == false) {
            try {
                if (tipo == 1) {
                    this.setNumero(Double.parseDouble(fs.InputScanner(mensaje)));
                } else {
                    this.setNumero(Double.parseDouble(fs.InputJOptionPane(mensaje)));
                }
                validar = true;
            } catch (Exception e) {
                if (tipo == 1) {
                    fs.ShowScanner("Ha ingresado un dato no válido. ");
                } else {
                    fs.ShowJOptionPane("Ha ingresado un dato no válido. ");
                }
            }
        }
    }

    public Double InputNumericRangeScanner(String mensaje, Double min, Double max) {
        do {
            InputNumeric(mensaje, 1);
        } while (this.getNumero() < min || this.getNumero() > max);

        return this.getNumero();
    }

    public Double InputNumericRangeJOptionPane(String mensaje, Double min, Double max) {
        do {
            InputNumeric(mensaje, 2);
        } while (this.getNumero() < min || this.getNumero() > max);

        return this.getNumero();
    }

    public Double InputNumericPositiveScanner(String mensaje) {
        do {
            InputNumeric(mensaje, 1);
        } while (this.getNumero() < 0);
        return this.getNumero();
    }

    public Double InputNumericPositiveJOptionPane(String mensaje) {
        do {
            InputNumeric(mensaje, 2);
        } while (this.getNumero() < 0);
        return this.getNumero();
    }

    public Double InputNumericNegativeScanner(String mensaje) {
        do {
            InputNumeric(mensaje, 1);
        } while (this.getNumero() >= 0);
        return this.getNumero();
    }

    public Double InputNumericNegativeJOptionPane(String mensaje) {
        do {
            InputNumeric(mensaje, 2);
        } while (this.getNumero() >= 0);
        return this.getNumero();
    }

    private void InputNumericInt(String mensaje, int tipo) {
        Boolean validar = false;
        FunctionString fs = new FunctionString();

        //Validar que se ingrese el dato correcto
        while (validar == false) {
            try {
                if (tipo == 1) {
                    this.setEntero(Integer.parseInt(fs.InputScanner(mensaje)));
                } else {
                    this.setEntero(Integer.parseInt(fs.InputJOptionPane(mensaje)));
                }
                validar = true;
            } catch (Exception e) {
                if (tipo == 1) {
                    fs.ShowScanner("Ha ingresado un dato no válido. ");
                } else {
                    fs.ShowJOptionPane("Ha ingresado un dato no válido. ");
                }
            }
        }
    }

    public int InputNumericIntScanner(String mensaje) {
        InputNumericInt(mensaje, 1);
        return this.getEntero();
    }

    public int InputNumericIntJOptionPane(String mensaje) {
        InputNumericInt(mensaje, 2);
        return this.getEntero();
    }

    public int InputNumericIntRangeScanner(String mensaje, Double min, Double max) {
        do {
            InputNumericInt(mensaje, 1);
        } while (this.getEntero() < min || this.getEntero() > max);

        return this.getEntero();
    }

    public int InputNumericIntRangeJOptionPane(String mensaje, Double min, Double max) {
        do {
            InputNumericInt(mensaje, 2);
        } while (this.getEntero() < min || this.getEntero() > max);

        return this.getEntero();
    }

    public int InputNumericIntPositiveScanner(String mensaje) {
        do {
            InputNumericInt(mensaje, 1);
        } while (this.getEntero() < 0);
        return this.getEntero();
    }

    public int InputNumericIntPositiveJOptionPane(String mensaje) {
        do {
            InputNumericInt(mensaje, 2);
        } while (this.getEntero() < 0);
        return this.getEntero();
    }

    public int InputNumericIntNegativeScanner(String mensaje) {
        do {
            InputNumericInt(mensaje, 1);
        } while (this.getEntero() >= 0);
        return this.getEntero();
    }

    public int InputNumericIntNegativeJOptionPane(String mensaje) {
        do {
            InputNumericInt(mensaje, 2);
        } while (this.getEntero() >= 0);
        return this.getEntero();
    }
}
