package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class OddOccurring {
    static int oddOccurring(int[] a) {
        int res = 0;
        for(int i=0;i<a.length;i++) {
            res = res ^ a[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 3, 1, 3};
        System.out.print(oddOccurring(a)+" ");
    }
}
