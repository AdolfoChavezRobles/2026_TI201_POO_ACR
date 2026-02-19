/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJECUTAR_E_F {
     
    public static void main(String[] args) {
    
        EJ_E registro = new EJ_E(
            "R001",
            "Mateo",
            "Programacion",
            5
        );
        
        

        EJ_F alumno = new EJ_F(
            "Mateo",
            "TI25110409",
            "TICS",
            "2",
            6
        );

        // Mostrar registro 
        registro.mostrarRegistro();

        System.out.println("------------------");

        // Mostrar datos del alumno
        alumno.mostrarCarga();
    }
}

