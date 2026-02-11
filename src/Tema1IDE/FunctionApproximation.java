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
    private double area;

    public FunctionApproximation(double xIni, double xEnd, int n) {
        this.xIni = xIni;
        this.xEnd = xEnd;
        this.n = n;
        this.dx = (xEnd - xIni) / n;
        this.area = 0;
    }

    public double evaluate(double x) {
        return x * x; // f(x) = x²
    }

    public void compute() {

        for (int i = 0; i < n; i++) {
            double x = xIni + i * dx;
            area += evaluate(x) * dx;
        }
    }

    public double getArea() {
        return area;
    }

    public void printResults() {
        System.out.println("Intervalo: [" + xIni + ", " + xEnd + "]");
        System.out.println("Subintervalos: " + n);
        System.out.println("dx: " + dx);
        System.out.println("Area aproximada: " + area);
    }
}
