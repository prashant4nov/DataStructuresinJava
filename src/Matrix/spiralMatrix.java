package Matrix;

/**
 * Created by Prashant on 6/9/16.
 */
public class spiralMatrix {
    public static void spiralMatrix(int[][] a) {
        int r=0,c=0,row=a.length,col=a[0].length;
        int i = 0;
        while(r<row&&c<col) {
            for(i=r;i<col;i++) {
                System.out.print(a[r][i]+" ");
            }
            System.out.println();
            r++;
            for(i=r;i<row;i++) {
                System.out.print(a[i][col-1]+" ");
            }
            System.out.println();

            col--;
            if(r<row) {
                for(i=col-1;i>=c;i--) {
                    System.out.print(a[row-1][i]+" ");
                }
            }
            System.out.println();

            row--;
            if(c<col) {
                for(i=row-1;i>=r;i--) {
                    System.out.print(a[i][c]+" ");
                }
            }
            System.out.println();

            c++;
        }
    }
    public static void main(String[] args) {
        int a[][] = { {1,  2,  3,  4,  5,  6},
            {7,  8,  9,  10, 11, 12},
            {13, 14, 15, 16, 17, 18}
        };
        spiralMatrix(a);
    }
}
