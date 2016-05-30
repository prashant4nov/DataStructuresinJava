package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class SearchSortedPivoted {
    static int search(int[] a, int x, int l, int r) {
        if(l<=r) {
            int mid = (l+r)/2;
            if(a[mid]==x) {
                return mid;
            }
            //if a[l ... mid] is sorted.
            if(a[l]<=a[mid]) {
                if(a[l]<=x&&x<a[mid]) {
                    return search(a,x,l, mid-1);
                }
                return search(a,x,mid+1,r);
            }
            // else a[mid ... r] must be sorted.
            if(a[mid]<x&&x<=a[r]){
                return search(a,x,mid+1,r);
            }
            return search(a,x,l,mid-1);
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] a = {3,4,5,1,2};
        int x = 4;
        System.out.print(search(a,x,0,a.length-1)+" ");
    }
}
