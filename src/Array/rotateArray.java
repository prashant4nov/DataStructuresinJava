package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class RotateArray {

    static void rotateArray(int[] a, int d) {
        ReverseArray.reverseArray(a, 0, d-1);
        ReverseArray.reverseArray(a, d, a.length-1);
        ReverseArray.reverseArray(a, 0, a.length-1);
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotateArray(a,2);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }
}
