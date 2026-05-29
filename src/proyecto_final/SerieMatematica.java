package proyecto_final;

// Contrato base para cualquier serie numérica
public abstract class SerieMatematica {
    protected String nombre;

    public SerieMatematica(String nombre) {
        this.nombre = nombre;
    }

    // Polimorfismo puro: cada hijo decidirá cómo se calcula
    public abstract double calcular(double x, int terminos);

    public String getNombre() { return nombre; }
}