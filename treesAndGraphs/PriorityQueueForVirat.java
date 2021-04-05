package treesAndGraphs;

/**
 * Class for priority queue
 * @author ankit.kumar_metacube
 *
 */
public class PriorityQueueForVirat {

	public Bowler[] queue;
    public int rear ;
    public int front ;
    private int size;
    
    
    /**
     * Initialize Priority Queue
     * @param size int, size of Queue
     */
    public PriorityQueueForVirat(int size) {
    	this.size = size;
        queue = new Bowler[size];
        rear = -1;
        front = -1;
	}
    
    
    /**
     * method to add  Bowler in the queue
     * @param bowler Bowler, bowler to be added 
     * @return true if added, otherwise false 
     */
	public boolean enqueue(Bowler bowler) throws AssertionError {
		if(bowler == null){
			throw new AssertionError("bowler cannot be null");
		}
		if(!isFull()){
			if(this.rear == -1){
				this.front = 0;
				this.rear = 0;
				this.queue[rear] = bowler;
            }
			else{
	            int pos = -1;
	            if(this.front <= this.rear){
	            	for(int index = this.front; index<= this.rear ; index++){
	                	if(bowler.getNoOfBallsLeft() > this.queue[index].getNoOfBallsLeft()){
	                		pos = index;
	                		break;
	                	}
	                }
	            	if(pos != -1){
	                    for(int index = this.rear; index >= pos; index--)	{
	                    	this.queue[(index + 1) % this.size] = this.queue[index];
	                    }
	                    this.queue[pos] = bowler;
	                    this.rear = (this.rear + 1) % this.size;
	                }
	                else{
	                	this.rear = (this.rear + 1) % this.size;
	                	this.queue[rear] = bowler;   
	                }
	            }	
	            else{
	            	for(int index = this.front; index<= this.size - 1; index++){
	                	if(bowler.getNoOfBallsLeft()> this.queue[index].getNoOfBallsLeft()){
	                		pos = index;
	                		break;
	                	}
	                }
	            	if(pos == -1){
	            		for(int index = 0; index <= this.rear; index++){
	                    	if(bowler.getNoOfBallsLeft()> this.queue[index].getNoOfBallsLeft()){
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
	                    this.queue[pos] = bowler;
	                }
	                else{
	                	this.rear = (this.rear + 1) % this.size;
	                	this.queue[rear] = bowler;   
	                }
	            }
	        }
		}
        else
            throw new AssertionError("The queue is full!");
            
        return true;
        
	}

	
	/**
     * method to remove an Bowler from the queue
     * @return Bowler, the removed Bowler
     */
	public Bowler dequeue() throws AssertionError {
		Bowler bowler= null;
        
        if(!isEmpty()){
            if(this.front == this.rear){
                bowler = this.queue[this.front];
                this.front = -1;
                this.rear = -1;
            }
            else{
                bowler = this.queue[this.front];
                this.front = (this.front + 1) % this.size;
            }
        }
        else
            throw new AssertionError("The queue is empty!");
        
        return bowler;
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
