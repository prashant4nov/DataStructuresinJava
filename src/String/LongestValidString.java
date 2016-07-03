package String;
import java.util.Stack;

/**
 * Created by Prashant on 7/3/16.
 * http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 */
public class LongestValidString {
    public int longestString(char[] s) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        for(int i=0;i<s.length;i++) {
            if(s[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()) {
                    res = Math.max(res,i-stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        char[] str = "((()()".toCharArray();
        LongestValidString lv = new LongestValidString();
        System.out.print(lv.longestString(str));
    }
}
