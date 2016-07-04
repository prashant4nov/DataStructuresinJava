package Trees;

/**
 * Created by Prashant on 5/30/16.
 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 */
public class MirrorTree {
    static void mirror(Node root) {
        if(root==null) return;
        mirror(root.left);
        mirror(root.right);
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);
        TreeTraversals.inOrder(a);
        mirror(a);
        TreeTraversals.inOrder(a);
    }
}
