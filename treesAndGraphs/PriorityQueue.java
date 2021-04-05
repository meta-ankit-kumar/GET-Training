package treesAndGraphs;
/**
 * Class which implements priority queue
 * @author ankit.kumar_metacube
 *
 */
public class PriorityQueue {
	//Array which will contain priority queue nodes
	private Job[] queue;
	//rear pointer of the queue
    private int rear ;
    //front pointer of the queue
    private int front ;
    //size of the queue
    private int size;
    
    
    /**
     * Initialize Priority Queue
     * @param size int, size of Queue
     */
    public PriorityQueue(int size) {
    	this.size = size;
        queue = new Job[size];
        rear = -1;
        front = -1;
	}
    
    
    /**
     * method to add  job (A priority queue node) in the queue
     * @param job Job, job to be added 
     * @return true if added, otherwise false 
     */
	public boolean enqueue(Job job) throws AssertionError {
		if(job == null){
			throw new AssertionError("job cannot be null");
		}
		if(!isFull()){
			if(this.rear == -1){
				this.front = 0;
				this.rear = 0;
				this.queue[rear] = job;
            }
			else{
	            int pos = -1;
	            //find the correct position of the node to be inserted
	            if(this.front <= this.rear){
	            	for(int index = this.front; index<= this.rear ; index++){
	                	if(job.getPriority() > this.queue[index].getPriority()){
	                		pos = index;
	                		break;
	                	}
	                }
	            	if(pos != -1){
	                    for(int index = this.rear; index >= pos; index--)	{
	                    	this.queue[(index + 1) % this.size] = this.queue[index];
	                    }
	                    this.queue[pos] = job;
	                    this.rear = (this.rear + 1) % this.size;
	                }
	                else{
	                	this.rear = (this.rear + 1) % this.size;
	                	this.queue[rear] = job;   
	                }
	            }	
	            else{
	            	for(int index = this.front; index<= this.size - 1; index++){
	                	if(job.getPriority() > this.queue[index].getPriority()){
	                		pos = index;
	                		break;
	                	}
	                }
	            	if(pos == -1){
	            		for(int index = 0; index <= this.rear; index++){
	                    	if(job.getPriority() > this.queue[index].getPriority()){
	                    		pos = index;
	                    		break;
	                    	}
	                    }
	            	}
	            	if(pos != -1){
	                    for(int index = this.rear; index>= pos && index >=0 ; index--)	{
	                    	this.queue[(index + 1) % this.size] = this.queue[index];
	                    }
	                    for(int index = pos; index <= this.size -1 ; index--)	{
	                    	this.queue[(index + 1) % this.size] = this.queue[index];
	                    }
	                    this.rear = (this.rear + 1) % this.size;
	                    this.queue[pos] = job;
	                }
	                else{
	                	this.rear = (this.rear + 1) % this.size;
	                	this.queue[rear] = job;   
	                }
	            }
	        }
		}
		//in-case the queue is full
        else
            throw new AssertionError("The queue is full!");
            
        return true;
        
	}

	
	/**
     * method to remove an element from the queue
     * @return Job, the removed Job
     */
	public Job dequeue() throws AssertionError {
		Job job = null;
        //if the queue is not empty then we only need to increment front and rear pointer because the queue is already sorted 
		// by the priority
        if(!isEmpty()){
            if(this.front == this.rear){
                job = this.queue[this.front];
                this.front = -1;
                this.rear = -1;
            }
            else{
                job = this.queue[this.front];
                this.front = (this.front + 1) % this.size;
            }
        }
        else
            throw new AssertionError("The queue is empty!");
        
        return job;
	}

	
	/**
     * method to check if the queue is empty
     * @return boolean, true if Empty otherwise False
     */
	public boolean isEmpty() {
		
		boolean isEmpty = false;
        
        if(rear == -1 && front == -1)
            isEmpty = true;
        
        return isEmpty;
	}

	
	/**
     * method to check if the queue is full
     * @return boolean, true if Full otherwise false
     */
	public boolean isFull() {
		return ((this.rear + 1) % this.size == this.front);
	}

	
	
}
