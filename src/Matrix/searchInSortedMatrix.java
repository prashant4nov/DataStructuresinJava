package Matrix;

/**
 * Created by Prashant on 6/9/16.
 */
public class searchInSortedMatrix {
    public static boolean search(int[][] mat, int x) {
        int m = mat.length, n = mat[0].length;
        int i = 0, j = n-1;
        while(i<m&&j>=0) {
            if(mat[i][j]==x) return true;
            if(mat[i][j]<x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int mat[][] = { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50},
        };
        System.out.println(search(mat, 29)+" ");
        System.out.print(search(mat, 51));
    }
}
