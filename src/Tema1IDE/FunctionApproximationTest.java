
package Tema1IDE;

/**
 *
 * @author Adolfo
 */
public class FunctionApproximationTest {
    public static void main(String[] args) {

        FunctionApproximation fa =
                new FunctionApproximation(0, 5, 100);

        fa.compute();
        fa.printResults();
    }
}
