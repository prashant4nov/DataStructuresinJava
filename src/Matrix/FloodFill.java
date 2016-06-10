package Matrix;

/**
 * Created by Prashant on 6/9/16.
 */
public class FloodFill {
    public static void floodFillUtil(int[][] a, int x, int y, int oldValue, int newValue) {
        if(x<0||x>a.length-1||y<0||y>a[0].length-1) return;
        if(a[x][y]!=oldValue) return;
        a[x][y]=newValue;
        floodFillUtil(a, x-1, y, oldValue, newValue);
        floodFillUtil(a, x+1, y, oldValue, newValue);
        floodFillUtil(a, x, y-1, oldValue, newValue);
        floodFillUtil(a, x, y+1, oldValue, newValue);
    }
    public static void floodFill(int[][] a, int x, int y, int newValue) {
        int oldValue = a[x][y];
        floodFillUtil(a, x, y, oldValue, newValue);
    }
    public static void main(String[] args) {

        int screen[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4, y = 4, newC = 3;
        floodFill(screen, x, y, newC);
        RotateMatrix.printMatrix(screen);
        System.out.print(" ");
    }
}
