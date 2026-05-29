package proyecto_final;

public abstract class SerieTaylor extends SerieMatematica {
    public SerieTaylor(String nombre){
        super(nombre);
    }
    
    protected double factorial(int n){
        if (n <= 1) return 1;
        double fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}