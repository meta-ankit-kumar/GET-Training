package testing;

public class SplitArray {
	/**
	 * Split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side
	 * @param arr Input array which needs to be checked for splitting
	 * @param length length of the array
	 * @return Return the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1
	 * 
	 */
	public static int arraySplit(int[] arr, int length){
		if(length == 0)
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		int sumBeforeI = 0; // Sum of elements before i including i itself
		int sumOfArray = 0; // Sum of the array
		for(int i=0; i<length; i++){
			sumOfArray += arr[i];
		}
		int sumAfterI = sumOfArray;
		for(int i=0; i<length; i++){
			sumBeforeI += arr[i];
			sumAfterI -= arr[i];
			if(sumBeforeI == sumAfterI)
				return i+1;
			else if(sumBeforeI > sumAfterI)
				return -1;
		}
		return -1;
	}
}
