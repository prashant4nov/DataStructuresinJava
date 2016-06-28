package Stacks;
import java.util.Stack;

/**
 * Created by Prashant on 6/27/16.
 */
public class InfixToPostfix {

    public boolean isOperator(char a) {
        if(a == '+' || a == '-' || a == '*' || a == '/' || a == '^') {
            return true;
        }
        return false;
    }

    // check if a is of same or higher precedence.
    public boolean checkPrecedence(char a, char b) {
        if((a == '+' || a == '-') && (b == '+' || b == '-')) {
            return true;
        } else if((a == '*' || a == '/') &&
                (b == '+' || b == '-' || b == '*' || b == '/')) {
            return true;
        } else if((a == '^') && (b == '+' || b == '-' || b == '*' || b == '/' || b == '^')) {
            return true;
        } else {
            return false;
        }
    }

    public String infixToPostfix(String s) {
        String postFix = "";
        Stack<Character> stack = new Stack<Character>();
        // mark end of stack.
        stack.push('#');

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(isOperator(c)) {
                //repeatedly pop if stack top has same or higher precedence.
                // Stack should be maintained in increasing order of precedence.
                while(checkPrecedence(stack.peek(), c)) {
                    postFix += stack.pop();
                }
                stack.push(c);
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                while(stack.peek() != '(') {
                    postFix += stack.pop();
                }
                stack.pop();
            } else {
                postFix += c;
            }
        }

        while(stack.peek() != '#') {
            postFix += stack.pop();
        }

        return postFix;
    }

    public static void main(String[] args) {
        InfixToPostfix itp = new InfixToPostfix();
        String s = "A+(B*C-(D/E^F)*G)*H";
        System.out.println(itp.infixToPostfix(s));
        String s2 = "(a+b)*c";
        System.out.print(itp.infixToPostfix(s2));
        System.out.print(" ");
    }
}