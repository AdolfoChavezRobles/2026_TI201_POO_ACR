package proyecto_final;

public class SerieExponencial extends SerieTaylor {
    public SerieExponencial(){
        super("e^x (Taylor)");
    }
    
    @Override
    public double calcular(double x, int terminos){
        double suma = 0;
        for (int n = 0; n < terminos; n++) {
            suma += Math.pow(x, n) / factorial(n);
        }
        return suma;
    }
}