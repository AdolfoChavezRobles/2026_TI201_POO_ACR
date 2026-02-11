
package Tema1IDE;

public class FunctionApproximationTest {
     public static void main(String[] args) {

        FunctionApproximation fa = new FunctionApproximation(0, 5, 10);

        fa.compute();
        fa.print();

        System.out.println("Area obtenida: " + fa.getArea());
    }
}
