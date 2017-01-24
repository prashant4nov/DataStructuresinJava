package Trees;
// http://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
import java.util.*;


class LNode {
    int data;
    LNode next = null;
    LNode(int d) {
        data = d;
    }
}
public class ListToTree {
    
    public static Node ListToTree(LNode head) {
        if(head==null) return null;
        Queue<Node> q = new LinkedList<Node>();
        Node root = new Node(head.data);
        q.add(root);
        head = head.next;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            Node left, right;
            if(head!=null) {
              left = new Node(head.data);
              q.add(left);
              head = head.next;
              node.left = left;
            }
            if(head!=null) {
              right = new Node(head.data);
              q.add(right);
              head = head.next;
              node.right = right;
            }               
        }
        return root;
    }
    
    public static void main(String[] args) {
        LNode list = new LNode(1);
        list.next = new LNode(2);
        list.next.next = new LNode(3);
        list.next.next.next = new LNode(4);
        list.next.next.next.next = new LNode(5);
        list.next.next.next.next.next = new LNode(6);
        list.next.next.next.next.next.next = new LNode(7);
        
        Node root = ListToTree(list);
        TreeTraversals.inOrder(root);

    }

}
