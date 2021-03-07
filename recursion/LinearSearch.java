package recursion;
import java.util.Scanner;

public class LinearSearch {
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
		while(choice == 1){
			System.out.println("Enter the value to be searched");
			int value = sc.nextInt();
			int result;
			result = Search.recLinearSearch(arr, 0, arr.length-1, value);
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
