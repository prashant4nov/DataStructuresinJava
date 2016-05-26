package LinkedList;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
 * only access to that node
 * Created by jp on 5/25/16.
 */
public class DeleteMiddleNode {
    private static void deleteMiddleNode(Node node) {
        if(node == null || node.next == null) {
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void printList(Node node) {
        Node n = node;
        while(n != null) {
            System.out.print(n.data+" ");
            n=n.next;
        }
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        list.next.next.next.next.next = new Node(6);
        list.next.next.next.next.next.next = new Node(7);

        printList(list);

        deleteMiddleNode(list.next.next.next);

        System.out.println("List after deletion!");
        printList(list);
    }
}
