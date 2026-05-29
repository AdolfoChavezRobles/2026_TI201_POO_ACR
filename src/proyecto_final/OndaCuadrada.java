package proyecto_final;

public class OndaCuadrada extends SerieMatematica {
    public OndaCuadrada(){
        super("Onda Cuadrada");
    }

    @Override
    public double calcular(double t, int terminos){
        double suma = 0;
        for (int i = 0; i < terminos; i++) {
            int n = 2 * i + 1; 
            suma += (1.0 / n) * Math.sin(n * Math.PI * t);
        }
        return (4.0 / Math.PI) * suma;
    }
}