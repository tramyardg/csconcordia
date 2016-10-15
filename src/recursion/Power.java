package recursion;

public class Power {

    /**
     * Computes the value of x raised to the nth power, for nonnegative integer
     * n.
     */
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }
}
