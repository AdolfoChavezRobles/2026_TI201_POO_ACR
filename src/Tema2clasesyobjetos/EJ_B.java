/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJ_B {
    

    private String nombre;
    private double precioPan;
    private int panesVendidos;

    // Constructor
    public EJ_B(String nombre, double precioPan) {
        this.nombre = nombre;
        this.precioPan = precioPan;
        this.panesVendidos = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecioPan() {
        return precioPan;
    }

    public int getPanesVendidos() {
        return panesVendidos;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioPan(double precioPan) {
        this.precioPan = precioPan;
    }

    public void setPanesVendidos(int panesVendidos) {
        this.panesVendidos = panesVendidos;
    }

    // Método para vender pan
    public void venderPan(int cantidad) {
        panesVendidos += cantidad;
    }

    // Método para calcular la ganancia
    public double calcularGanancia() {
        return panesVendidos * precioPan;
    }

    // Override de toString para mostrar la información
    @Override
    public String toString() {
        return "Panaderia: " + nombre +
                "\nPrecio Pan: $" + precioPan +
                "\nPanes vendidos: " + panesVendidos +
                "\nGanancia: $" + calcularGanancia();
    }
}
    

