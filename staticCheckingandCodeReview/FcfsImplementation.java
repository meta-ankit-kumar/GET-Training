package staticCheckingandCodeReview;

import java.util.Scanner;
/**
 * Class which contains method for calculating the turn around time, waiting time and completion time for each process
 * @author ankit.kumar_metacube
 * Sorts the processes according to the arrival time of each process.
 * Finds the maximum waiting time among all processes
 */
public class FcfsImplementation {
	/**
	 * Method to compute completion time of each process
	 * @param array which contains a number of processes with their arrival time and burst time seconds in a two dimensional array.
	 * @param noOfProcess Total number of processes
	 * @param completionTime  Contains completion time of each process
	 */
	public static void calculateCompletionTimeTime(int[][] array , int noOfProcess, int[] completionTime){
		for (int i = 0 ; i < noOfProcess ; i++){
			if (i == 0){
				completionTime[i] = array[i][0] + array[i][1];
			}
			else {
				//If the arrival time of the process is greater than the last
				if (array[i][0] > completionTime[i-1]){
					completionTime[i] = array[i][0] + array[i][1];
				}
				else {
					completionTime[i] = completionTime[i-1] + array[i][1];
				}
			}
		}
		
	}
	
	/**
	 * Method to compute TurnAround time of each process
	 * @param array which contains a number of processes with their arrival time and burst time seconds in a two dimensional array.
	 * @param noOfProcess Total number of processes
	 * @param completionTime Completion time of each process
	 * @param turnAroundTime Turn around time of each process
	 */
	public static void calculateTurnAroundTime(int[][] array , int noOfProcess, int[] completionTime , int[] turnAroundTime){
		for (int i = 0; i < noOfProcess; i++){
			turnAroundTime[i] = completionTime[i] - array[i][0];
		}
		
	}
	
	/**
	 * Method to calculate waiting time of each process
	 * @param array which contains a number of processes with their arrival time and burst time seconds in a two dimensional array.
	 * @param noOfProcess Total number of processes
	 * @param turnAroundTime Turn around time of each process
	 * @param waitingTime Waiting time of each process
	 */
	public static void calculateWaitingTime(int[][] array , int noOfProcess,  int[] turnAroundTime , int[] waitingTime){
		for (int i = 0; i < noOfProcess; i++){
			waitingTime[i] = turnAroundTime[i] - array[i][1];
		}
	}
	
	/**
	 * Method to compute average waiting time
	 * @param noOfProcess Total number of processes
	 * @param waitingTime Waiting time of each process
	 * @return average waiting time
	 */
	public static float calculateAvgWaitingTime(int noOfProcess, int[] waitingTime){
		float average = 0;
		for(int i = 0 ; i < noOfProcess ; i++){
			average += waitingTime[i];
		}
		average /= noOfProcess;
		return average;
	}
	
	/**
	 * Method for finding the maximum  waiting time
	 * @param noOfProcess Total number of processes
	 * @param waitingTime Waiting time of each process
	 * @return maximum waiting time
	 */
	public static int findMaximumWaitingTime(int noOfProcess, int[] waitingTime){
		int maxWaitingTime = 0;;
		for(int i = 0 ; i < noOfProcess ; i++){
			if(waitingTime[i] > maxWaitingTime){
				maxWaitingTime = waitingTime[i];
			}
		}
		return maxWaitingTime;
	
	}
	
	
	public static void main(String[] args){
		
	    Scanner scannerObject = new Scanner(System.in); 
	    int noOfProcess;
	    while(true){
	    	try{
	    		System.out.println("Enter number of process in table: ");
	    	    noOfProcess = Integer.parseInt(scannerObject.nextLine());
	    	    if(noOfProcess <= 0)
	    	    	throw new Exception();
	    	    break;
	    	}
	    	catch(Exception e){
	    		System.out.println("Please enter the positive number of processes");
	    	}
	    }
		int array[][]= new int[noOfProcess][2];
		int completionTime[] = new int[noOfProcess] , turnAroundTime[] = new int[noOfProcess] , waitingTime[] = new int[noOfProcess];
		
		
		
		System.out.println("Enter array with columns arrival time and burst time : ");
		enterMatrixData(scannerObject, array, noOfProcess, 2);
		sortMatrixByArrivalTime(array, noOfProcess );
		
		System.out.println("Array after sorting in order of arrival time: ");
		printMatrix(array, noOfProcess, 2);
		//Method calls to calculate the completion time, turn around time, waiting time of each process
		calculateCompletionTimeTime(array , noOfProcess , completionTime);
		calculateTurnAroundTime(array , noOfProcess , completionTime , turnAroundTime);
		calculateWaitingTime(array, noOfProcess , turnAroundTime , waitingTime);
		//formatting the output in the well format
		System.out.println("Results are following\n");
		System.out.printf("%10s %10s %20s %20s %20s","Arival Time", "Burst Time", "Completion\\Exit Time" , "TurnAround Time" , "Waiting Time" );
		System.out.println();
		for (int i = 0 ; i < noOfProcess ; i++) {
			System.out.printf("%10d %10d %20d %20d %20d",array[i][0] , array[i][1] , completionTime[i] , turnAroundTime[i] , waitingTime[i] );
			System.out.println();
		}
		//calculating average waiting time for each process
		System.out.println("Average Waiting Time for all processes: " + calculateAvgWaitingTime(noOfProcess, waitingTime));
		//calculating the maximum waiting time using average waiting time of each process
		System.out.println("Maximum Waiting Time Period : " + findMaximumWaitingTime(noOfProcess, waitingTime));    
	   }
	
	/**
	 * Method to take matrix input
	 * @param scan Scanner class object
	 * @param matrix Array
	 * @param matrixRow no of rows in matrix
	 * @param matrixCol no of columns in matrix
	 */
	public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
		for (int i = 0; i < matrixRow; i++){
			for (int j = 0; j < matrixCol; j++){
				matrix[i][j] = scan.nextInt();
				}
	        }
	  	 }
	
	
	/**
	 * Method to print the matrix
	 * @param matrix Array which contains data to be printed
	 * @param matrixRow No of rows in the matrix
	 * @param matrixCol No of columns in the matrix
	 */
	public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol){
		 for (int i = 0; i < matrixRow; i++){
			 for (int j = 0; j < matrixCol; j++){
				 System.out.print(matrix[i][j]+"\t");
		         }    
		     System.out.println();
		     }
		  }
	/**
	 * method to sort the matrix in order of arrival time
	 * @param matrix Array which is going to be sorted
	 * @param matrixRow -> no of row in matrix
	 */
	public static void sortMatrixByArrivalTime(int[][] matrix, int matrixRow){
		int tempVariableForSort;
		 for (int i = 0; i < matrixRow; i++){
			 for (int j = 0; j < matrixRow-(i+1); j++){
				 if (matrix[j][0] > matrix[j+1][0]){
					 tempVariableForSort = matrix[j][0];
					 matrix[j][0] = matrix[j+1][0];
					 matrix[j+1][0] = tempVariableForSort;
					 tempVariableForSort = matrix[j][1];
					 matrix[j][1] = matrix[j+1][1];
					 matrix[j+1][1] = tempVariableForSort;
				 }
		     	 }    
		     }
		  }
}
