package Trees;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with
 * minimal height.
 * Created by jp on 5/26/16.
 */
public class ArrayToTree {
    private static Node arrToTree(int a[], int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = (left+right)/2;

        Node node = new Node(a[mid]);
        node.left = arrToTree(a, left, mid-1);
        node.right = arrToTree(a, mid+1, right);

        return node;
    }

    private static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8};
        Node tree = arrToTree(a, 0, a.length-1);
        inOrder(tree);
    }
}
