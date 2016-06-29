package Matrix;
import java.util.Arrays;

/**
 * Created by Prashant on 6/9/16.
 * http://www.geeksforgeeks.org/print-matrix-diagonally/
 */
public class printDiagonally {
    public static void printMatrixDiagonally(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;

        for(int k=0;k<rows;k++) {
            for(int r=k,c=0;r>=0&&c<cols; r--,c++) {
                System.out.print(a[r][c]+" ");
            }
            System.out.println();
        }

        for(int k=1;k<cols;k++) {
            for(int r=rows-1,c=k;r>=0&&c<cols;r--,c++) {
                System.out.print(a[r][c]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int row = 4, col = 5;
        int k = 1;
        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = k++;
            }
        }

        System.out.println("Input Matrix");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("\nPrinting Matrix Diagonally");
        printMatrixDiagonally(matrix);
    }

}
