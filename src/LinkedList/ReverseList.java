
public class ReverseList {
	public static void printList(Node head) {
		if(head==null) return;
		Node tmp = head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
	}
	public static Node reverse(Node head) {
		if(head==null) return head;
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	public static void main(String[] args) {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		first.next = second;
		second.next = third;
		printList(first);
		first  = reverse(first);
		printList(first);
	}

}
