package Tema3Metodos;

import java.util.Arrays;

public class Torta {
    public static final int MAX_INGREDIENTES = 10;
    private String nombre;
    private String[] ingredientes;
    private int numeroIngredientes;
    private float precio;

    public Torta() {
        ingredientes = new String [MAX_INGREDIENTES];
        numeroIngredientes = 0;
    }

    public Torta(String nombre, String[] ingredientes, float precio) {
        this.nombre = nombre;
        
        // copiar los ingredientes de entrada a mi lista de ingredientes
        this.numeroIngredientes = ingredientes.length;
        this.ingredientes = new String[MAX_INGREDIENTES];
        for (int i = 0; i < numeroIngredientes; i++)
            this.ingredientes[i] = ingredientes[i];
        
        //this.ingredientes = ingredientes; 
        
        this.ingredientes = ingredientes;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Torta{" + "nombre=" + nombre + ", "
                + "ingredientes=" + Arrays.toString(ingredientes) + ", "
                + "numeroIngredientes=" + numeroIngredientes + ", precio=" + precio + '}';
    }
    
    
     
    public void agregarIngrediente(String ingrediente) throws Exception{
        if (numeroIngredientes >= MAX_INGREDIENTES){
            throw new Exception("Maxima cantidad de ingredientes");
        }    
        ingredientes[numeroIngredientes] = ingrediente;
        numeroIngredientes++;
    }
}
