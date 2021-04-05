package treesAndGraphs;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing PriorityQueue.java
 * @author ankit.kumar_metacube
 *
 */
public class PriorityQueueTest {

	/**
	 * Test Method to test enqueue and dequeue method of Priority Queue Class
	 */
	@Test
	public void testingEnqueAndDequeOperation() {
		PriorityQueue priorityQueue = new PriorityQueue(4);
		
		assertEquals(true,priorityQueue.enqueue(new Job(1, 3)));
		assertEquals(true,priorityQueue.enqueue(new Job(2, 4)));
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(true,priorityQueue.enqueue(new Job(3, 3)));
		assertEquals(true,priorityQueue.enqueue(new Job(4, 5)));
		assertEquals(true,priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertEquals(1, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(5, priorityQueue.dequeue().getValue());
		
	}
	
	/**
	 * Test Method to test EmptyQueue Exception 
	 */
	@Test(expected = AssertionError.class)
	public void emptyQueueTest(){
		PriorityQueue priorityQueue = new PriorityQueue(4);
		
		assertEquals(true,priorityQueue.enqueue(new Job(1, 3)));
		assertEquals(true,priorityQueue.enqueue(new Job(2, 4)));
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(true,priorityQueue.enqueue(new Job(3, 3)));
		assertEquals(true,priorityQueue.enqueue(new Job(4, 5)));
		assertEquals(true,priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertEquals(1, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(5, priorityQueue.dequeue().getValue());
	}
	
	/**
	 * Test Method to test Queue id Full Exception 
	 */
	@Test(expected = AssertionError.class)
	public void fullQueueTest(){
		PriorityQueue priorityQueue = new PriorityQueue(4);
		
		assertEquals(true,priorityQueue.enqueue(new Job(1, 3)));
		assertEquals(true,priorityQueue.enqueue(new Job(2, 4)));
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(true,priorityQueue.enqueue(new Job(3, 3)));
		assertEquals(true,priorityQueue.enqueue(new Job(4, 5)));
		assertEquals(true,priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(true,priorityQueue.enqueue(new Job(5, 3)));

	}

}
