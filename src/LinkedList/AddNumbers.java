package LinkedList;

/**
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * Created by jp on 5/26/16.
 */
public class AddNumbers {
    private static Node addNumbers(Node l1, Node l2, int carry) {
        if(l1 == null && l2 == null) {
            return null;
        }

        int val = carry;

        if(l1 != null) {
            val +=l1.data;
        }

        if(l2 != null) {
            val += l2.data;
        }

        Node result = new Node(val%10);

        Node next = addNumbers(l1 == null ? null: l1.next,
                               l2 == null ? null: l2.next,
                               val > 9 ? 1: 0);

        result.next = next;
        return result;
    }

    public static void printList(Node node) {
        Node n = node;
        while(n != null) {
            System.out.print(n.data+" ");
            n=n.next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(3);
        l1.next = new Node(1);
        l1.next.next = new Node(5);

        Node l2 = new Node(5);
        l2.next = new Node(9);
        l2.next.next = new Node(2);


        Node result = addNumbers(l1, l2, 0);

        System.out.println("List after addition!");
        printList(result);

    }
}
