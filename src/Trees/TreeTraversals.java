package Trees;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

/**
 * Created by jp on 5/26/16.
 */
public class TreeTraversals {
    static void inOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(true) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            if(stack.isEmpty()) break;
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    static void preOrder(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(true){
            while(node != null) {
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.left;
            }

            if(stack.isEmpty()) break;
            node = stack.pop();
            node = node.right;
        }
    }

    static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Node node = root;
        queue.add(node);
        while(!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

    }
    public static void main(String[] args) {
          /* creating a binary tree and entering
         the nodes */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.print("in order traversal: ");
        inOrder(root);
        System.out.println(" ");
        System.out.print("pre order traversal: ");
        preOrder(root);
        System.out.println(" ");
        System.out.print("level order traversal: ");
        levelOrder(root);
    }
}
