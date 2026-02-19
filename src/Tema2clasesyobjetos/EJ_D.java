/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJ_D {
    

    private String idCarrito;
    private String productos;

    public EJ_D() {
        this.idCarrito = "";
        this.productos = "";
    }

    public EJ_D(String idCarrito, String productos) {
        this.idCarrito = idCarrito;
        this.productos = productos;
    }

    public String getIdCarrito() {
        return idCarrito;
    }

    public String getProductos() {
        return productos;
    }

    public void setIdCarrito(String idCarrito) {
        this.idCarrito = idCarrito;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Carrito { IdCarrito=" + idCarrito + ", Productos=" + productos + " }";
    }
}
    

