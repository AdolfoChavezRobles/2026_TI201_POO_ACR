package Tema4herencia;

public interface CuentaBancaria {
    boolean depositar(double deposito);
    boolean retiro(double retiro);
    double getSaldo();
    String getNumeroDeCuenta();
    String getTipoDeCuenta();
}
