package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class MedianSortedArray {
    static int median(int[] a) {
        int mid = (a.length-1)/2;
        if(a.length%2==0) {
            return (a[mid]+a[mid+1])/2;
        } else {
            return a[mid]/2;
        }
    }
    static int medianSortedArray(int[] a, int[] b, int l, int r) {
        if (a.length==1&&b.length==1) {
            return (a[0]+b[0])/2;
        }
        if(a.length==2&&b.length==2) {
            return (Math.max(a[0],b[0])+Math.min(a[1],b[1]))/2;
        }
        int m1 = median(a);
        int m2 = median(b);
        if (m1==m2) return m1;

        if(m1<m2) {
            if(a.length%2==0) {
               // return medianSortedArray(a+(a.length-1)/2,b,,);
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
        System.out.print(medianSortedArray(ar1,ar2, 0, ar1.length-1)+" ");
    }
}
