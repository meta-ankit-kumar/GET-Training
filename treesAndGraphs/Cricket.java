package treesAndGraphs;

import java.util.ArrayList;

/**
 * Class For calculation of Order Bowlers 
 * @author ankit.kumar_metacube
 *
 */
public class Cricket {
	private int noOfBallsArray[];
	private int numberOfBallsViratIsGoingToPlay;
	
	/**
	 * Initialize Cricket Object
	 * @param numberOfBallsViratIsGoingToPlay int, number of balls Virat is going to Play
	 * @param noOfBallsArray int[], array containing number of balls left for each bowler
	 */
	public Cricket(int numberOfBallsViratIsGoingToPlay,int[] noOfBallsArray ) {
		this.numberOfBallsViratIsGoingToPlay = numberOfBallsViratIsGoingToPlay;
		this.noOfBallsArray = noOfBallsArray;
	}
	
	
	/**
	 * Method to get Order of Bowlers
	 * @return ArrayList<Bowler>, lsit of Bowlers in Order 
	 */
	public ArrayList<Bowler> getOrderOfBowler(){
		
		PriorityQueueForVirat priorityQueue = new PriorityQueueForVirat(this.noOfBallsArray.length);
		for(int noOfBalls : this.noOfBallsArray){
			Bowler newBowler = new Bowler(noOfBalls);
			priorityQueue.enqueue(newBowler);
		}
		
		ArrayList<Bowler> orderOfBowlers = new ArrayList<Bowler>();
		
		int numberOfBalls = this.numberOfBallsViratIsGoingToPlay;
		
		
		while(numberOfBalls > 0){
			try{
				Bowler bowlerSelected = priorityQueue.dequeue(); 
				orderOfBowlers.add(bowlerSelected);
				numberOfBalls -= bowlerSelected.getNoOfBallsLeft();
			}catch(AssertionError e){
				throw new AssertionError("Not Enough Bowlers");
			}
		}
		return orderOfBowlers;
	}
}
