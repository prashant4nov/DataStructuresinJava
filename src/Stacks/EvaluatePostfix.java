package Stacks;

import java.util.Stack;
/**
 * Created by Prashant on 6/27/16.
 * http://quiz.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 */
public class EvaluatePostfix extends InfixToPostfix{
    public int calculateValue(int a, int b, char operator) {
        int res = 0;
        switch(operator) {
            case '+':
                res = a+b;
                break;
            case '-':
                res = a-b;
                break;
            case '*':
                res = a*b;
                break;
            case '/':
                res = a/b;
                break;
            case '^':
                res = a^b;
                break;
        }
        return res;
    }

    public int evaluatePostfix(String s) {
        Stack stack = new Stack();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(isOperator(c)) {
                int b = Integer.parseInt(String.valueOf(stack.pop()));
                int a = Integer.parseInt(String.valueOf(stack.pop()));
                stack.push(calculateValue(a,b,c));
            } else {
                stack.push(c);
            }
        }
        return Integer.parseInt(String.valueOf(stack.peek()));
    }
    public static void main(String[] args) {
        EvaluatePostfix epos = new EvaluatePostfix();
        String s = "231*+9-";
        System.out.print(epos.evaluatePostfix(s));
    }
}
