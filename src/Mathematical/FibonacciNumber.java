package Mathematical;

/**
 * http://www.geeksforgeeks.org/check-number-fibonacci-number/
 * Created by Prashant on 5/30/16.
 */
public class FibonacciNumber {
    static boolean isPerfectSqr(int n) {
        double s = Math.sqrt(n);
        return ((int)s*s == n);
    }
    static boolean isFibonnaci(int n) {
        return (isPerfectSqr(5*n*n+4)||isPerfectSqr(5*n*n-4));
    }
    public static void main(String[] args) {

        System.out.print(isFibonnaci(8)+" ");
        System.out.print(isFibonnaci(9)+" ");
        System.out.print(isFibonnaci(10)+" ");

    }
}
