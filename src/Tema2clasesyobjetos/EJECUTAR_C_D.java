/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJECUTAR_C_D {
    
   
    public static void main(String[] args) {

        
        EJ_C c = new EJ_C(
            "Laptop", 15000, 5, "TiendaTech"
        );

        c.mostrarInfo();
          
        c.ejecutar();
        
        System.out.println("--------------------------");
        
    
              EJ_D carrito = new EJ_D("001", "Laptop");

        System.out.println(carrito);

        carrito.setProductos("Laptop, Mouse");

        System.out.println(carrito.getProductos());
      
       
    }
}


