// https://leetcode.com/problems/valid-palindrome/?tab=Description
// http://stackoverflow.com/questions/15722624/check-for-palindrome-recursively
// http://stackoverflow.com/questions/15722624/check-for-palindrome-recursively/15722948#15722948

public class Solution {
    public boolean isLetterOrDigit(Character c) {
        if(c >= '0' && c <= '9') return true;
        if(c >= 'a' && c <= 'z') return true;
        return false;
    }
    
    public boolean isPalindromeIterative(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        
        int i = 0, j = s.length()-1;
        while(i < j) {
            if(isLetterOrDigit(s.charAt(i)) && isLetterOrDigit(s.charAt(j))) {
                if(s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            } else {
                if(!isLetterOrDigit(s.charAt(i))) i++;
                if(!isLetterOrDigit(s.charAt(j))) j--;
            }
            
        }
        return true;
    }
    
    // ******************************* Recursive (gives stackoverflow error)**************************** //
    /**
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        return isPalindromeRecursive(s.toLowerCase().toCharArray(), 0, s.length()-1);
    }
    */
    public boolean isPalindromeRecursive(char[] chars, int left, int right) {
        if(left > right) return true;
        return (chars[left] != chars[right]) ? false :
                isPalindromeRecursive(chars, left+1, right-1);
    }
    
        public boolean isPalindromeRecursive(String s) {
        if(s.length() < 2) return true;
        char left = s.charAt(0);
        char right = s.charAt(s.length()-1);
        if(left != right) return false;
        return isPalindromeRecursive(s.substring(0, s.length()-1));
    }
    
    
}
