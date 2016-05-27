package Trees;

/**
 * Root to leaf path sum equal to a given number.
 * Created by jp on 5/26/16.
 */
public class SumPath {
    static boolean hasPath(Node root, int sum) {
        if(root == null) return (sum == 0);
        int res = sum - root.data;
        return (hasPath(root.left, res) || hasPath(root.right, res));
    }
    public static void main (String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print(hasPath(root, 8));

    }
}
