package String;

/**
 * Created by Prashant on 7/1/16.
 * http://stackoverflow.com/questions/9723912/reversing-a-string-with-recursion-in-java
 */
public class ReverseStringRecursion {
    public String revString(String s) {
        if(s.length()==0) return s;
        return revString(s.substring(1)) + s.charAt(0);
    }

    public String reverseString(char[] s, int start, int end) {
        if(start==end) {
            return new String(s);
        } else {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            end--; start++;
            return reverseString(s, start, end);
        }
    }
    public String reverse(char[] s) {
        return reverseString(s, 0, s.length-1);
    }
    public static void main(String[] args) {
        ReverseStringRecursion rs = new ReverseStringRecursion();
        String s = "hello";
        System.out.println(rs.reverse(s.toCharArray()));
        System.out.println(rs.revString("hello"));
    }
}
