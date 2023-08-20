package Entity;

import Utils.FunctionNumeric;
import Utils.FunctionString;
import java.util.ArrayList;
import java.util.Date;

public class Metodos {

    FunctionNumeric fn = new FunctionNumeric();
    FunctionString fs = new FunctionString();
    ArrayList<Banco> bancos = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Historial> historiales = new ArrayList<>();

    public void Menu() {
        int seleccion;
        int bandera = 0;
        do {
            do {
                fs.ShowScanner(
                        "1.REGISTRASE" + "\n"
                        + "2.CONSULTAR SALDO " + "\n"
                        + "3.RETIRO DE EFECTIVO" + "\n"
                        + "4.CONSULTAR HISTORAIL" + "\n"
                        + "5.SALIR" + "\n"
                );

                seleccion = fn.InputNumericIntRangeScanner("PORFAVOR SELECCIONE UNA OPCION: ", 1.0, 5.0);

                if (seleccion >= 1 && seleccion <= 5) {
                    bandera = 1;
                }
            } while (bandera != 1);
            switch (seleccion) {
                case 1:
                    Registrarse();
                    break;
                case 2:
                    ConsultaSaldo();
                    break;
                case 3:
                    Retiro();
                    break;
                case 4:
                    ConsultaHistorial();
                    break;
                case 5:
                    fs.ShowScanner("Programa finalizado \n");
                    bandera = 2;
            }
        } while (bandera != 2);
    }

    public void Registrarse() {
        int seleccion;
        String bancoS;
        fs.ShowScanner("1- Registrar Banco \n"
                + "2- Registra cliente \n");
        seleccion = fn.InputNumericIntRangeScanner("Seleccione una opcion: ", 1.0, 2.0);
        switch (seleccion) {
            case 1:
                bancoS = fs.InputScanner("Ingrese nombre del banco: ");
                Banco banco = new Banco(bancoS);
                bancos.add(banco);
                break;
            case 2:
                String nombre;
                if (bancos.size() != 0) {
                    nombre = fs.InputScanner("Ingrese nombre: ");
                    boolean cuenta;
                    fs.ShowScanner("Tipo de cuenta:\n"
                            +"1- Credito. \n"
                            + "2- Debito. \n");
                    seleccion = fn.InputNumericIntRangeScanner("Selecciones una opcion: ", 1.0, 2.0);
                    if (seleccion == 1) {
                        cuenta = true;
                    } else {
                        cuenta = false;
                    }
                    Double saldo;
                    saldo = fn.InputNumericPositiveScanner("Ingrese el saldo de la cuenta:");

                    for (int i = 0; i < bancos.size(); i++) {
                        fs.ShowScanner((1 + i) + ". " + bancos.get(i).getNombreBanco() + "\n");
                    }
                    int a = fn.InputNumericIntRangeScanner("Seleccione su banco: ", 1.0, Double.parseDouble("" + bancos.size()));
                    Banco banquito = bancos.get(a - 1);
                    Cliente cliente = new Cliente(nombre, cuenta, saldo, banquito);
                    clientes.add(cliente);
                } else {
                    fs.ShowScanner("No hay bancos registrados.\n"
                            + "Registre el banco.\n");
                }

                break;
        }
    }

    public int ListaCliente() {
        for (int i = 0; i < clientes.size(); i++) {
            fs.ShowScanner((1 + i) + ". " + clientes.get(i).getNombre() + "\n");
        }
        int a = fn.InputNumericIntRangeScanner("Seleccione el cliente: ", 1.0, Double.parseDouble("" + clientes.size()));
        return a - 1;
    }

    public void ConsultaSaldo() {
        if (clientes.size() != 0) {
            int index = ListaCliente();
            fs.ShowScanner("Saldo= " + clientes.get(index).getSaldo() + "\n");
        } else {
            fs.ShowScanner("No hay cliente registrado.\n");
        }
    }

    public void Retiro() {
        if (clientes.size() != 0) {
            int index = ListaCliente();
            Double retiro = fn.InputNumericPositiveScanner("Ingrese cantidad a retirar: ");
            clientes.get(index).retirar(retiro);
            Date fecha = new Date();
            Historial historial = new Historial(fecha, clientes.get(index), clientes.get(index).getBanco(), retiro);
            historiales.add(historial);
        } else {
            fs.ShowScanner("No hay cliente registrado.\n");
        }
    }

    public void ConsultaHistorial() {
        if (historiales.size() != 0) {
            for (int i = 0; i < historiales.size(); i++) {
                fs.ShowScanner("Fecha: " + historiales.get(i).getFecha() + "\n"
                        + "Cliente: " + historiales.get(i).getCliente().getNombre() + "\n"
                        + "Banco: " + historiales.get(i).getBanco().getNombreBanco() + "\n"
                        + "Retiro: " + historiales.get(i).getSaldo() + "\n");
            }
        } else {
            fs.ShowScanner("No hay historial de retiros.\n");
        }
    }
}
