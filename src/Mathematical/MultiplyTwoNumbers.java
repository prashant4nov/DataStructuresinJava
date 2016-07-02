package Mathematical;

/**
 * Multiply two integers without using multiplication, division and bitwise operators, and no loops
 * Created by jp on 5/27/16.
 * http://www.geeksforgeeks.org/multiply-two-numbers-without-using-multiply-division-bitwise-operators-and-no-loops/
 * 
 * this program doesn't handle case when value b=0.
 */
public class MultiplyTwoNumbers {
    static int multiplyTwoNumbersUtil(int a, int b) {
        if (b == 1) return a;
        return a + multiplyTwoNumbersUtil(a, b-1);
    }
    static int multiplyTwoNumbers(int a, int b) {
        if(b<0) b = -b;
        return -multiplyTwoNumbersUtil(a,b);
    }
    public static void main(String[] args) {
        System.out.print(multiplyTwoNumbers(2,-3));
    }
}
