package Mathematical;
// todo do using recurssion
/**
 *
 * Created by jp on 5/27/16.
 */
public class Fibonacci {
    static int fibonacci(int n) {
        int c=0, a=0, b=1;
        for(int i=2;i<=n;i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
    public static void main(String[] args) {
        System.out.print(fibonacci(9));
    }
}
