package Matrix;

import java.util.HashMap;

/**
 * Created by Prashant on 6/9/16.
 */
public class commonInSortedMatrix {

    public static void findCommon(int[][] a) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0;i<a[0].length;i++) {
            if(mp.containsKey(a[0][i])==false) {
                mp.put(a[0][i], 0);
            }
        }

        for(int i=1;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(mp.containsKey(a[i][j])==true) {
                   if(mp.get(a[i][j])!=i) {
                       mp.put(a[i][j], mp.get(a[i][j])+1);
                   }
                }
            }
        }

        for(Integer key : mp.keySet()) {
            if(mp.get(key)==a.length-1) {
              System.out.println(key);
            }
        }
    }

    public static void main(String[] args) {
        int mat[][] = { {1, 2, 3, 4, 5},
            {2, 4, 5, 8, 10},
            {3, 5, 7, 9, 11},
            {1, 3, 5, 7, 9},
        };
        findCommon(mat);
    }
}
