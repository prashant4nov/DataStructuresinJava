package Matrix;

/**
 * Created by Prashant on 6/8/16.
 */
public class InplaceRotateSquareMatrix {
    public static void inplaceRotate(int[][] mat) {
        int n = mat.length;
        for(int x=0;x<n/2;x++) {
            for(int y=x;y<n-x-1;y++) {
                int tmp = mat[x][y];
                mat[x][y]=mat[y][n-x-1];
                mat[y][n-x-1]=mat[n-x-1][n-y-1];
                mat[n-x-1][n-y-1]=mat[n-y-1][x];
                mat[n-y-1][x]=tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] [] matrix =  {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        RotateMatrix.printMatrix(matrix);
        inplaceRotate(matrix);
        RotateMatrix.printMatrix(matrix);
    }
}
