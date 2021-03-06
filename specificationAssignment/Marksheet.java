package specificationAssignment;
import java.util.*;
public class Marksheet {
	/**
	 * Computer the average of all grades
	 * @param grades Array that contains grades. Each has value between 0 and 100 both inclusive
	 * @param n Number of students
	 * @return Average float value of all graded rounded upto 2 decimal places
	 */
	public static float averageGrade(int[] grades,int n) throws ArithmeticException {
		float sum=0,average;
		for(int i=0; i<n; i++)
			sum+=grades[i];
		try{
		average = sum/n;
		//logic to round off the float number up-to 2 decimal digits
		average = Math.round(average*100.0)/(float)100.0;
		}catch(ArithmeticException e){
			average=0;
			System.out.println(e);
		}
		return average;
	}
	/**
	 * Computer the Maximum of all grades
	 * @param grades Array that contains grades. Each has value between 0 and 100 both inclusive
	 * @param n Number of students
	 * @return Maximum Grade among all the grades
	 */
	public static int maximumGrade(int[] grades,int n){
		int maxGrade=0;
		for(int i=0; i<n; i++)
			//each  time maxGrade will contain the maximum of his previous value and current input value and update it.
			maxGrade = Math.max(maxGrade, grades[i]);
		return maxGrade;
	}
	/**
	 * Computer the Minimum of all grades
	 * @param grades Array that contains grades. Each has value between 0 and 100 both inclusive
	 * @param n Number of students
	 * @return Minimum Grade among all the grades
	 */
	public static int minimumGrade(int[] grades,int n){
		int minGrade=0;
		for(int i=0; i<n; i++)
			//updating the minGrade value 
			minGrade = Math.min(minGrade, grades[i]);
		return minGrade;
	}
	/**
	 * Calculates the passing percentage.
	 * @param grades Array that contains grades. Each has value between 0 and 100 both inclusive
	 * @param n number of students
	 * @return floating value of pass percentage rounded up-to 2 decimal places
	 * @throws ArithmeticException In case user tricked the program to pass 0 as the number of students
	 */
	public static float passPercentage (int[] grades, int n)throws ArithmeticException {
		int studentPass = 0;
		float percentage;
		try{
		for(int i=0; i<n; i++){
			if(grades[i]>=40)
				studentPass += 1;
		}
		percentage = ((float)studentPass / (float)n)*100;
		//rounding off up-to 2 decimal digits
		percentage = Math.round(percentage*100.0)/(float)100.0;
		}
		catch(ArithmeticException e){
			percentage=0;
			System.out.println(e);
			
		}
		return percentage;
	}
	public static void main(String[] args) {
		int noOfStudent,choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose from the following Options:");
		System.out.println("1. Average of all grades");
		System.out.println("2. Maximum of all grades");
		System.out.println("3. Minimum of all grades");
		System.out.println("4. Percentage of students passed. Passing Grade:40");
		System.out.println("5. Exit");
		System.out.println("Please enter your choice");
		choice = sc.nextInt();
		if(choice>=1 && choice<=4){
		System.out.println("Enter number of Students:");
		noOfStudent = sc.nextInt();
		//Handling the situation when user enters zero as the number of students
		if(noOfStudent==0){
			System.out.println("Number of students should be greater than 0");
			System.exit(0);
		}
		int grades[] = new int[noOfStudent];
		System.out.println("Enter grade of each student(Between 0 and 100 both inclusive)");
		for(int i=0; i<noOfStudent; i++){
			int input = sc.nextInt();
			if(input>=0 && input<=100)//check the value of grade if it is acceptable or not
				grades[i] = input;
			else{
				System.out.println("Please enter the Grade between 0 and 100 both inclusive");
				System.exit(0);
			}
		}
		switch (choice) {
		case 1:
			System.out.println("Average grade is:"+averageGrade(grades, noOfStudent));
			break;
		case 2:
			System.out.println("Maximum grade is:"+maximumGrade(grades, noOfStudent));	
			break;
		case 3:
			System.out.println("Minimum grade is:"+minimumGrade(grades, noOfStudent));	
			break;
		case 4:
			System.out.println("Percentage of students passed:"+passPercentage(grades, noOfStudent));	
			break;
		default:
			break;
		}
		}
		sc.close();
	}

}
