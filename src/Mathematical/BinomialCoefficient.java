package Mathematical;

/**
 * http://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
 * Created by Prashant on 5/28/16.
 */
public class BinomialCoefficient {
    static float binomialCoefficient(int n, int k) {
        if(k>n-k) {
            k = n-k;
        }
        float res = 1;
        for(int i=0;i<k;i++) {
            res = res * (n-i);
            res = res / (k-i);

        }
        return res;
    }
    public static void main(String[] args) {
        System.out.print(binomialCoefficient(8,2));
    }
}
