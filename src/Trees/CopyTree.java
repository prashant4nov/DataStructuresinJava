 class Node{
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} 

 public class CopyTree {
    public static void print(Node n) {
    if(n.left != null)
       print(n.left);
    if(n != null)
       System.out.print(n.data + ",");
    if(n.right != null)
       print(n.right);
    }
    public static Node copyTree(Node root) {
        if(root == null) return null;
        Node r1 = new Node(root.data);
        r1.left = copyTree(root.left);
        r1.right = copyTree(root.right);
        return r1;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);
        print(a);
        System.out.println();
        print(copyTree(a));
    }
}
