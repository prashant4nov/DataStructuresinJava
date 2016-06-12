package Array;

/**
 * Created by Prashant on 6/12/16.
 */
public class MaxDiff {
    public static int maxDiff(int[] a) {
        int maxDiff= a[1] - a[0];
        int min = a[0];
        for(int i=1;i<a.length;i++) {
            int diff = a[i] - min;
            if(diff>maxDiff) {
                maxDiff = diff;
            }
            if (min>a[i]) {
                min = a[i];
            }

            /**
             *
             *
             *  in this case for decreasing order it will give zero max diff.
             * if (min>a[i]) {
                 min = a[i];
               }
               if(diff>maxDiff) {
                maxDiff = diff;
               }
             *
             */

        }
        return maxDiff;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 80, 100};

        System.out.print(maxDiff(arr)+" ");

        int ar[] = {99, 10, 9, 8, 7, 6, 1};

        System.out.print(maxDiff(ar)+" ");
    }
}
