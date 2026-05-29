package proyecto_final;

public class OndaTriangular extends SerieMatematica {
    public OndaTriangular() { 
        super("Onda Triangular (f(t)=t)");
    }
    
    @Override
    public double calcular(double t, int terminos){
        double suma = 0;
        for (int n = 1; n <= terminos; n++) {
            double numerador = 2 * Math.pow(-1, n + 1);
            double denominador = n * Math.PI;
            suma += (numerador / denominador) * Math.sin(n * Math.PI * t);
        }
        return suma;
    }
}