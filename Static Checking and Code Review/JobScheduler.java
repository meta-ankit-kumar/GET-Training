package Assignment2;
import java.util.*;
public class JobScheduler {
	public static void main(String []args){
		ArrayList<Integer> turnAroundArray = new ArrayList<Integer>();//Turn Around Time of all processes
		ArrayList<Integer> waitingTimeArray = new ArrayList<Integer>();//Waiting Time of all processes
		ArrayList<Integer> exitTimeArray = new ArrayList<Integer>();//Exit Time of all processes
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int noOfRows=sc.nextInt();
		System.out.println("Enter the number of columns:");
		int noOfColumns=sc.nextInt();
		int input[][] = new int[noOfRows][noOfColumns];
		int i,j;
		for(i=0;i<noOfRows;i++){
			for(j=0;j<noOfColumns;j++){
				input[i][j]=sc.nextInt();
			}
		}
		System.out.println("Content of the array is:");
		for(i=0;i<noOfRows;i++){
			for(j=0;j<noOfColumns;j++){
				System.out.println(input[i][j]);
			}
		}
		int exitTime=0;//This will contain the exit time for the current process
		int turnAroundTime,waitingTime;
		int arrivalTime,burstTime;
		for(i=0;i<noOfRows;i++){
			arrivalTime=input[i][0];
			burstTime=input[i][1];
			if(input[i][0]<=exitTime){//to check if the process is available or not
				exitTime+=burstTime;//add the burst time to exit time 
			}
			else{
				exitTime=arrivalTime+burstTime;//in case process is not available then simply add the arrival time and burst time..This is exit time for this process
			}
			turnAroundTime=exitTime-arrivalTime;
			waitingTime=turnAroundTime-burstTime;
			turnAroundArray.add(turnAroundTime);
			waitingTimeArray.add(waitingTime);
			exitTimeArray.add(exitTime);
		}
		int count=1;
		float totalTurnAround=0,totalWaiting=0,maxWaiting=0;
		int maxWaitingProcess=1;//Process Number which has maximum waiting time
		for(Integer time:turnAroundArray){
			totalTurnAround+=time;
			System.out.println("Turn Around Time of Process("+count+")is:"+time);
			count+=1;
		}
		int count1=1;
		for(Integer time1:waitingTimeArray){
			totalWaiting+=time1;
			System.out.println("Waiting Time of Process("+count1+")is:"+time1);
			if(maxWaiting<time1){
				maxWaitingProcess=count1;
				maxWaiting=time1;
			}
			count1+=1;
		}
		int count2=1;
		for(Integer time2:exitTimeArray){
			System.out.println("Exit(Completion) Time of Process("+count2+")is:"+time2);
			count2+=1;
		}
		float avgTurnAround=totalTurnAround/(float)noOfRows;
		float avgWaiting=totalWaiting/(float)noOfRows;
		System.out.println("Average Turn Around Time is:"+avgTurnAround);
		System.out.println("Average Waiting Time is:"+avgWaiting);
		System.out.println("Maximum Waiting Time is:"+maxWaiting+" Process number is:"+maxWaitingProcess);
	}
}
