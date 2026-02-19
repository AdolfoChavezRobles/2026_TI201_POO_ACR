/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJECUTAR_B {
    
     public static void main(String[] args) {

        // Crear una instancia de la panadería
        EJ_B panaderia = new EJ_B("GUADALUPE", 10);

         
        panaderia.venderPan(50);
        panaderia.venderPan(20);

        
        System.out.println(panaderia.toString());
    }
    
}
