package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class MaxSum {
    static int maxSum(int[] a) {
        int res = -1;
        int icl = a[0];
        int exl = 0;
        for(int i=1;i<a.length;i++) {
            int tmp = Math.max(icl,exl);
            icl = a[i]+exl;
            exl = tmp;
        }
        res = Math.max(exl, icl);
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {5,  5, 10, 40, 50, 35};
        System.out.print(maxSum(arr)+" ");
    }
}
