package treesAndGraphs;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Main app which will display the order of bowlers
 * @author ankit.kumar_metacube
 *
 */
public class MainAppForVirat {

	public static void main(String[] args) {
		
		boolean flag = true;
		while(flag){
			try{
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Enter Number of Balls Virat is Going to Play : ");
				
				int noOfBallsViratIsGoingToPlay = scanner.nextInt();

				System.out.println("Enter Number of Bowlers: ");
				int noOfBowlers = scanner.nextInt();
				int[] noOfBallsOfBowlers = new int[noOfBowlers];
				
				for(int index = 0; index <= noOfBowlers -1; index++ ){
					System.out.println("Enter Number of Balls Left for Bowler " + (index+1) + " : ");
					noOfBallsOfBowlers[index] = scanner.nextInt();
				}
				
				Cricket cricket = new Cricket(noOfBallsViratIsGoingToPlay, noOfBallsOfBowlers);
				try{
					ArrayList<Bowler> bowlersOrder = cricket.getOrderOfBowler();
					System.out.println("Order of Bowlers: ");
					System.out.println("BowlerID : No Of Balls");
					for(Bowler bowler: bowlersOrder){
						System.out.println(bowler.getId() + "      :    " + bowler.getNoOfBallsLeft());
					}
					flag = false;
				}
				catch(AssertionError e){
					System.out.println(e.getMessage());
				}
				
			}
			catch(Exception e){
				System.out.println("Wrong Input !");
			}
		}
	}
}
