package Mathematical;

/**
 * http://www.geeksforgeeks.org/print-0-and-1-with-50-probability/
 * probability of 0 is 0.6 and of 1 is 0.4
 * how to make the coin fair.
 * Created by jp on 5/28/16.
 */
public class FairCoin {
    static int foo() {
        return 1;
    }
    static int fairCoin() {
        int val1 = foo();
        int val2 = foo();
        // just for testing
        val1 = 0;
        val2 = 1;
        if(val1==0&&val2==1) return 0;
        if(val1==1&&val2==0) return 1;
        return fairCoin();
    }
    public static void main(String[] args) {
        System.out.print(fairCoin());
    }
}
