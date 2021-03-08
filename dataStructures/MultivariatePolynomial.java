package dataStructures;

import java.util.Scanner;
/*
 * Visual Representation of Multivariate Polynomial
 * Let Suppose we are given the following polynomial
 * 3*x^2*y^2 + 2*x*y + 3*y^2 + 8*x^2 + 9*x*y*z
 * The above polynomial can be visualized with the help linked list as follows:
 *   ___	   ------        ------       --------
 *  |	|-->  | 3 |  |	--> | 2 |  | --> | 2 |null|
 *  |___|	   ------        ------       --------
 *   ___	   ------        ------       --------
 *  |	|-->  | 2 |  |	--> | 1 |  | --> | 1 |null|
 *  |___|	   ------        ------       --------
 *   ___	   ------        --------   
 *  |	|-->  | 3 |  |	--> | 2 |null| 
 *  |___|	   ------        --------   
 * 	 ___	   ------        ------     
 *  |	|-->  | 8 |  |	--> | 2 |  | 
 *  |___|	   ------        ------     
 *   ___	   ------        ------       ------       --------
 *  |	|-->  | 3 |  |	--> | 1 |  | --> | 1 |  | --> | 1 |null|
 *  |___|	   ------        ------       ------       --------
 */

public class MultivariatePolynomial {
	public static void main(String[] args){
		
		System.out.println("Enter number of non zero coefficient terms in polynomial");
		int numberOfTerms;
		Scanner sc = new Scanner(System.in);
		numberOfTerms = sc.nextInt();
		if(numberOfTerms <= 0){
			System.out.println("Number of terms should be a positive number");
			System.exit(0);
		}
		else{
			//Polynomial Representation using Nested Linked List
			LinkedList polynomial[] = new LinkedList[numberOfTerms];
			for(int i = 0; i < numberOfTerms; i++){
				// This will be size of outer linked list
				int numberOfVariables;
				LinkedList l = new LinkedList();
				System.out.println("Enter number of variables in the term");
				// Number of nodes in inner linked list will depend on the number of variables in the term
				numberOfVariables = sc.nextInt();
				System.out.println("Enter the NonZero Coefficient of the term");
				int coeff = sc.nextInt();
				if(coeff <= 0){
					System.out.println("Coefficient should be a positive number");
					System.exit(0);
				}
				// First node of each inner linked list will contain the coefficient of that particular term
				l.insertAtLast(coeff);
				// Now all the nodes of inner linked list that are pointed by first node which contains coefficient
				System.out.println("Enter the degree of each variable");
				for(int j = 0; j < numberOfVariables; j++){
					int degree = sc.nextInt();
					if(degree < 0){
						System.out.println("Degree of a variable must not be negative number");
						System.exit(0);
					}
					l.insertAtLast(degree);
				}
				// Now put the object of inner linked list to the outer linked list
				polynomial[i] = l;
			}
			int degree = 0;
			System.out.println("Different terms of Polynomial are following (Coefficent of the term, Degree of different variables)");
			for(int i=0; i<polynomial.length; i++){
				polynomial[i].printLinkedList();
				//Now we are going to find the degree of the multivariate polynomial
				LinkedList.Node x = polynomial[i].head;
				//Ignore the data of head node because it contains coefficient not degree
				x = x.next;
				// variable to calculate degree of the polynomial
				int tempDegree = 0;
				while(x != null){
					tempDegree += x.data;
					x = x.next;
				}
				if(tempDegree > degree)
					degree = tempDegree;
			}
			System.out.println("Degree of the Polynomial is: "+degree);
		}
		sc.close();
	}
}
