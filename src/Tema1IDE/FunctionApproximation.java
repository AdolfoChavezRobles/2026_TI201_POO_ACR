/*
 *  2026 ITESS-TICS
 *  Periodo: Enero-Junio
 *  Asignatura: Programacion Orientada a Objetos
 *  Docente: Francisco Javier Montecillo Puente
 *  Descripcion: Tema 1. Entorno de desarrollo
 *               Funcion de aproximacion
 *  Programador: ACR
 *  Fecha: 10 Fecrero 2026
 */

package Tema1IDE;


public class FunctionApproximation {
    

   private double xIni;
    private double xEnd;
    private int n;
    private double dx;
    private double[] x;
    private double[] fx;
    private double area;

    public FunctionApproximation(double xIni, double xEnd, int n) {
        this.xIni = xIni;
        this.xEnd = xEnd;
        this.n = n;
        this.dx = (xEnd - xIni) / n;

        x = new double[n + 1];
        fx = new double[n + 1];
        area = 0;
    }

    private double f(double x) {
        return x * x; 
    }

    public void compute() {

        for (int i = 0; i <= n; i++) {
            x[i] = xIni + i * dx;
            fx[i] = f(x[i]);
        }

        for (int i = 0; i < n; i++) {
            area += fx[i] * dx;
        }
    }

    public double getArea() {
        return area;
    }

    public void print() {
        System.out.println("x\tf(x)");
        for (int i = 0; i <= n; i++) {
            System.out.println(x[i] + "\t" + fx[i]);
        }
        System.out.println("Area aproximada: " + area);
    }
}
