package Matrix;

/**
 * Created by Prashant on 6/9/16.
 * http://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/
 */
public class Islands {
    public static int islands(int[][] a) {
        int cnt =0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(a[i][j]=='X') {
                    if((i==0||a[i-1][j]=='O')&&
                            (j==0||a[i][j-1]=='O')) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int mat[][] =  {
                {'O', 'O', 'O'},
                {'X', 'X', 'O'},
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'}
        };

        System.out.print(islands(mat)+" ");
    }
}
