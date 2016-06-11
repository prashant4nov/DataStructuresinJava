package Matrix;

/**
 * Created by Prashant on 6/10/16.
 */
public class ClockWiseRotateEl {
    public static void rotateElements(int[][] a) {
        int r=0,c=0,rows=a.length, cols=a[0].length;
        int prev, curr;

        while(r<rows&&c<cols) {
            if(r+1==rows||c+1==cols) break;
            prev = a[r+1][c];
            for(int i=c;i<cols;i++) {
                curr = a[r][i];
                a[r][i]=prev;
                prev=curr;
            }
            r++;

            for(int i=r;i<rows;i++) {
                curr = a[i][cols-1];
                a[i][cols-1]=prev;
                prev=curr;
            }
            cols--;

            if(r<rows) {
                for (int i = cols - 1; i>=c; i--) {
                    curr = a[rows - 1][i];
                    a[rows - 1][i] = prev;
                    prev = curr;
                }
            }
            rows--;

            if(c<cols) {
                for(int i=rows-1;i>=r;i--) {
                    curr = a[i][c];
                    a[i][c]= prev;
                    prev = curr;
                }
            }
            c++;
        }

    }
    public static void main(String[] args) {

        int a[][] = { {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}  };
        RotateMatrix.printMatrix(a);
        rotateElements(a);
        System.out.println(" ");
        RotateMatrix.printMatrix(a);
    }
}
