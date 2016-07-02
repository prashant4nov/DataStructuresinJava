package Trees;

/**
 * Created by Prashant on 5/30/16.
 */
public class DiameterTree {
    static int diameter(Node root) {
        if(root==null) return 0;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int leftHeight = HeightofTree.height(root.left);
        int rightHeight = HeightofTree.height(root.right);
        return Math.max(Math.max(leftDiameter, rightDiameter),
                        1+leftHeight+rightHeight);

    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);

        System.out.print(diameter(a)+" ");
    }
}
