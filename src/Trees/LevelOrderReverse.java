package Trees;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Created by Prashant on 5/30/16.
 * http://www.geeksforgeeks.org/reverse-level-order-traversal/
 */
public class LevelOrderReverse {
    static void levelOrderReverse(Node root) {
        if(root == null) return;
        Node node = root;
        Stack<Node> stack = new Stack<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        Node tmp = null;
        while(!queue.isEmpty()){
            tmp = queue.poll();
            stack.push(tmp);
            if(tmp.right!=null) queue.add(tmp.right);
            if(tmp.left!=null) queue.add(tmp.left);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().data+" ");
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        levelOrderReverse(root);
    }
}
