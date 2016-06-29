package Matrix;

/**
 * Created by Prashant on 6/9/16.
 * http://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
 */
public class MatrixXO {
    public static int[][] matrixXO(int m, int n) {
        int[][] mat = new int[m][n];
        int r=0,c=0,row=m,col=n,i=0;
        int val = 1;
        while(r<row&&c<col) {
            for(i=r;i<col;i++) {
                mat[r][i]=val;
            }
            r++;

            for(i=r;i<row;i++) {
                mat[i][col-1]=val;
            }
            col--;

            if(r<row) {
                for(i=col-1;i>=c;i--) {
                    mat[row-r][i]=val;
                }
            }
            row--;
            if(c<col) {
                for(i=row-1;i>=r;i--) {
                    mat[i][c]=val;
                }
            }
            c++;
            if(val==1) {
                val=0;
            } else {
                val=1;
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        RotateMatrix.printMatrix(matrixXO(5,6));
    }
}
