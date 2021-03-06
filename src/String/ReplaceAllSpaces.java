// Remove spaces from a given string Given a string, remove all spaces from the string and return it.
// Input: "g eeks for ge eeks " Output: "geeksforgeeks" Expected time complexity is O(n) and only one traversal of string.
// http://stackoverflow.com/questions/16579273/replace-character-in-stringbuilder

import java.util.*;

public class ReplaceAllSpaces {
    public static void main(String args[]) {
        StringBuilder str = new StringBuilder("g eeks for ge eeks ");
        functionName(str);
        System.out.println(str);
    }
    
    public static void functionName(StringBuilder s) {
        if(s==null) return;
        int j = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)!=' ') {
                s.setCharAt(j, s.charAt(i));
                j++;
            }
        }
    }
}
