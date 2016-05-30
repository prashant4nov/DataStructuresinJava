package Mathematical;

/**
 * babylonian method for square root.
 * Created by jp on 5/27/16.
 */
public class SquareRoot {
    static int squareRoot(int n) {
        int x = n;
        int y = 1;
        double e = 0.000001;
        while(x-y>e) {
            x = (x+y)/2;
            y=n/x;
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.print(squareRoot(16));
    }
}
