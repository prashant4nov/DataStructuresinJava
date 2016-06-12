package Array;

/**
 * Created by Prashant on 6/11/16.
 */
public class CountInversions {
    public static int mergeSort(int[] a, int l, int r) {
        int count = 0;
        if(l<r) {
            int mid = (l+r)/2;
            count = mergeSort(a, l, mid);
            count += mergeSort(a, mid+1, r);
            count += merge(a, l, mid, r);
        }
        return count;
    }

    public static int merge(int[] a, int l, int mid, int r) {
        int[] tmp = new int[r-l+1];
        int count = 0;
        int i=l, j=mid+1, k=0;

        while(i<=mid&&j<=r) {
            if(a[i]<=a[j]) {
                tmp[k++] = a[i++];
            } else {
                count = count + (mid-i);
                tmp[k++] = a[j++];
            }
        }

        while(i<=mid) {
            tmp[k++] = a[i++];
        }

        while(j<=r) {
            tmp[k++] = a[j++];
        }

        for(k=0;k<tmp.length;k++) {
            a[l++] = tmp[k];
        }
        return count;
    }

    public static int countInversions(int[] a) {
        return mergeSort(a, 0, a.length-1);
    }
    public static void main(String[] args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println(countInversions(a) + " ");
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}
