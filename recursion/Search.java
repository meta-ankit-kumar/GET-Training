package recursion;

import java.util.Scanner;

public class Search {
	/**
	 * Searches a particular element in the array with the help of Recursive Linear Search
	 * @param arr Array from which the element is going to be searched
	 * @param left Lower bound of the array
	 * @param right Upper bound of the array
	 * @param value Value that is going to be searched
	 * @return If the value is present then returns the index of that value otherwise -1
	 */
	static int recLinearSearch(int arr[], int left, int right, int value){ 
         if (right < left) 
            return -1; 
         if (arr[left] == value) 
            return left; 
         if (arr[right] == value) 
            return right; 
         return recLinearSearch(arr, left+1, right-1, value); 
    } 
	
	static int binarySearch(int arr[], int left, int right, int value){
		int mid = (left + right)/2;
		if(left > right)
			return -1;
		if(arr[mid] == value)
			return mid;
		else if(arr[mid] > value)
			return binarySearch(arr, left, mid-1, value);
		else
			return binarySearch(arr, mid+1, right, value);
	}
	public static int[] sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
