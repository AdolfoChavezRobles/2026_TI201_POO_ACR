package proyecto_final;

public class SerieLogaritmica extends SerieTaylor {
    public SerieLogaritmica(){
        super("ln(1+x) (Maclaurin)");
    }
    
    @Override
    public double calcular(double x, int terminos){
        if (x <= -1 || x > 1) { 
            System.out.println("Fuera del radio de convergencia (-1, 1]");
        }
        double suma = 0;
        for (int n = 1; n <= terminos; n++) {
            suma += Math.pow(-1, n + 1) * Math.pow(x, n) / n;
        }
        return suma;
    }
}