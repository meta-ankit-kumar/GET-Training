package objectsAndCollectionsDSASession4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class OrganicChemistry {
	static Map<Character, Integer> atomMass = new HashMap<Character, Integer>();
	public static void setAtomMass(){
		atomMass.put('C', 12);
		atomMass.put('H', 1);
		atomMass.put('O', 16);
	}
	public static int calculateMass(String compoundString){
		//boolean checkDigitLoop = false;
		Stack<String> compound = new Stack<String>();
		compoundString = compoundString.toUpperCase();
		int i = 0;
		while(i < compoundString.length()){
			boolean checkDigitLoop = false;
			if(Character.isLetter(compoundString.charAt(i))){
				if((compoundString.charAt(i) == 'C') || (compoundString.charAt(i) == 'O') || (compoundString.charAt(i) == 'H')){
					Integer value = atomMass.get(compoundString.charAt(i));
					//System.out.println(value+ " " + atomMass.get(Character.valueOf(compoundString.charAt(i)))+" " + Character.valueOf(compoundString.charAt(i)));
					String item = Integer.toString(value);
					compound.push(String.valueOf(item));
				}
			}
			if(compoundString.charAt(i) == '('){
				compound.push(String.valueOf(compoundString.charAt(i)));
			}
			if(compoundString.charAt(i) == ')'){
				int sum = 0;
				int j = i;
				while(j >= 0){
					if("(".compareTo(compound.lastElement()) == 0 ){
						compound.pop();
						compound.push(String.valueOf(sum));
						break;
					}
					else{
						sum += (Integer.valueOf(compound.pop()));
					}
					j--;
				}
			}
			if(Character.isDigit(compoundString.charAt(i))){
				String digits  = "";
				while(Character.isDigit(compoundString.charAt(i))){
					digits += compoundString.charAt(i);
					checkDigitLoop = true;
					i+=1;
					if(i >= compoundString.length())
						break;
				}
				try{
					int ItemToBePushed = Integer.valueOf(digits);
					int poppedItem = Integer.valueOf(compound.pop());
					compound.push(String.valueOf(ItemToBePushed * poppedItem));
				}
				catch(Exception e){
					System.out.println("Invalid Input");
					System.exit(0);
				}
			}
			
			if(checkDigitLoop)
				continue;
			else
				i++;
		}
		int s = 0;
		try{
			for(String x : compound){
				s += Integer.valueOf(x);
			}
			return s;
		}
		catch(Exception e){
			System.out.println("Invalid Input");
			System.exit(0);
		}
		return s;
	}
	/**
	 * Validate the input string whether it is a correct organic compound or not
	 * @param compoundString Compound String which is going to be validated
	 * @throws IllegalStateException If length of the input is zero or Atoms other than C, H, and O are present.
	 */
	public static void validateInput(String compoundString) throws IllegalStateException{
		if(compoundString.length() == 0)
			throw new IllegalStateException("Length of the input should be a positive number");
		compoundString = compoundString.toUpperCase();
		for(int i = 0; i < compoundString.length(); i++){
			if(Character.isLetter(compoundString.charAt(i))){
				if((compoundString.charAt(i) != 'C') && (compoundString.charAt(i) != 'O') && (compoundString.charAt(i) != 'H'))
					throw new IllegalStateException("Atoms can only be C, H or O. Other atoms are not allowed");
			}
			else if(Character.isDigit(compoundString.charAt(i)))
				continue;
			else if(compoundString.charAt(i) == '(' || compoundString.charAt(i) == ')')
				continue;
			else
				throw new IllegalStateException("Please enter a valid string");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String compoundString;
		System.out.println("Allowed Atoms are only C, H and O");
		System.out.println("Please Enter the compound string:");
		try{
			compoundString = sc.nextLine();
			try{
				validateInput(compoundString);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				System.exit(0);
			}
			setAtomMass();
			System.out.println("Mass of the compound is:"+calculateMass(compoundString));
		}
		catch(Exception e){
			System.out.println("Please enter a valid string");
			System.exit(0);
		}		
	}

}
