package treesAndGraphs;

/**
 * Class which represents Node of a priority queue
 * @author ankit.kumar_metacube
 *
 */
public class Job {

	final int value;
	final int priority;
	
	/**
	 * Initialize Job 
	 * @param value int Value of the node
	 * @param priority int Priority of the node
	 */
	public Job(int value, int priority) {
		
		this.value = value;
		this.priority = priority;
	}

	/**
	 * Get value of a priority queue node
	 * @return int, value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * get Priority of the priority queue node
	 * @return int, priority value
	 */
	public int getPriority() {
		return priority;
	}
	
	
}
