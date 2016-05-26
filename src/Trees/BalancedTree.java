package Trees;

/**
 * Implement a function to check if a tree is balanced.
 * Time complexity of this O(n)
 * http://www.ideserve.co.in/learn/check-if-a-binary-tree-is-balanced
 * Created by jp on 5/26/16.
 */
public class BalancedTree {

    private static int isBalancedTree(Node root) {
        if(root == null) {
            return 0;
        }

        int left = isBalancedTree(root.left);
        if(left == -1) {
            return -1;
        }

        int right = isBalancedTree(root.right);
        if(right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return (Math.max(left, right) + 1);
    }
    public static void main(String[] args) {
        Node tree = new Node(1);

        tree.left = new Node(2);
        tree.right = new Node(3);

        tree.left.left = new Node(4);
        tree.left.right = new Node(5);

        tree.left.left.left = new Node(8);

        int result = isBalancedTree(tree);
        System.out.println(result);

    }
}
