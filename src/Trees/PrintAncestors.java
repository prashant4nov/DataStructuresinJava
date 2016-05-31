package Trees;

/**
 * Created by Prashant on 5/30/16.
 */
public class PrintAncestors {
    static boolean printAncestors(Node root, int target) {
        if(root==null) return false;
        if(root.data==target) return true;
        if(printAncestors(root.left,target) || printAncestors(root.right,target)) {
            System.out.print(root.data+" ");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);
        a.right.left.left = new Node(8);
        printAncestors(a, 8);
    }
}
