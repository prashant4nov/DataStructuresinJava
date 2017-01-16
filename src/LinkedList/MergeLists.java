
public class MergeLists {
	public static Node mergeLists(Node l1, Node l2) {
		
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		if(l1.data<l2.data) {
			l1.next = mergeLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeLists(l1, l2.next);
			return l2;
		}
	}
	
	public static void printList(Node head) {
		if(head==null) return;
		Node tmp = head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
	}
	public static void main(String[] args) {
		Node l1 = new Node(1);
		l1.next = new Node(4);
		l1.next.next = new Node(7);
		
		Node l2 = new Node(3);
		l2.next = new Node(5);
		l2.next.next = new Node(11);
		
		Node head = mergeLists(l1, l2);
		printList(head);
	}

}
