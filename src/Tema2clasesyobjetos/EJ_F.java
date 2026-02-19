/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOS_POO;

/**
 *
 * @author mateo
 */
public class EJ_F {
    
  

    private String nombreAlumno;
    private String numeroControl;
    private String carrera;
    private String semestre;
    private int materiasInscritas;

    // Constructor
    public EJ_F (String nombreAlumno, String numeroControl, String carrera, String semestre, int materiasInscritas) {
        this.nombreAlumno = nombreAlumno;
        this.numeroControl = numeroControl;
        this.carrera = carrera;
        this.semestre = semestre;
        this.materiasInscritas = materiasInscritas;
    }

    

    // Getters y Setters
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getMateriasInscritas() {
        return materiasInscritas;
    }

    public void setMateriasInscritas(int materiasInscritas) {
        this.materiasInscritas = materiasInscritas;
    }

    // Método para mostrar datos
    public void mostrarCarga() {
        System.out.println("Alumno: " + nombreAlumno);
        System.out.println("No. Control: " + numeroControl);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
        System.out.println("Materias inscritas: " + materiasInscritas);
    }

    

    
}

    

