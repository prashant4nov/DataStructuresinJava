// http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
//A Dynamic Programming based Python Program for the Egg Dropping Puzzle
class LPS
{

	// A utility function to get max of two integers
	static int max (int x, int y) { return (x > y)? x : y; }
	
	// Returns the length of the longest palindromic subsequence in seq
	static int lps(String seq)
	{
	int n = seq.length();
	int i, j, cl;
	int L[][] = new int[n][n]; // Create a table to store results of subproblems
	
	// Strings of length 1 are palindrome of lentgh 1
	for (i = 0; i < n; i++)
		L[i][i] = 1;
			
		// Build the table. Note that the lower diagonal values of table are
		// useless and not filled in the process. The values are filled in a
		// manner similar to Matrix Chain Multiplication DP solution (See
		// http://www.geeksforgeeks.org/archives/15553). cl is length of
		// substring
		for (cl=2; cl<=n; cl++)
		{
			for (i=0; i<n-cl+1; i++)
			{
				j = i+cl-1;
				if (seq.charAt(i) == seq.charAt(j) && cl == 2)
				L[i][j] = 2;
				else if (seq.charAt(i) == seq.charAt(j))
				L[i][j] = L[i+1][j-1] + 2;
				else
				L[i][j] = max(L[i][j-1], L[i+1][j]);
			}
		}
			
		return L[0][n-1];
	}
		
	/* Driver program to test above functions */
	public static void main(String args[])
	{
		String seq = "GEEKSFORGEEKS";
		int n = seq.length();
		System.out.println("The lnegth of the lps is "+ lps(seq));
	}
}

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
