package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchingJunitTesting {
	//Testing Recursive Linear Search when the given value is present in the list
	@Test
	public void linearSearchPositiveTest() {
		int arr[] = {1, 5, 6, 7, 2};
		int value = 6;
		int expected = 2;
		int actual = Search.recLinearSearch(arr, 0, arr.length-1, value);
		assertEquals(expected, actual);
	}
	//Testing Recursive Linear Search when the given value is not present in the list
	@Test
	public void linearSearchNegativeTest(){
		int arr[] = {1, 5, 6, 9, 1};
		int value = 7;
		int expected = -1;
		int actual = Search.recLinearSearch(arr, 0, arr.length-1, value);
		assertEquals(expected, actual);
	}
	//Testing Recursive Linear Search with more values
	@Test
	public void linearSearchTest(){
		int arr[] = {4, 7, 1, 9, 0};
		int input[] = {1, 4, 7, 0, 9, 11};
		int expecteds[] ={2, 0, 1, 4, 3, -1};
		int actuals[] = new int[expecteds.length];
		for(int i=0; i<expecteds.length; i++)
			actuals[i] = Search.recLinearSearch(arr, 0, arr.length-1, input[i]);
		assertArrayEquals(expecteds, actuals);
	}
	/*Testing Recursive Linear Search when duplicate elements are present. It is supposed to return
	 * the first occurrence of the duplicate element which is closer to either left side or right side 
	*/
	@Test
	public void linearSearchDuplicateTest(){
		int arr[] = {1, 7, 8, 1, 9, 8};
		int input[] = {1, 8};
		int expecteds[] ={0, 5};
		int actuals[] = new int[expecteds.length];
		for(int i=0; i<expecteds.length; i++)
			actuals[i] = Search.recLinearSearch(arr, 0, arr.length-1, input[i]);
		assertArrayEquals(expecteds, actuals);
	}
	@Test
	public void	binarySearchPositiveTest() {
		int arr[] = {1, 5, 6, 7, 9};
		int value = 6;
		int expected = 2;
		int actual = Search.binarySearch(arr, 0, arr.length-1, value);
		assertEquals(expected, actual);
	}
	//Testing Recursive Binary Search when the given value is not present in the list
	@Test
	public void binarySearchNegativeTest(){
		int arr[] = {1, 5, 6, 9, 11};
		int value = 7;
		int expected = -1;
		int actual = Search.binarySearch(arr, 0, arr.length-1, value);
		assertEquals(expected, actual);
	}
	//Testing Recursive Linear Search with more values
	@Test
	public void binarySearchTest(){
		int arr[] = {1, 2, 3, 6, 7, 9, 11, 20};
		int input[] = {1, 4, 7, 0, 9, 11};
		int expecteds[] ={0, -1, 4, -1, 5, 6};
		int actuals[] = new int[expecteds.length];
		for(int i=0; i<expecteds.length; i++)
			actuals[i] = Search.binarySearch(arr, 0, arr.length-1, input[i]);
		assertArrayEquals(expecteds, actuals);
	}
}
