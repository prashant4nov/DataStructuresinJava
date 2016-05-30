package Array;

/**
 * Created by Prashant on 5/30/16.
 */
public class MajorityElem {
    static int findCand(int[] a) {
        int cand = a[0];
        int count = 1;
        for(int i=1;i<a.length;i++) {
            if(cand==a[i]) {
                count++;
            } else {
                count--;
            }
            if(count==0) {
                cand = a[i];
                count = 1;
            }
        }
        return cand;
    }
    static int majorityElem(int[] a) {
        int cand = findCand(a);
        int count = 0;
        for(int i=0;i<a.length;i++) {
            if(a[i]==cand) {
                count++;
            }
        }
        if(count>a.length/2) {
            return cand;
        }
        else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.print(majorityElem(a)+" ");
    }
}
