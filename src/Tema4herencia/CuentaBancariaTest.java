
package Tema4herencia;

public class CuentaBancariaTest {
    public static void main(String[] args) {
        final int Numero_De_Cuentas = 10;
        
        CuentaHabiente[] cuentas = new CuentaHabiente[Numero_De_Cuentas];
        
        cuentas[0] = new CuentaHabienteBasico("zero",100_000);
        cuentas[1] = new CuentaHabienteBasico("one",100_000);
        cuentas[2] = new CuentaHabienteBasico("two",100_000);
        cuentas[3] = new CuentaHabienteNomina("three",100_000);
        cuentas[4] = new CuentaHabienteNomina("four",100_000);
        cuentas[5] = new CuentaHabienteNomina("five",100_000);
        
        for (int i = 0; i<=5; i++)
            System.out.println(cuentas[i]);
        
        cuentas[0].depositar(1000000000);
        System.out.println(cuentas[0]);
    }
}
