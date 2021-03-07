package recursion;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NQueenJunitTesting {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	//this function will test some boards for which NQueen Constraints are satisfied
	@Test
	public void positiveTest() {
		int input[] ={1, 4, 5, 6, 15};
		//here 1 represent that NQueen arrangement is possible
		// We have to type cast boolean to int because JUnit Array Equals function does'nt support boolean array
		int expecteds[] = {1, 1, 1, 1, 1};
		int actuals[] = new int[input.length];
		for(int i=0; i<input.length; i++){
			NQueen q = new NQueen(input[i]);
			actuals[i] = q.nQueen(0) ? 1 : 0;
		}
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void negativeTest() {
		int input[] ={2, 3};
		//here 1 represent that NQueen arrangement is possible
		// We have to type cast boolean to int because JUnit Array Equals function does'nt support boolean array
		int expecteds[] = {0, 0};
		int actuals[] = new int[input.length];
		for(int i=0; i<input.length; i++){
			NQueen q = new NQueen(input[i]);
			actuals[i] = q.nQueen(0) ? 1 : 0;
		}
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void negativeDimension(){
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("Board dimension should be a positive number");
		int dimension = 0;
		NQueen q = new NQueen(dimension);
	}
}
