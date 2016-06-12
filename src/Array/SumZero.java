package Array;

/**
 * Created by Prashant on 6/12/16.
 */
public class SumZero {
    public static void sumZero(int a[]) {
        if(a.length<2) return;
        mergeSort.mergeSort(a, 0, a.length-1);

        int sum =0, minSum = Integer.MAX_VALUE;
        int l = 0, r = a.length-1;
        int ml=0, mr=0;
        while(l<r) {
            sum = a[l]+a[r];
            if(Math.abs(sum)<Math.abs(minSum)) {
                minSum = sum;
                ml = l;
                mr = r;
            }
            if(sum<0) l++;
            else r--;
        }

        System.out.print(a[ml] + " " + a[mr]);
    }
    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85};
        sumZero(arr);
        System.out.print(" ");
    }
}
