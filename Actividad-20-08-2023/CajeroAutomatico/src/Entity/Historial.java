
package Entity;

import java.util.Date;


public class Historial {
    private Date fecha;
    private Cliente cliente;
    private Banco banco;
    private Double saldo;

    public Historial(Date fecha, Cliente cliente, Banco banco, Double saldo) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.banco = banco;
        this.saldo = saldo;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
}
