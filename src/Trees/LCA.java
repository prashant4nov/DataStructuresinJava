package Trees;

/** LCA
 * Created by jp on 5/26/16.
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * http://code.geeksforgeeks.org/oUwxmC when nodes are not present
 */
public class LCA {
    static Node lca(Node root, Node a, Node b) {
        if(root == null) return root;
        if(root == a || root == b) return root;

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if(left != null && right != null) return root;

        return (left != null ? left: right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Node a = root.left.left = new Node(4);
        Node b = root.left.right = new Node(5);

        Node res = lca(root, a, b);
        System.out.print(res.data);
    }
}
