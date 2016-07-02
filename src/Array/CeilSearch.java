package Array;

/**
 * Created by Prashant on 6/12/16.
 * http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
 */
public class CeilSearch {
    public static int ceilSearchUtil(int[] a, int l, int r, int x) {
        if(x<=a[l]) return a[l];
        if(x>a[r]) return -1;
        if(l<=r) {
            int mid = (l+r)/2;
            if(a[mid]==x) return a[mid];
            if(a[mid]<x) {
                if(a[mid+1]>=x && mid+1<=r) return a[mid+1];
                return ceilSearchUtil(a, mid+1, r, x);
            }
            if(a[mid]>x){
                if(mid-1>=l && a[mid-1]<x) return a[mid];
                return ceilSearchUtil(a, l, mid-1, x);
            }
        }
        return -1;
    }

    public static int ceilSearch(int[] a, int x) {
        return ceilSearchUtil(a, 0, a.length-1, x);
    }
    public static void main(String[] args) {

        int[] a = {1, 2, 8, 10, 10, 12, 19};

        System.out.print(ceilSearch(a, 3)+" ");

        System.out.print(ceilSearch(a, 20)+" ");

        System.out.print(ceilSearch(a, 19)+" ");

        System.out.print(ceilSearch(a, -6)+" ");

        System.out.print(ceilSearch(a, 10)+" ");

        System.out.print(ceilSearch(a, 12)+" ");

        System.out.print(ceilSearch(a, 8)+" ");

        System.out.print(ceilSearch(a, 2)+" ");

        System.out.print(ceilSearch(a, 1)+" ");

        System.out.print(ceilSearch(a, 11)+" ");

    }
}
