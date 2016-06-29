package Matrix;

import java.util.HashMap;

/**
 * Created by Prashant on 6/11/16.
 * http://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/
 */
public class commomElinRows {
    public static void commomElinRows(int[][] a) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int rows = a.length;
        int cols = a[0].length;
        int r=0, c;
        for(c=0;c<cols;c++) {
            if(mp.containsKey(a[r][c])==false) {
                mp.put(a[r][c], 0);
            }
        }
        for(r=1;r<rows;r++) {
            for(c=0;c<cols;c++) {
                if(mp.containsKey(a[r][c])&&mp.get(a[r][c])==r-1) {
                    mp.put(a[r][c], mp.get(a[r][c])+1);
                }
            }
        }

        for(Integer key : mp.keySet()) {
            if(mp.get(key)==rows-1) {
                System.out.print(key+" ");
            }
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},
        };
        commomElinRows(mat);
        System.out.print(" ");
    }
}
