package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Create d list.
 * Created by jp on 5/26/16.
 * http://algorithms.tutorialhorizon.com/in-a-binary-tree-create-linked-lists-of-all-the-nodes-at-each-depth/
 */
public class DList {
    static ArrayList<LinkedList<Node>> dList(Node root) {
        if(root == null) return null;

        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> list = new LinkedList<Node>();
        Queue<Node> q = new LinkedList<Node>();

        int level = 0;
        Node node = root;
        q.add(node);
        q.add(null);

        while(!q.isEmpty()) {
            node = q.poll();
            if(node != null){
                list.add(node);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            } else {
                if(!q.isEmpty()) q.add(null);
                result.add(level, list);
                level++;
                list = new LinkedList<Node>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        ArrayList<LinkedList<Node>> res = dList(root);

        for(LinkedList<Node> list : res) {
            System.out.print(":");
            for(Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
}
