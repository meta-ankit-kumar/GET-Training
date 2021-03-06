package testing;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ClumpJunitTesting {
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testEmptyArray() {
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		//expecting a particular messgae
        thrown.expectMessage("Array is empty");
		int arr[] = {};
		int actual = Clump.countClumps(arr,arr.length);
		int expected = 0;
		assertEquals("Testing Empty Array", expected, actual);
	}
	
	@Test
	public void test() {
		int arr[] = {1,2,2,3};
		int actual = Clump.countClumps(arr, arr.length);
		int expected = 1;
		assertEquals("Testing 1 clump present",expected, actual);
	}
	
	@Test
	public void testAllSame() {
		int arr[] = {2,2,2,2,2,2};
		int actual = Clump.countClumps(arr, arr.length);
		int expected = 1;
		assertEquals("Testing When all elements are same",expected, actual);
	}
	
	@Test
	public void testTwoElement() {
		int arr[] = {1,1};
		int actual = Clump.countClumps(arr, arr.length);
		int expected = 1;
		assertEquals("Testing when there two elements",expected, actual);
	}
	
	@Test
	public void testMoreThanOneClump(){
		int arr[] = {1, 2, 2, 3, 4, 4};
		int actual = Clump.countClumps(arr, arr.length);
		int expected = 2;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMoreThanOneClumpSymmetric(){
		int arr[] = {1, 1, 2, 1, 1};
		int actual = Clump.countClumps(arr, arr.length);
		int expected = 2;
		assertEquals(expected, actual);
	}
}
