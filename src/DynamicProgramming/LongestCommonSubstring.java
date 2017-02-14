import java.util.*;

class LongestCommonSubstring {
    
    public static int longestCommonSubstring(char[] a, char[] b) {
        if(a == null || b == null) return 0;
        if(a.length == 0 || b.length == 0) return 0;
        int m = a.length;
        int n = b.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str1 = null;
        String str2 = null;
        System.out.println(longestCommonSubstring(null, null));
    }
}
