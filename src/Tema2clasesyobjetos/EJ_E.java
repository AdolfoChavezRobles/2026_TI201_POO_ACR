/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJ_E {
    
    private String idRegistro;
    private String nombreEstudiante;
    private String nombreAsignatura;
    private int creditos;

    public EJ_E(String idRegistro, String nombreEstudiante, String nombreAsignatura, int creditos) {
        this.idRegistro = idRegistro;
        this.nombreEstudiante = nombreEstudiante;
        this.nombreAsignatura = nombreAsignatura;
        this.creditos = creditos;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Registo_Asiganatura{" + "idRegistro=" + idRegistro + 
                ", nombreEstudiante=" + nombreEstudiante + ", nombreAsignatura=" + 
                nombreAsignatura + ", creditos=" + creditos + '}';
    }

   //metodo para mostrarr
    public void mostrarRegistro() {
        System.out.println("ID Registro: " + idRegistro);
        System.out.println("Alumno: " + nombreEstudiante);
        System.out.println("Asignatura: " + nombreAsignatura);
        System.out.println("Créditos: " + creditos);
    }
}
