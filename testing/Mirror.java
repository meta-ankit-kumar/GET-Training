package testing;

public class Mirror {
	/**
	 * To find the largest mirror section in the array
	 * @param arr Array which may contain mirror section
	 * @param size Size of the array
	 * @return the size of the largest mirror section found in the input array.
	 */
	public static int maxMirror(int[] arr, int size){
		if(size == 0)
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		int length, maxLength = 0;
		//Left pointer will take care of left part of mirror. Means it accesses mirror elements from beginning .
		//Right Pointer will take care of right part of mirror. Means it accesses mirror elements from end .
		int leftPointer, rightPointer;
		for(int i = 0; i < size; i++)
		{
			leftPointer = i;
			rightPointer = lastIndexOf(arr, arr[i], size - 1);
			while(rightPointer != -1)
			{	
				// Initially the length variable will be initialized to zero
				length = 0;
				
				leftPointer = i;
				do
				{
					leftPointer++;
					rightPointer--;
					length++;
				}	while(leftPointer < size && rightPointer >= 0 && arr[leftPointer] == arr[rightPointer]);
				if(length > maxLength)
					maxLength = length;
				rightPointer = lastIndexOf(arr, arr[i], rightPointer);
			}
		}
		return maxLength;
	}
	/**
	 * Helper function for maxMirror. It will find last index(lesser than or equals to Right Pointer) of a particular value
	 * @param nums Original array which was passed in maxMirror function
	 * @param value Value of current Index in maxMirror function
	 * @param index position of Right Pointer in maxMirror Function
	 * @return index value
	 */
	public static int lastIndexOf(int[] nums, int value, int index)
	{
		for(; index >= 0; index--)
		{
			if(nums[index] == value)
				return index;
		}
		return -1;
	}
}
