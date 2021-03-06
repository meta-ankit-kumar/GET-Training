package testing;

public class FixXY1 {
	/**
	 * Rearrange the array such that every X is immediately followed by Y
	 * @param arr Array which is going to be rearranged
	 * @param length Length of the array
	 * @param x Value of X
	 * @param y Value of Y
	 * @return Returns rearranged array if possible otherwise throws exception
	 */
	static int[] rearangeArray(int[] arr, int length, int x, int y){
		 	int j = 0;
		 	int i;
		 	int countX = 0, countY = 0; 
		 	// If array is empty then throw exception
		 	if(length == 0)
		 		throw new ArrayIndexOutOfBoundsException("Array is empty");
		 	//loop to count number of x and y
		 	for(i=0; i < length; i++){
		 		if(arr[i] == x)
		 			countX += 1;
		 		if(arr[i] == y)
		 			countY += 1;
		 		// If x is occurred at last index then throw exception
		 		if(i == length - 1 && arr[i] == x)
		 			throw new IllegalStateException("X is the at the last Index");
		 		// If there are two adjacent x then throw exception
		 		if( i < length -1 && (arr[i] == x && arr[i+1] == x ))
		 			throw new IllegalStateException("Two Adjacent X values are there");
		 	}
		 	//Throw exception if there is unequal number of x and y
		 	if(countX != countY)
		 		throw new IllegalStateException("Unequal number of X and Y");
			for(i = 0; i < length - 1; i++)
			{
				if(arr[i] == x && arr[i+1] != y)
				{
					for(; !(arr[j] == y && (j == 0 || j > 0 && arr[j-1] != x)); j++);
					arr[j] = arr[i+1];
					arr[i+1] = y;
				}
			}
			return arr;
	}
}
