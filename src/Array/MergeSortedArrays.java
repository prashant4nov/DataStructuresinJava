package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class MergeSortedArrays {
    static int moveElements(int[] a) {
        int size = a.length;
        int i = size-1;
        int j = size-1;
        while(i>=0) {
            if(a[i]!=-1) {
                a[j] = a[i];
                j--;
            }
            i--;
        }
        return ++j;
    }
    static void mergeSortedArray(int[] a, int[] b) {
        int i = moveElements(a);
        int j = 0;
        int k = 0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]) {
                a[k++] = a[i++];
            } else {
                a[k++] = b[j++];
            }
        }
        while(i<a.length) {
            a[k++] = a[i++];
        }
        while(j<b.length){
            a[k++] = b[j++];
        }
    }
    public static void main(String[] args) {
        int[] a = {2,-1,7,-1,-1,10,-1};
        int[] b = {5,8,12,14};
        mergeSortedArray(a,b);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}
