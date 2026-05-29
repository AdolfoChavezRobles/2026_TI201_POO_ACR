package Tema4herencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorArchivos {
    private static final String DB_FILE = "MiBanco.db";
    private static final String LOG_FILE = "MiBanco.log";

    // 3.e Guardar las cuentas al salir del sistema
    public static void guardarCuentas(List<CuentaHabiente> cuentas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DB_FILE))) {
            for (CuentaHabiente cuenta : cuentas) {
                // Guardamos en formato CSV: Tipo,Numero,Saldo
                writer.println(cuenta.getTipoDeCuenta().trim() + "," + 
                               cuenta.getNumeroDeCuenta() + "," + 
                               cuenta.getSaldo());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar en " + DB_FILE + ": " + e.getMessage());
        }
    }

    // 3.c Cargar y reconstruir las cuentas al iniciar
    public static List<CuentaHabiente> cargarCuentas() {
        List<CuentaHabiente> cuentas = new ArrayList<>();
        File archivo = new File(DB_FILE);
        
        if (!archivo.exists()) {
            return cuentas; // Si no existe, regresa la lista vacía
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String tipo = datos[0];
                    String numero = datos[1];
                    double saldo = Double.parseDouble(datos[2]);

                    // POLIMORFISMO: Reconstruimos el objeto según su tipo
                    if (tipo.equalsIgnoreCase("Basico")) {
                        cuentas.add(new CuentaHabienteBasico(numero, saldo));
                    } else if (tipo.equalsIgnoreCase("Nomina")) {
                        cuentas.add(new CuentaHabienteNomina(numero, saldo));
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar " + DB_FILE + ": " + e.getMessage());
        }
        return cuentas;
    }

    // 3.d Guardar cada acción/transacción en el archivo log
    public static void registrarTransaccion(String numeroCuenta, String accion, double monto, double saldoResultante) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) { // 'true' para modo append
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaFormateada = ahora.format(formateador);

            writer.println("[" + fechaFormateada + "] Cuenta: " + numeroCuenta + 
                           " | Acción: " + accion + " | Monto: $" + monto + 
                           " | Saldo Final: $" + saldoResultante);
        } catch (IOException e) {
            System.err.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}
