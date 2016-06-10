package Matrix;

/**
 * Created by Prashant on 6/9/16.
 * Complexity: O(m+n)
 * http://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 */
public class maxOnesInSorted {
    public static void maxOnesRow(int[][] a) {
        int index=-1,maxRow=-1;
        int rows=a.length;
        int cols=a[0].length;
        for(int i=0;i<cols;i++) {
            if(a[0][i]==1) {
                index=i;
                maxRow=0;
                break;
            }
        }
        for(int r=1;r<rows;r++) {
            for(int c=index-1;c>=0;c--) {
                if(a[r][c]==1) {
                    index = c;
                    maxRow = r;
                } else {
                    break;
                }
            }
        }

        System.out.println("index:" + index);
        System.out.print("row:" + maxRow);
    }
    public static void main(String[] args) {
        System.out.print(" ");
        int mat[][] = { {0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };

        maxOnesRow(mat);
    }
}
