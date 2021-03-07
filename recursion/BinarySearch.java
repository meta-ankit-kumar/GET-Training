package recursion;

import java.util.Scanner;

public class BinarySearch {
	static int arraySortedOrNot(int arr[], int n)
    {
        // If the array has only one element then that array is already sorted
        if (n == 1 || n == 0)
            return 1;
 
        // Compare n-1 element with n-2 element if the latter is greater or equal then the these elements can
        // be considered as sorted
        if (arr[n - 1] < arr[n - 2])
            return 0;
 
        // Last pair was sorted
        // Keep on checking
        return arraySortedOrNot(arr, n - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the elements of the array");
		for(int i=0; i<size; i++){
			arr[i] = sc.nextInt();
		}
		int choice = 1;
		if(arraySortedOrNot(arr, arr.length) != 1){
			System.out.println("Array entered by the user is not sorted.So its needs to be sorted");
			arr = Search.sort(arr);
			System.out.println("Array elements after sorting are following");
			for(int i=0; i<arr.length; i++){
				System.out.println(arr[i] + " ");
			}
		}
			
		while(choice == 1){
			System.out.println("Enter the value to be searched");
			int value = sc.nextInt();
			int result;
			result = Search.binarySearch(arr, 0, arr.length-1, value);
			System.out.println("Results using Linear Search are following:");
			if(result != -1)
				System.out.println("Element found at "+ result + " index(0 Based Indexing)");
			else
				System.out.println("Element not found");
			System.out.println("Enter 1 to continue. Any other integer key to exit");
			choice = sc.nextInt();
		}
		sc.close();
	}

}
