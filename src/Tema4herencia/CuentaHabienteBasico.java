package Tema4herencia;

public class CuentaHabienteBasico extends CuentaHabiente {

    public CuentaHabienteBasico(String numeroDeCuenta, double saldo) {
        super(numeroDeCuenta, saldo);
        this.tipoDeCuenta = "Basico";
    }
}