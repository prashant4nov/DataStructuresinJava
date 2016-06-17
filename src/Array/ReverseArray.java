package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class ReverseArray {
    static void reverseArray(int[] a, int start, int end) {
        int tmp=0;
        while(start<end) {
            tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        reverseArray(arr,0, args.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
