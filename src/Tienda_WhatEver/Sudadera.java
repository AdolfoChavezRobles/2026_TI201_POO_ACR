package Tienda_WhatEver;

public class Sudadera {

    private String nombre;
    private double precio;
    private int stock;
    private int ventas;

    public Sudadera(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.ventas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public void vender() {
        if (stock > 0) {
            stock--;
            ventas++;
        }
    }

    public void mostrar() {
        System.out.println(nombre + " - $" + precio + " - Stock: " + stock);
    }
}
