package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class MissingNumber {
    static int findMissing(int[] a) {
        int size = a.length;
        int sum = (size+1)*(size+2)/2;
        for(int i=0;i<a.length;i++) {
            sum = sum - a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 4,6, 3, 7, 8};
        System.out.print(findMissing(a)+" ");
    }
}
