package Entity;

import Utils.FunctionNumeric;
import Utils.FunctionString;

public class Cliente {

    FunctionNumeric fn = new FunctionNumeric();
    FunctionString fs = new FunctionString();
    private String nombre;
    private String tipoCuenta;
    private Double saldo;
    Banco banco;

    public Cliente(String nombre, Boolean tipoCuenta, Double saldo, Banco banco) {
        this.nombre = nombre;
        if (tipoCuenta) {
            this.tipoCuenta = "credito";
        } else {
            this.tipoCuenta = "debito";
        }
        this.saldo = saldo;
        this.banco = banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String isTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void retirar(Double retiro) {
        if (this.saldo < retiro) {
            fs.ShowScanner("Saldo insuficiente. \n"
                    + "saldo actual: " + this.saldo);
        } else {
            if (this.tipoCuenta == "credito" && retiro > 50000.0) {
                fs.ShowScanner("Retiro maximo de cuenta diario es 50000.\n");
            } else if (this.tipoCuenta == "debito" && retiro > 10000.0) {
                fs.ShowScanner("Retiro maximo de cuenta diario es 10000.\n");
            } else {
                setSaldo(getSaldo()-retiro);
                fs.ShowScanner("Retiro exitoso:\n"
                        + "Saldo: " + this.saldo
                        + "\n Retiro: " + retiro + "\n");
            }
        }
    }
}
