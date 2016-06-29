package Matrix;

/**
 * Created by Prashant on 6/11/16.
 * http://www.geeksforgeeks.org/count-negative-numbers-in-a-column-wise-row-wise-sorted-matrix/
 */
public class CountNegativeNos {
    public static int countNegNos(int[][] a) {
        int count = 0;
        int c = a[0].length-1;
        int r = 0;
        while(c>=0&&r<a.length) {
            if(a[r][c]<0) {
                count+=(c+1);
                r++;
            } else {
                c--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] m = {
                {-3, -2, -1, 1},
                {-2, 2, 3, 4},
                {4, 5, 7, 8}
        };

        System.out.print(countNegNos(m)+" ");
    }
}
