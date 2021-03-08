package dataStructures;

public class LinkedList {
	Node head;// head of list
	Node last;// to keep track of last node of the linked list. It will help in reducing time complexity of other methods
    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        // Constructor to create a new node with data
        Node(int d) {
        	data = d;
        	next = null;
        	}
    }
    /**
     * To insert the element at the end of the list.
     * @param data Data that needs to be inserted
     * @return Linked List with new node added to the end
     */
    public LinkedList insertAtLast(int data){
    	Node newNode = new Node(data);
    	if(this.head == null){
    		this.head = newNode;
    		this.last = newNode;
    	}
    	else{
    		this.last.next = newNode;
    		this.last = newNode;
    	}
    	return this;
    }
    /**
     * To print the Linked List. If it is empty then it will print some message
     */
    public void printLinkedList(){
    	Node currentNode = this.head;
    	if(currentNode == null){
    		System.out.println("Linked List is empty");
    		return ;
    		}
    	System.out.print("Linked List: ");
    	while(currentNode != null){
    		System.out.print(currentNode.data+" ");
    		currentNode = currentNode.next;
    	}
    	System.out.println();
    }
    /**
     * Calculates the size of the linked list
     * @return size of the linked list
     */
    public int calculateSize(){
    	Node traverse = this.head;
    	int size = 0;
    	while(traverse != null){
    		size++;
    		traverse = traverse.next;
    	}
    	return size;
    }
    public static void main(String[] args){
    	LinkedList list = new LinkedList();
    	list.printLinkedList();
    	list.insertAtLast(10);
    	list.printLinkedList();
    	list.insertAtLast(15);
    	list.printLinkedList();
    	list.insertAtLast(25);
    	list.insertAtLast(35);
    	list.insertAtLast(5);
    	list.insertAtLast(115);
    	list.printLinkedList();
    	
    }
}
