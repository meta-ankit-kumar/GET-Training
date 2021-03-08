package dataStructures;
import java.util.Scanner;

public class RotateList {
	public static LinkedList listRotate(LinkedList list1, int L, int R, int N){
			LinkedList list = list1;
			int size = list.calculateSize();
			if (list.head == null || list.head.next == null){
				System.out.println("Linked List is either empty or it has only two elements");
				System.exit(0);
			}
			if(L>R){
				System.out.println("L should be lesser or equal to R");
				System.exit(0);
			}
			// L and R should be in the range(0,lengthOfList)
			if (L<0 || R<0 || L >size  || R > size ) {
				System.out.println("Not Possible. L and R should be greater than zero and less than the size of the list ");
				System.exit(0);
			}
			if( N <= 0 ){
				System.out.println("N must not be greater than zero");
				System.exit(0);
			}
			// If N is greater than the specified limit then with modulo operator take it to given range i.e (R - L + 1)
			if (N >= (R-L+1)){
				N = N % (R-L+1);
			}
			
			int len = 1;
			LinkedList.Node beforeStartNode = null , startNode = null , afterEndNode = null , endNode = null , currNode = list.head;
			
			while(currNode != null || len == R ){
				if (L == 1 && len == 1 ){
					startNode = currNode;
				}
				if (len == L - 1 ){
					beforeStartNode = currNode;
					startNode = currNode.next;
				}
				if (len == R){
					endNode = currNode;
					afterEndNode = currNode.next;
				}
				len += 1;
				currNode = currNode.next;
			}

			endNode.next = startNode;
			int noOfRotation = R - L - N + 1;

			while( noOfRotation -- > 0){
				endNode = endNode.next; 
				startNode = startNode.next;
			}
			if (L != 1){
				beforeStartNode.next = startNode;
				endNode.next = afterEndNode;
			}
			else {
				list.head = startNode;
				endNode.next = afterEndNode;
			}
			return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		System.out.println("Enter the number of nodes that you want to insert");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		LinkedList list = new LinkedList();
		System.out.println("Enter the elements of Linked List");
		for(int i=1; i<=n; i++){
			try{
				int data = sc.nextInt();
				list.insertAtLast(data);
			}
			catch(Exception e){
				System.out.println(e);
				break;
			}
		}
		list.printLinkedList();
		int choice;
		System.out.println("Enter 1 to exit and 2(or any other Integer) to continue");
		choice = sc.nextInt();
		while(choice != 1){
		int L, R, N;
		System.out.println("Please enter value of L(Assume indexing starts from 1). L should be greater than zero and less than the size of list");
		L = sc.nextInt();
		System.out.println("Please enter the value of R(Assume indexing starts from 1). R should be greater than zero  and less than size of the list. R>=L");
		R = sc.nextInt();
		System.out.println("Please enter the value of N");
		N = sc.nextInt();
		LinkedList m = listRotate(list, L, R, N);
		System.out.println("Linked List after rotation is");
		m.printLinkedList();
		System.out.println("Enter 1 to exit and 2(or any other Integer) to continue");
		choice = sc.nextInt();
		}
		sc.close();
	}

}
