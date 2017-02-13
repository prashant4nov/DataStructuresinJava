// http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

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
        String str1 = "BBABCBCAB";
        StringBuilder str = new StringBuilder(str1);
        String str2 = str.reverse().toString();
        LCS lcs = new LCS();
        System.out.println(lcs.lcs(str1.toCharArray(), str2.toCharArray())+" ");
    }
}
