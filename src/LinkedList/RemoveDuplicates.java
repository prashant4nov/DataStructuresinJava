package LinkedList;
import java.util.HashMap;

/**
 * Write code to remove duplicates from an unsorted linked list. Check using hashset.
 * Created by jp on 5/25/16.
 */

public class RemoveDuplicates {

    /**
     * @param Node head is the head of the linked list
     * @return: Node head of linked list
     */
    public static Node deleteDuplicates(Node head) {
        if(head == null) return head;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        Node curr = head;
        map.put(curr.data, true);
        while(curr.next!=null) {
            if(map.containsKey(curr.next.data)) {
                curr.next=curr.next.next;
            } else {
                map.put(curr.next.data, true);
                curr=curr.next;
            }
        }
        return head;
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
        list.next = new Node(12);
        list.next.next = new Node(11);
        list.next.next.next = new Node(11);
        list.next.next.next.next = new Node(12);
        list.next.next.next.next.next = new Node(11);
        list.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List before removing duplicates ");
        printList(list);

        deleteDuplicates(list);

        System.out.println("");
        System.out.println("Linked List after removing duplicates");
        printList(list);

    }
}


