package stackQueueHashing;

import java.util.Scanner;

public class SimpleQueueTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter the size of the queue");
			try{
				size = Integer.parseInt(sc.nextLine());
				if(size <= 0)
					throw new Exception("Size should be a positive number");
				break;
			}
			catch(Exception e){
				System.out.println("Please enter the correct size.." + e.getMessage());
			}
		}
		SimpleQueue q = new SimpleQueue(size);
		while(true){
			System.out.println("Please choose from the following options:");
			System.out.println("1. Add an item to the queue");
			System.out.println("2. Remove an item from the queue");
			System.out.println("3. Check whether the queue is empty or not");
			System.out.println("4. Check whether the queue is full or not");
			System.out.println("5. Exit");
			int choice;
			System.out.println("Please enter your choice");
			try{
				choice = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e){
				System.out.println("Please enter the correct choice");
				continue;
			}
			boolean doBreak = false;
			switch (choice) {
			case 1:
				int value;
				System.out.println("Enter the Value to be added");
				try{
					value = Integer.parseInt(sc.nextLine());
				}
				catch(Exception e){
					System.out.println("Please enter the correct value");
					continue;
				}
				try{
					q.enque(value);
					q.printQueue();
				}
				catch(Exception e){
					System.out.println("Unsuccessful.." + e.getMessage());
					continue;
				}
				break;
			case 2:
				try{
					System.err.println("Element:"+q.deque()+" is deleted from the queue");
					q.printQueue();
				}
				catch(Exception e){
					System.out.println("Unsuccessful.." + e.getMessage());
					continue;
				}
				break;
			case 3:
				System.out.println(q.checkEmpty());
				break;
			case 4:
				System.out.println(q.checkFull());
				break;
			case 5:
				doBreak = true;
				break;
			default:
				System.out.println("Please enter the correct choice");
				break;
			}
			if(doBreak)
				break;
		}
		sc.close();
	}


}
