package Tema4herencia;

public class CuentaHabienteNomina extends CuentaHabiente {

    public CuentaHabienteNomina(String numeroDeCuenta, double saldo) {
        super(numeroDeCuenta, saldo);
        this.tipoDeCuenta = "Nomina";
    }
}