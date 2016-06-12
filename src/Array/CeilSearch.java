package Array;

/**
 * Created by Prashant on 6/12/16.
 * http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
 */
public class CeilSearch {
    public static int ceilSearchUtil(int[] a, int l, int r, int x) {


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
