package Tema3Metodos;

import java.util.Objects;

public class PerritoItess {
    
    private String nombre;
    private String color;
    private String descripcion;
    private String genero;
    private int edad;

    public PerritoItess() {
        this("", "", "", "", 0);
    }

    public PerritoItess(String nombre, String color, String descripcion, String genero, int edad) {
        this.nombre = nombre;
        this.color = color;
        this.descripcion = descripcion;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void ladrar(){
        System.out.println("Guau");
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", color=" + color + ", descripcion=" + descripcion + ", genero=" + genero + ", edad=" + edad;
    }
    
    
}
