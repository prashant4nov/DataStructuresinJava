package DynamicProgramming;
// https://www.youtube.com/watch?v=obBdxeCx_Qs
public class LongestPalindromeSubstring {

	public static String getLongestPalindromeSubstring(String s) {

		// check if string is null or empty
		if (s == null || s.length() == 0)
			return "";

		int len = s.length();
		int index = 0, maxLen = 0;
		boolean[][] dp = new boolean[len][len];

		// trivial case for string of length 1
		for (int i = 0; i < len; i++)
			dp[i][i] = true;

		// case for strings of length 2
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
			    maxLen = 2;
			    index = i;
			}    
		}

		// cases for strings of length starting 3 till complete length of the string
		for (int curLen = 3; curLen <= len; curLen++) {
			for (int i = 0; i <= len - curLen; i++) {
				int j = i + curLen - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
					dp[i][j] = true;
					maxLen = curLen;
					index = i;
				}
			}
		}
		return s.substring(index, index + maxLen);
	}

	public static void main(String[] args) {
		System.out.println(getLongestPalindromeSubstring(null));
		System.out.println(getLongestPalindromeSubstring(""));
		System.out.println(getLongestPalindromeSubstring("banana"));
		System.out.println(getLongestPalindromeSubstring("nitin"));
	}
}
