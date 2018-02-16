package Array;
import java.util.Stack;

/**
 * use flag, stack queue, continue, tmp variable, use for loop first thing 
 * Created by Prashant on 6/12/16.
 * http://www.geeksforgeeks.org/next-greater-element/
 */
public class NGE {
    
    static void printNGE(int a[], int n)
	{
	    Stack<Integer> s = new Stack<Integer>();
	    System.out.println("for: " + a[n-1] + ": " + -1);
	    s.push(a[n-1]);
	    
	    for(int i = n-2; i >= 0; ) {
	    	    if(!s.isEmpty()) {
		    	    System.out.println("stack peek: " + s.peek());

		    	     if(s.peek() > a[i]) {
		    	    	   System.out.println("for: " + a[i] + ": " + s.peek());
		    	    	   s.push(a[i--]);
		    	     } else {
		    	    	    s.pop();
		    	    	    continue;
		    	     }
	    	    } else {
	    	    	    System.out.println("for: " + a[i] + ": " + -1);
	    	    	    s.push(a[i--]);
	    	    }
	    }
	}
    
    public static void nge(int[] a) {
        Stack<Integer> s = new Stack<Integer>();
        int i = a.length-1;
        System.out.println("NGE for:" + a[i] + "-->" + -1);
        s.push(a[i--]);
        while(i>=0) {
            if(s.isEmpty()==false) {
                if(s.peek()>a[i]) {
                    System.out.println("NGE for:" + a[i] + "-->" + s.peek());
                    s.push(a[i--]);
                } else {
                    s.pop();
                    continue;
                }
            } else {
                System.out.println("NGE for:" + a[i] + "-->" + -1);
                s.push(a[i--]);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a= {4, 5, 2, 25};
        nge(a);
        int [] b = {13, 7, 6, 12};
        nge(b);

        int arr[]= {11, 13, 21, 3};
        nge(arr);
        System.out.print(" ");
    }
}
