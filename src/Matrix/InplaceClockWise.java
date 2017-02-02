package Matrix;

/**
 * Created by Prashant on 6/10/16.
 */
public class InplaceClockWise {
    public static void inplaceClockWise(int[][] a) {
        int n = a.length;
        for(int x=0;x<n/2;x++) {
            for(int y=x;y<n-x-1;y++) {
                int tmp = a[x][n-y-1];
                a[x][n-y-1] = a[y][x];
                a[y][x] = a[n-x-1][y];
                a[n-x-1][y] = a[n-y-1][n-x-1];
                a[n-y-1][n-x-1] = tmp;
            }
        }
    }
    
    public static void antiClockWise(int[][] a) {
        int n = a.length;
        for(int x = 0; x < n/2; x++) {
            for(int y = x; y < n-x-1; y++) {
                int tmp = a[y][n-x-1];
                a[y][n-x-1] = a[n-x-1][n-y-1];
                a[n-x-1][n-y-1] = a[n-y-1][x];
                a[n-y-1][x] = a[x][y];
                a[x][y] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] [] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        RotateMatrix.printMatrix(matrix);
        inplaceClockWise(matrix);
        RotateMatrix.printMatrix(matrix);
        System.out.print(" ");
    }
}
