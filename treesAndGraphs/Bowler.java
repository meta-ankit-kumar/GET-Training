package treesAndGraphs;

/**
 * Class to represent a bowler
 * @author ankit.kumar_metacube
 *
 */
public class Bowler {
	//Id of the bowler
	private int id ;
	//Number of balls left of the bowler
	private int noOfBalls;
	// Static counter
	private static int idCount = 0;
	
	/**
	 * Initialize Bowler
	 * @param noOfBalls int, number of balls left for bowler
	 */
	public Bowler(int noOfBalls){
		this.noOfBalls = noOfBalls;
		Bowler.idCount ++;
		this.id = Bowler.idCount;
	}
	
	/**
	 * Get ID of Bowler
	 * @return int, id 
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Get number of balls left for a bowler
	 * @return int, number of Balls left
	 */
	public int getNoOfBallsLeft(){
		return this.noOfBalls;
	}
}
