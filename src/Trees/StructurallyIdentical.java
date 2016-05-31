package Trees;

/**
 * Created by Prashant on 5/30/16.
 */
public class StructurallyIdentical {
    static boolean isIdentical(Node a, Node b) {
        if(a==null&&b==null) return true;
        if(a==null||b==null) return false;
        return (a.data==b.data&&isIdentical(a.left,b.left)
                              &&isIdentical(a.right,b.right));
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);

        Node b = new Node(1);
        b.left = new Node(2);
        b.right = new Node(3);
        b.left.left = new Node(4);
        b.left.right = new Node(5);
        b.right.left = new Node(6);
        b.right.right = new Node(7);

        System.out.print(isIdentical(a,b));
    }
}
