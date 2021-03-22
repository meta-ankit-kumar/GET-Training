/*
 *Define the queue interface and implement it using an array.
 *The queue would support methods to add an item to a queue,
 *delete an item from the queue, check whether the queue is empty,
 *check whether the queue is full. 
*/
package stackQueueHashing;
//Simple queue (Not circular)
public class SimpleQueue {
	private int front = -1;
	private int rear = -1;
	private int size;
	private int arr[];
	/**
	 * Constructor to declare array which will act as a queue
	 * @param s Size of the queue
	 */
	public SimpleQueue(int s){
		//
		arr = new int[s];
		//System.out.println(this.arr.length);
		size = s;
	}
	/**
	 * Add a particular element at the rear end of the queue
	 * @param value Element that is going to be added
	 */
	public void enque(int value){
		if(this.rear == size-1){
			throw new IllegalStateException("Overflow Condition. Queue is full");
		}
		if(this.rear == -1 && this.front == -1){
			this.rear += 1;
			this.front += 1;
			this.arr[rear] = value;
		}
		else{
			this.arr[++this.rear] = value;
		}
		System.out.println("Item is added successfully");
	}
	public void printQueue(){
		int i;
		if(this.front == -1 && this.rear == -1)
			System.out.println("Queue is empty");
		else{
			System.out.print("QUEUE: ");
			for(i=this.front; i<=rear; i++)
				System.out.print(this.arr[i] + "  ");
		}
		System.out.println();
	}
	public int deque(){
		if(this.front == -1 && this.rear == -1){
			throw new IllegalStateException("Underflow Condition. Queue is empty");
		}
		int result = this.arr[this.front];
		if(this.front == this.rear){
			this.front = this.rear = -1;
		}
		else{
			front++;
		}
		return result;
	}
	public boolean checkEmpty(){
		if(this.front == -1 && this.rear == -1)
			return true;
		else
			return false;
	}
	public boolean checkFull(){
		if(this.rear == this.size -1 )
			return true;
		else
			return false;
	}

}
