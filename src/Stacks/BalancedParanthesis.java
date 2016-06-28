package Stacks;

import java.util.Stack;
/**
 * Created by Prashant on 6/27/16.
 * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 */
public class BalancedParanthesis {
    public boolean isOpeningBracket(char c) {
        if(c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    public boolean isMatching(char a, char b) {
        if(a == '(' && b == ')') {
            return true;
        } else if(a == '[' && b == ']') {
            return true;
        } else if(a == '{' && b == '}') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBalanced(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(isOpeningBracket(c)) {
                stack.push(c);
            } else {
                // if no opening bracket for the closing bracket return false.
                if(stack.isEmpty()) {
                    return false;
                }
                char tmp = stack.pop();
                if(!isMatching(tmp, c)) {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedParanthesis bp = new BalancedParanthesis();
        String s = "{()}[]";
        System.out.println(bp.isBalanced(s));
        String s2 = "[()]{}{[()()]()}";
        System.out.println(bp.isBalanced(s2));
        String s3 = "[(])";
        System.out.println(bp.isBalanced(s3));
    }
}
