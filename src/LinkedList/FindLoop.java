package LinkedList;

/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 * Created by jp on 5/26/16.
 */
public class FindLoop {
    private static Node findLoop(Node head) {
        if(head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        list.next.next.next.next.next = new Node(6);
        list.next.next.next.next.next.next = new Node(7);

        Node loop = new Node(100);
        list.next.next.next.next.next.next.next = loop;
        loop.next = list.next.next.next;

        Node result = findLoop(list);
        if(result == null) {
            System.out.println("No Loop exists!");
        } else {
            System.out.println(result.data);
        }
    }
}
