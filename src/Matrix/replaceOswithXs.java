package Matrix;


/**
 * Created by Prashant on 6/9/16.
 * http://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
 */
public class replaceOswithXs {
    public static void replaceOs(int[][] a) {
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(a[i][j]==0) {
                    a[i][j]=2;
                }
            }
        }

        for(int i=0;i<a[0].length;i++) {
            if(a[0][i]==2) {
                FloodFill.floodFill(a, 0, i, 0);
            }
        }

        for(int i=0;i<a[0].length;i++) {
            if(a[a.length-1][i]==2) {
                FloodFill.floodFill(a, a.length-1, i, 0);
            }
        }

        for(int i=0;i<a.length;i++) {
            if(a[i][0]==2) {
                FloodFill.floodFill(a, i, 0, 0);
            }
        }

        for(int i=0;i<a.length;i++) {
            if(a[i][a[0].length-1]==2) {
                FloodFill.floodFill(a, i, a[0].length-1, 0);
            }
        }

        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(a[i][j]==2) {
                    a[i][j]=1;
                }
            }
        }



    }
    public static void main(String[] args) {
        int mat[][] =  {{1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 0, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 0},
        };
        RotateMatrix.printMatrix(mat);
        System.out.println();
        replaceOs(mat);
        RotateMatrix.printMatrix(mat);

    }
}
