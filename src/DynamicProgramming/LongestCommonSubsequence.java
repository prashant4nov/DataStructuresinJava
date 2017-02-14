package DynamicProgramming;

// A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous

/**
 * Created by Prashant on 6/25/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * O(mn) complexity
 */

/**
 * Created by Prashant on 6/25/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * O(mn) complexity
 */
public class LongestCommonSubsequence {
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
        //return max;
        int res = max;
        char[] ls = new char[max];
        int i = a.length, j = b.length;
        
        while(i > 0 && j > 0) {
            if(a[i-1] == b[j-1]) {
                ls[max-1] = a[i-1];
                i--; j--; max--;
            } else {
              if(tmp[i-1][j] < tmp[i][j-1]) {
                  j--;
              } else {
                  i--;
              }
            }
        }
        
        for(Character c : ls) {
            System.out.print(c);
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.lcs(str1.toCharArray(), str2.toCharArray())+" ");
    }
}

