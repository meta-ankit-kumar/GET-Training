package testing;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FixXYJunitTesting {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test1() {
		int arr[] = {5, 4, 9, 4, 9, 5};
		int expecteds[] = {9, 4, 5, 4, 5, 9};
		int length = arr.length;
		int x = 4;
		int y = 5;
		int actuals[] = FixXY1.rearangeArray(arr, length, x, y);
		assertArrayEquals(expecteds, actuals);
	}
	@Test
	public void test() {
		int arr[] = {5, 4, 9, 4, 9, 5};
		int expecteds[] = {4, 4, 9, 5, 9, 5};
		int length = arr.length;
		int x = 9;
		int y = 5;
		int actuals[] = FixXY1.rearangeArray(arr, length, x, y);
		assertArrayEquals(expecteds, actuals);
		
	}
	
	@Test
	public void testEmptyArray() {
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		//expecting a particular message
        thrown.expectMessage("Array is empty");
		int arr[] = {};
		int length = arr.length;
		int x = 4;
		int y = 5;
		FixXY1.rearangeArray(arr, length, x, y);
		
	}
	
	@Test
	public void xAtLastIndex(){
		thrown.expect(IllegalStateException.class);
		//expecting a particular message
        thrown.expectMessage("X is the at the last Index");
       
		int arr[] = {3,2,4,7,5,3,4,5,5,4};
		int length = arr.length;
		int x = 4;
		int y = 5;
		FixXY1.rearangeArray(arr, length, x, y);
	}
	@Test 
	public void adjacentX(){
		thrown.expect(IllegalStateException.class);
		//expecting a particular exception message
		thrown.expectMessage("Two Adjacent X values are there");
		int arr[] = {5, 4, 4, 7, 8, 5};
		int length = arr.length;
		int x = 4;
		int y = 5;
		FixXY1.rearangeArray(arr, length, x, y);
	}
	@Test
	public void unequalCountXY(){
		thrown.expect(IllegalStateException.class);
		//Expecting a particular error message
		thrown.expectMessage("Unequal number of X and Y");
		int arr[] = {5, 4, 7, 8, 5};
		int length = arr.length;
		int x = 4;
		int y = 5;
		int result[] = FixXY1.rearangeArray(arr, length, x, y);
		for(int i=0; i<length; i++)
			System.out.println(result[i]);
	}
}
