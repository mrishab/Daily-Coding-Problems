import java.util.Random;

/***
 * This problem was asked by Google.
 *
 * The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
 *
 * Hint: The basic equation of a circle is x^2 + y^2 = r^2.
 */
public class Problem14 {

    static final int RADIUS = 1;

    public static void main(String[] args) {
        System.out.println(estimatePi());
    }

    static double estimatePi() {
        int area = estimateArea(1000000);
        double pi = Math.pow(RADIUS, 2) / area; // because Area = pi * r^2
        return pi;
    }


    static  int estimateArea (int n) {
        double r2 = Math.pow(RADIUS, 2);
        Random random = new Random();
        int area = 0;

        for (int i = 0; i < n; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            // x2 + y2 <= r2
            if ((Math.pow(x, 2) + Math.pow(y, 2)) <= r2) {
                area++;
            }
        }
        return area * 4;
    }
}
