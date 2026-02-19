/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJECUTAR_A {
    
    public static void main(String[] args) {

        // Crear una instancia de la taquería
        EJ_A taqueria = new EJ_A("TACOS EL INGE", 20);

        // Vender
        taqueria.venderTacos(5);
        taqueria.venderTacos(5);

        // Mostrar 
        System.out.println(taqueria.toString());
    }
    
}
