package Tema4herencia;

public abstract class CuentaHabiente implements CuentaBancaria {
    protected String numeroDeCuenta;
    protected String tipoDeCuenta;
    protected double saldo;
    
    public CuentaHabiente(String numeroDeCuenta, double saldo) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldo;
    }
    
    public boolean depositar(double deposito) {
        if (deposito > 0) {
            this.saldo += deposito;
            return true;
        }
        return false;
    }

    @Override
    public boolean retiro(double retiro) {
        if (retiro > 0 && this.saldo >= retiro) {
            this.saldo -= retiro; 
            return true;
        }
        return false; 
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public String getNumeroDeCuenta() {
        return this.numeroDeCuenta;
    }
    
    @Override
    public String getTipoDeCuenta() {
        return this.tipoDeCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta [" + tipoDeCuenta + "] No: " + numeroDeCuenta + " | Saldo: $" + saldo;
    }
}