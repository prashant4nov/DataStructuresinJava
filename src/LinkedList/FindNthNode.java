package LinkedList;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 * Created by jp on 5/25/16.
 */
public class FindNthNode {
    private static Node findNthNode(Node head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        Node curr = head;
        Node prev = head;
        int count=0;
        while(curr != null && count<n) {
            curr=curr.next;
            count++;
        }

        if (curr == null && count<n) {
            return null;
        }
        while(curr != null) {
            curr=curr.next;
            prev=prev.next;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        list.next.next.next.next.next = new Node(6);
        list.next.next.next.next.next.next = new Node(7);
        int pos = 4;
        Node res = findNthNode(list, pos);
        if(res != null) {
            System.out.println(res.data);
        } else {
            System.out.println("Nth node not found!");
        }
    }
}
