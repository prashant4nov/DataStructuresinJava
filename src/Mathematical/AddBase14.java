package Mathematical;

/**
 * http://www.geeksforgeeks.org/write-a-program-to-add-two-numbers-in-base-14/
 * Created by jp on 5/27/16.
 */
public class AddBase14 {

    static String addBase14(char[] a, char[] b) {
        int l1 = a.length;
        int l2 =b.length;
        if(l1!=l2) {
            return null;
        }
        int res;
        char[] result = new char[l1+1];
        int carry = 0;
        for(int i=l1-1;i>=0;i--){
            int nm1 = getNumeralValue(a[i]);
            int nm2 = getNumeralValue(b[i]);

            res = nm1+nm2+carry;
            if(res>=14){
                carry=1;
                res -=14;
            } else {
                carry=0;
            }
            result[i+1]=getNumeral(res);
        }
        if(carry==1) {
            result[0]='1';
            return new String(result);
        } else {
            return new String(result, 1, l1+1);
        }
    }

    static char getNumeral(int n) {
        char r='0';
        if(n>=0&&n<=9){
            r = (char) (n + '0');
        } else if(n>=10&&n<=14) {
            r = (char) (n + 'A' - 10);
        }
        return r;
    }

    static int getNumeralValue(char s) {
        int res=0;
        if (s<='9' && s>='0') {
            res = s - '0';
        } else if (s<='D' && s>='A') {
            res = s - 'A' + 10;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] a = "DC2".toCharArray();
        char[] b ="0A3".toCharArray();
        System.out.print(addBase14(a, b));

    }
}
