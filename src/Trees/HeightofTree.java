package Trees;

/**
 * Created by Prashant on 5/30/16.
 */
public class HeightofTree {
    static int height(Node root) {
        if(root==null) return 0;
        return (1+Math.max(height(root.left), height(root.right)));
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);
        System.out.print(height(a)+" ");
    }
}
