package Array;

import java.util.HashSet;

/**
 * Created by Prashant on 5/30/16.
 */
public class CheckPair {
    static boolean checkPair(int[] a, int x) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<a.length;i++) {
            int tmp = x-a[i];
            if(set.contains(tmp)) {
                return true;
            } else {
                set.add(a[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {7,2,5,6,2,3,4,1};
        System.out.print(checkPair(a,10)+" ");
    }
}
