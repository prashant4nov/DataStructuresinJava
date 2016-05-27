package Trees;

/**
 * Given a binary tree, print all root-to-leaf paths
 * Created by jp on 5/26/16.
 */
public class RootToLeaf {
    static void printPathUtil(Node node, int[] path, int len) {
        if(node == null) return;

        path[len] = node.data;
        len++;

        if(node.left == null && node.right == null) {
            printArray(path, len);
        } else {
            printPathUtil(node.left, path, len);
            printPathUtil(node.right, path, len);
        }
    }
    static void printPath(Node root) {
        int[] path = new int[1000];
        printPathUtil(root, path, 0);
    }
    static void printArray(int[] path, int len) {
        for(int i = 0; i< len; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printPath(root);
    }
}
