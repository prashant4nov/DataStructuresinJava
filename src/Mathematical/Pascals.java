package Mathematical;

/**
 * Created by Prashant on 5/30/16.
 * http://www.geeksforgeeks.org/pascal-triangle/
 * http://www.geeksforgeeks.org/program-nth-catalan-number/
 * proggram for binomial coefficent is very important and for catalan number
 */
public class Pascals {
    static void pascalsTriangle(int n) {
        for(int line=1;line<=n;line++) {
            int c = 1;
            for(int i=1;i<=line;i++) {
                System.out.print(c + " ");
                c = c*(line-i)/i;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pascalsTriangle(7);
    }
}
