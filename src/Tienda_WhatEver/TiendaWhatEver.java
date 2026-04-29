package Tienda_WhatEver;

public class TiendaWhatEver {

    FastReader fr = new FastReader();

    Camisa[] camisas;
    Sudadera[] sudaderas;

    int numCamisas = 0;
    int numSudaderas = 0;

    final int MAX = 10;

    public TiendaWhatEver() {
        camisas = new Camisa[MAX];
        sudaderas = new Sudadera[MAX];
    }

    public void app() {
        char op;
        do {
            op = menu();

            switch (op) {
                case 'a':
                    verCamisas();
                    break;
                case 'b':
                    verSudaderas();
                    break;
                case 'c':
                    agregarCamisa();
                    break;
                case 'd':
                    agregarSudadera();
                    break;
                case 'e':
                    comprarCamisa();
                    break;
                case 'f':
                    comprarSudadera();
                    break;
                case 'g':
                    reporteStock();
                    break;
                case 'h':
                    reporteVentas();
                    break;
                case 'x':
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (op != 'x');
    }

    public char menu() {
        System.out.println("\n--- TIENDA WHAT EVER ---");
        System.out.println("a) Ver camisas");
        System.out.println("b) Ver sudaderas");
        System.out.println("c) Agregar camisa");
        System.out.println("d) Agregar sudadera");
        System.out.println("e) Comprar camisa");
        System.out.println("f) Comprar sudadera");
        System.out.println("g) Reporte stock");
        System.out.println("h) Reporte ventas");
        System.out.println("x) Salir");
        return fr.next().charAt(0);
    }

    public void agregarCamisa() {
        if (numCamisas < MAX) {
            System.out.print("Nombre: ");
            String nombre = fr.next();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(fr.next());

            System.out.print("Stock: ");
            int stock = Integer.parseInt(fr.next());

            camisas[numCamisas++] = new Camisa(nombre, precio, stock);
        }
    }

    public void agregarSudadera() {
        if (numSudaderas < MAX) {
            System.out.print("Nombre: ");
            String nombre = fr.next();


            System.out.print("Precio: ");
            double precio = Double.parseDouble(fr.next());

            System.out.print("Stock: ");
            int stock = Integer.parseInt(fr.next());

            sudaderas[numSudaderas++] = new Sudadera(nombre, precio, stock);
        }
    }

    public void verCamisas() {
        for (int i = 0; i < numCamisas; i++) {
            camisas[i].mostrar();
        }
    }

    public void verSudaderas() {
        for (int i = 0; i < numSudaderas; i++) {
            sudaderas[i].mostrar();
        }
    }

    public void comprarCamisa() {
        verCamisas();
        System.out.print("Selecciona índice: ");
        int i = Integer.parseInt(fr.next());

        if (i >= 0 && i < numCamisas && camisas[i].getStock() > 0) {
            camisas[i].vender();
            System.out.println("Compra exitosa");
        } else {
            System.out.println("No disponible");
        }
    }

    public void comprarSudadera() {
        verSudaderas();
        System.out.print("Selecciona índice: ");
        int i = Integer.parseInt(fr.next());

        if (i >= 0 && i < numSudaderas && sudaderas[i].getStock() > 0) {
            sudaderas[i].vender();
            System.out.println("Compra exitosa");
        } else {
            System.out.println("No disponible");
        }
    }

    public void reporteStock() {
        System.out.println("Camisas:");
        verCamisas();
        System.out.println("Sudaderas:");
        verSudaderas();
    }

    public void reporteVentas() {
        System.out.println("Ventas Camisas:");
        for (int i = 0; i < numCamisas; i++) {

            System.out.println(camisas[i].getNombre() + " vendidas: " + camisas[i].getVentas());
        }

        System.out.println("Ventas Sudaderas:");
        for (int i = 0; i < numSudaderas; i++) {
            System.out.println(camisas[i].getNombre() + " vendidas: " + camisas[i].getVentas());
        }
    }
}
