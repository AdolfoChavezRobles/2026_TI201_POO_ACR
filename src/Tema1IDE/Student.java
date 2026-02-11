/*
 *  2026 ITESS-TICS
 *  Periodo: Enero-Junio
 *  Asignatura: Programacion Orientada a Objetos
 *  Docente: Francisco Javier Montecillo Puente
 *  Descripcion: Tema 1. Entorno de desarrollo
 *               1.2 Proceso de desarrollo de aplicacion
 *  Programador: ACR
 *  Fecha: 09 Fecrero 2026
 */

package Tema1IDE;

public class Student {
    
    public Student(){
        this.controlNumber = "";
        this.career = "";
        this.gander =  "";
        this.name = "";
    }
    
    private String controlNumber;
    private String name;
    private String career;
    private String gander;

    public Student(String controlNumber, String name, String career, String gander) {
        this.controlNumber = controlNumber;
        this.name = name;
        this.career = career;
        this.gander = gander;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public String getName() {
        return name;
    }

    public String getCareer() {
        return career;
    }

    public String getGander() {
        return gander;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    @Override
    public String toString() {
        return "Student{" + "controlNumber=" + controlNumber + ", name=" + name + ", career=" + career + ", gander=" + gander + '}';
    }


    
}
