package Tema3Metodos;

public class Articulo {
    
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantidad;

    public Articulo() {
        this("", "", 0,0);
    }

    public Articulo(String nombre, String descripcion, float precio, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void comprar(){
        
    }

    @Override
    public String toString() {
        return "Articulo{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
    
}
