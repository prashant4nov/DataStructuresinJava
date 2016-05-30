package Mathematical;

/**
 * http://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
 * Created by Prashant on 5/30/16.
 */
public class primeFactors {
    static void primeFactors(int n) {
        int i = 2;
        while(n%i==0) {
            System.out.print(i + " ");
            n=n/i;
        }

        for(i=3;i<=Math.sqrt(n);i=i+2) {
            while(n%i==0) {
                System.out.print(i + " ");
                n=n/i;
            }
        }

        if(n>2) {
            System.out.print(n);
        }
    }
    public static void main(String[] args) {
        primeFactors(315);
    }
}
