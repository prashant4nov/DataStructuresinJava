package Array;

/**
 * Created by Prashant on 5/30/16.
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class LargestSumContiguousSubarray {
    static int find(int[] a) {
        int curr = 0;
        int max_sum = 0;
        for(int i=0;i<a.length;i++) {
            curr = Math.max(a[i], curr+a[i]);
            max_sum = Math.max(curr, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.print(find(a)+" ");
    }
}
