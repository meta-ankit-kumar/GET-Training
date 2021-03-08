package dataStructures;


public class LinkedListLoop {
	/**
	 * check whether a there is a loop in the Linked List or not
	 * @param list Linked List from which we are going to find loop
	 * @return boolean value, depends on the presence of loop if not then false otherwise true
	 */
	public static boolean detectLoop(LinkedList list){
		LinkedList.Node slow = list.head;
		LinkedList.Node fast = list.head;
		while(fast != null){
			slow = slow.next;
			if(fast.next == null)
				return false;
			else
				fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		l.head = new LinkedList.Node(32);
		l.head.next = new LinkedList.Node(65);
		l.head.next.next = new LinkedList.Node(98);
		l.head.next.next.next = new LinkedList.Node(100);
		l.head.next.next.next.next = new LinkedList.Node(500);
		//l.head.next.next.next.next = l.head.next.next.next.next;
		System.out.println(LinkedListLoop.detectLoop(l));
		//l.printLinkedList();
	}

}
