package testing;
import java.util.*;
public class Clump {
	/**
	 * Calculates the number of clumps in the array
	 * @param arr Array from which number of clumps to be calculated
	 * @param length Length of the array
	 * @return number of clumps
	 * @throws ArrayIndexOutOfBoundsException If user passes empty array then this function throws this exception
	 */
	static int countClumps(int arr[], int length)throws ArrayIndexOutOfBoundsException{
		int count = 0;
		// If array is empty throw Exception with a meaningful message
		if(length == 0)
				throw new ArrayIndexOutOfBoundsException("Array is empty");
		// Outer loop to traverse the elements from 0 to length-2(Both Inclusive)
		for(int i=0; i<length-1; i++){
			// To keep track of a clump. If it is true then a clump is present otherwise not
			boolean flag = false;
			//check for the clumps until we find the element that is not equal to its next element
			while(i<length-1 && arr[i] == arr[i+1]){
				flag = true;
				i++;
			}
			// increment count variable in case the clump was found
			if(flag)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
