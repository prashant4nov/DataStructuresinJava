package Stacks;
import java.util.Stack;
/**
 * Created by Prashant on 6/28/16.
 */
public class SpecialStack extends Stack<Integer>{
    Stack<Integer> s2;
    public SpecialStack() {
        s2 = new Stack<Integer>();
    }

    public void push(int val) {
        if(val < min()) {
            s2.push(val);
        }
        super.push(val);
    }

    public Integer pop() {
        int val = super.pop();
        if(val == min()) {
            s2.pop();
        }
        return val;
    }

    public int min() {
        if(s2.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return s2.peek();
    }

    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.min()+" ");
        s.push(5);
        System.out.println(s.min()+" ");
    }
}
