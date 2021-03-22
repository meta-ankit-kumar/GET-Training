/*
 Address the issue related to queue
 getting full despite unused space in the array by providing circular implementation of the queue.
*/
package stackQueueHashing;
//Simple queue (Not circular)
public class CircularQueue {
	private int front = -1;
	private int rear = -1;
	private int size;
	private int arr[];
	/**
	 * Constructor to declare array which will act as a queue
	 * @param s Size of the queue
	 */
	public CircularQueue(int s){
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
		if(((this.rear +1 ) % this.size) == this.front ){
			throw new IllegalStateException("Overflow Condition. Queue is full");
		}
		if(this.rear == -1 && this.front == -1){
			this.rear += 1;
			this.front += 1;
			this.arr[rear] = value;
		}
		else{
			this.rear = (this.rear + 1) % this.size;
			this.arr[this.rear] = value;
		}
		System.out.println("Item is added successfully");
	}
	/**
	 * Prints the content of the queue
	 */
	public void printQueue(){
		int i = this.front;
		if(this.front == -1 && this.rear == -1)
			System.out.println("Queue is empty");
		else{
			System.out.print("QUEUE: ");
			while(i != this.rear){
				System.out.print(arr[i] + " ");
				i = (i + 1) % this.size;
			}
			System.out.print(arr[this.rear]);
		}
		System.out.println();
	}
	/**
	 * Removes the first element from the queue
	 * @return first element of the queue which is removed by this method
	 */
	public int deque(){
		if(this.front == -1 && this.rear == -1){
			throw new IllegalStateException("Underflow Condition. Queue is empty");
		}
		int result = this.arr[this.front];
		if(this.front == this.rear){
			this.front = this.rear = -1;
		}
		else{
			this.front = (this.front + 1) % this.size;
		}
		return result;
	}
	/**
	 * Checks whether the queue is empty or not
	 * @return true if queue is empty otherwise false
	 */
	public boolean checkEmpty(){
		if(this.front == -1 && this.rear == -1)
			return true;
		else
			return false;
	}
	/**
	 * Checks whether the queue is full or not
	 * @return true if queue is full otherwise false
	 */
	public boolean checkFull(){
		if((this.rear + 1) % this.size == this.front )
			return true;
		else
			return false;
	}

}
