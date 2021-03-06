package testing;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MirrorJunitTesting {
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test() {
		int arr[] = {1, 2, 3, 8, 9, 3, 2, 1};
		int size = arr.length;
		int expecteds = 3;
		int actuals = Mirror.maxMirror(arr, size);
		assertEquals(expecteds, actuals);
	}
	
	@Test
	public void testOneLengthMirror() {
		int arr[] = {9, 8 , 6, 4, 7, 2, 1};
		int size = arr.length;
		int expecteds = 1;
		int actuals = Mirror.maxMirror(arr, size);
		assertEquals(expecteds, actuals);
	}
	@Test
	public void combinedTest() {
		int arr1[] = {7, 1, 4, 9, 7, 4, 1};
		int arr2[] = {1, 2, 1, 4};
		int arr3[] = {1, 4, 5, 3, 5, 4, 1};
		int actual1 = Mirror.maxMirror(arr1, arr1.length);
		int actual2 = Mirror.maxMirror(arr2, arr2.length);
		int actual3 = Mirror.maxMirror(arr3, arr3.length);
		int expecteds[] = {2, 3, 7};
		int actuals[] = {actual1, actual2, actual3};
		assertArrayEquals(expecteds, actuals);
	}
	@Test
	public void emptyArrayTest(){
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		// If a exception of this particular message has occurred then only this test case will pass otherwise not
		thrown.expectMessage("Array is empty");
		int arr[] = {};
		int size = arr.length;
		Mirror.maxMirror(arr, size);
	}

}
