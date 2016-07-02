package Matrix;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
 * Created by jp on 5/25/16.
 */
public class RotateMatrix {
    public static void printMatrix(int[][] mat) {
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] rotateMatrix(int[] [] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] [] res = new int[n][m];
        for(int i = 0; i<m; i++) {
            for (int j=0;j<n;j++) {
                res[j][m-i-1] = mat[i][j];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] [] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        printMatrix(matrix);
        matrix = rotateMatrix(matrix);
        printMatrix(matrix);
    }
}
