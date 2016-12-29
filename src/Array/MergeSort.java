package Array;

/**
 * Created by Prashant on 6/11/16.
 * merge sort is divide and conquer + combine approach. it's complexity is O(nlgn)
 * java pass by value or reference? : https://www.youtube.com/watch?v=hNR6fsksEu8
 * array pass by value or reference? : http://stackoverflow.com/questions/1610757/pass-array-to-method-java
 */
public class mergeSort {
    public static void mergeSort(int[] a, int l, int r) {
        if(l<r) {
            int mid = (l+r)/2;
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            merge(a, l, mid, r);
        }
    }

    public static void merge(int[] a, int l, int mid, int r) {
        int[] tmp = new int[r-l+1];

        int i=l,j=mid+1,k=0;
        while(i<=mid&&j<=r) {
            if(a[i]<=a[j]) {
                tmp[k++]=a[i++];
            } else {
                tmp[k++]=a[j++];
            }
        }

        while(i<=mid) {
            tmp[k++] = a[i++];
        }

        while(j<=r) {
            tmp[k++] = a[j++];
        }

        for(i=0;i<tmp.length;i++) {
            a[l++] = tmp[i];
        }
    }
    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        mergeSort(a, 0, 9);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.print(" ");
    }
}
