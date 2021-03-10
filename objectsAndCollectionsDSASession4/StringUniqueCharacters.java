package objectsAndCollectionsDSASession4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StringUniqueCharacters {
	Map<String,Integer> stringTrack = new HashMap<String, Integer>();
	/**
	 * Count the number of unique characters in the string and put it in cache memory. If the string is already processed before
	 * then it returns the fetched cached data
	 * @param inputString String from which unique characters are going to be counted
	 * @return number of unique characters
	 */
	public int uniqueCharacters(String inputString){
		if(stringTrack.containsKey(inputString)){
			System.out.println("Retrieving Cached Result");
			return stringTrack.get(inputString);
		}
		Set<Character> uniqueCount = new HashSet<Character>();
		//Map<Character,Integer> uniqueCount = new HashMap<Character, Integer>();
		for(int i=0; i < inputString.length(); i++){
			uniqueCount.add(inputString.charAt(i));
		}
		int uniqueCharacters = uniqueCount.size();
		stringTrack.put(inputString, uniqueCharacters);
		return uniqueCharacters;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("THIS FUNCTION IS CASE SENSITIVE. Means 'A' AND 'a'  ARE DIFFERENT CHARACTERS");
		while(true){
			System.out.println("Please enter the string which contains only characters");
			String inputString = sc.nextLine();
			for(int i=0; i < inputString.length(); i++){
				if(!(Character.isLetter(inputString.charAt(i)))){
					System.out.println("Only UpperCase and LowerCase Characters are allowed");
					System.exit(0);
				}		
			}
			StringUniqueCharacters s = new StringUniqueCharacters();
			System.out.println("Number of unique characters in string "+ inputString + " are: " + s.uniqueCharacters(inputString));
			int choice;
			System.out.println("Enter 1 to continue. Any Other Integer Key to Exit");
			try{
				choice = sc.nextInt();
				if(choice != 1)
					break;
			}
			catch(Exception e){
				System.out.println("Only Integer Keys are Allowed");
				System.exit(0);
			}	
			sc.nextLine();
	}
}
}
