package LinkedList;
import java.util.HashMap;

/**
 * Write code to remove duplicates from an unsorted linked list. Check using hashset.
 * Created by jp on 5/25/16.
 */

 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}


public class RemoveDuplicates {

    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        ListNode curr = head;
        map.put(curr.val, true);
        while(curr.next!=null) {
            if(map.containsKey(curr.next.val)) {
                curr.next=curr.next.next;
            } else {
                map.put(curr.next.val, true);
                curr=curr.next;
            }
        }
        return head;
    }

    public static void printList(ListNode node) {
        ListNode n = node;
        while(n != null) {
            System.out.print(n.val+" ");
            n=n.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(10);
        list.next = new ListNode(12);
        list.next.next = new ListNode(11);
        list.next.next.next = new ListNode(11);
        list.next.next.next.next = new ListNode(12);
        list.next.next.next.next.next = new ListNode(11);
        list.next.next.next.next.next.next = new ListNode(10);

        System.out.println("Linked List before removing duplicates ");
        printList(list);

        deleteDuplicates(list);

        System.out.println("");
        System.out.println("Linked List after removing duplicates");
        printList(list);

    }
}


