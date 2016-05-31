package Trees;
import java.util.Stack;

/**
 * Created by Prashant on 5/30/16.
 */
public class ZigZagTraversal {
    static void zigzag(Node root) {
        if(root==null) return;
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(root);

        while(!s1.isEmpty()||!s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node tmp = s1.pop();
                System.out.print(tmp.data + " ");
                if (tmp.left != null) {
                    s2.push(tmp.left);
                }
                if (tmp.right != null) {
                    s2.push(tmp.right);
                }
            }

            while (!s2.isEmpty()) {
                Node tmp = s2.pop();
                System.out.print(tmp.data + " ");
                if (tmp.right != null) {
                    s1.push(tmp.right);
                }
                if (tmp.left != null) {
                    s1.push(tmp.left);
                }
            }
        }
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);
        zigzag(a);
    }
}
