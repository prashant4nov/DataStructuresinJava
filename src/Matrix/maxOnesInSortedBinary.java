package Matrix;

/**
 * Created by Prashant on 6/9/16.
 * O(mlong(n))
 */
public class maxOnesInSortedBinary {
    public static int find(int[] a, int left, int right) {
        if(left<=right) {
            int mid = (left+right)/2;

            if((mid==0||a[mid-1]==0)&&a[mid]==1) return mid;
            if(a[mid]==0) return find(a, mid+1, right);
            return find(a,left,mid-1);
        }
        return -1;
    }
    public static void maxOnesRow(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        int index = cols-1;
        int maxRow = -1;
        for(int r=0;r<rows;r++) {
            int rowIndex = find(a[r], 0, cols-1);
            if(rowIndex<index && rowIndex!=-1) {
                index = rowIndex;
                maxRow = r;
            }
        }
        System.out.println(index+"");
        System.out.print(maxRow);

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
