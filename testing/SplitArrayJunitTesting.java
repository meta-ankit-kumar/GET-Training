package testing;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SplitArrayJunitTesting {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	@Test
	public void test() {
		int arr[] = {1, 2, 3};
		int length = arr.length;
		int expected = SplitArray.arraySplit(arr, length);
		int actual = 2;
		assertEquals(expected, actual);
	}
	
	@Test
	public void emptyArrayTest() {
		int arr[] = {};
		int length = arr.length;
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		thrown.expectMessage("Array is empty");
		SplitArray.arraySplit(arr, length);
	}
	
	@Test
	public void test1() {
		int arr[] = {1 , 2 , 3 , 4 , 5 , 5};
		int arr1[] = {2, 1, 1, 2, 1};
		int arr2[] = {10, 10};
		int expecteds[] = {4, -1, 1};
		int actuals[] = {SplitArray.arraySplit(arr, arr.length), SplitArray.arraySplit(arr1, arr1.length), SplitArray.arraySplit(arr2, arr2.length)};
		assertArrayEquals(expecteds, actuals);
	}
}
