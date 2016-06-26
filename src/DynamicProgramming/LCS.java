package DynamicProgramming;

/**
 * Created by Prashant on 6/25/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * O(mn) complexity
 */
public class LCS {
    public int lcs(char[] a, char[] b) {
        int[][] tmp = new int[a.length+1][b.length+1];
        int max = 0;
        for(int i=1;i<tmp.length;i++) {
            for(int j=1;j<tmp[i].length;j++) {
                if(a[i-1]==b[j-1]) {
                    tmp[i][j] = tmp[i-1][j-1]+1;
                } else {
                    tmp[i][j] = Math.max(tmp[i-1][j], tmp[i][j-1]);
                }

                if(max<tmp[i][j]) {
                    max = tmp[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        LCS lcs = new LCS();
        System.out.print(lcs.lcs(str1.toCharArray(), str2.toCharArray())+" ");
    }
}
