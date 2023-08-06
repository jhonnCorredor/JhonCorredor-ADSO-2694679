package View;

import Grados.Logica;
import Utils.FunctionNumeric;
import Utils.FunctionString;

public class Mostrar {

    public static void main(String[] args) {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        Logica l = new Logica();
        l.setCelcius(fn.InputNumericJOptionPane("Ingrese grados Celsius."));
        fs.ShowJOptionPane("De Celsius a Fahrenheit: " + String.valueOf(l.CelciusFareheint()));
        l.setCelcius(fn.InputNumericJOptionPane("Ingrese grados Celsius."));
        fs.ShowJOptionPane("De Celsius a Kelvin: " + String.valueOf(l.CelciusKelvin()));
        l.setFareheint(fn.InputNumericJOptionPane("Ingrese grados Fahrenheit."));
        fs.ShowJOptionPane("De Fahrenheit a Celsius: " + String.valueOf(l.FareheintCelcius()));
        l.setFareheint(fn.InputNumericJOptionPane("Ingrese grados Fahrenheit."));
        fs.ShowJOptionPane("De Fahrenheit a kelvin: " + String.valueOf(l.FareheintKelvin()));
        l.setKelvin(fn.InputNumericJOptionPane("Ingrese grados Kelvin."));
        fs.ShowJOptionPane("De kelvin a Fahrenheit: " + String.valueOf(l.KelvinFareheint()));
        l.setKelvin(fn.InputNumericJOptionPane("Ingrese grados Kelvin."));
        fs.ShowJOptionPane("De kelvin a Celsius: " + String.valueOf(l.KlevinCelcius()));

    }
}
