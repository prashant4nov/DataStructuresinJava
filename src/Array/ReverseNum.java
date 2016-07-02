package Array;

/**
 * Created by Prashant on 7/2/16.
 */
public class ReverseNum {
    public int reverseRec(int number, int len) {
        if(number<10) return number;
        int lastDigit = number%10;
        return  (int)(lastDigit*Math.pow(10, len-1))+reverseRec(number/10, len-1);
    }

    public int reverse(int number) {
        int res = 0;
        while(number>0) {
            int lastDigit = number%10;
            res = res*10 + lastDigit;
            number = number/10;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseNum rn = new ReverseNum();
        int number = 12345;
        int n = number;
        int count = 0;
        while(n>0) {
            count++;
            n=n/10;
        }
        System.out.println(rn.reverseRec(number, count));
        System.out.println(rn.reverse(number));
    }
}
