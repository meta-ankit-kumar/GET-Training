package specificationAssignment;
import java.util.*;
public class String1 {
	/**
	 * To compare two string whether they are equal or not. Strings cannot be null and case sensitive.
	 * @param str1 First String
	 * @param str2 Second String
	 * @return 1 if strings are equal else 0.
	 */
	public static int compareStrings(String str1,String str2){
		if(str1.length()!=str2.length())
			return 0;
		else{
			for(int i=0;i<str1.length();i++){
				if(str1.charAt(i) != str2.charAt(i))
					return 0;
			}
		}
		return 1;
	}
	/**
	 * Reverse the complete string not word by word
	 * @param str String that is going to be reversed
	 * @return reversed string 
	 */
	public static String reverseString(String str){
		// Due to immutable nature of Strings we can't modify the actual so we need to convert it to character array
		char charArray[] = str.toCharArray();
		int length = charArray.length-1;
		for(int i=0;i <= (int)(length)/2;i++){
			char temp;
		
			temp = charArray[i];
			charArray[i] = charArray[length-i];
			charArray[length-i] = temp;
		}
		String reversedString = new String(charArray);
		return reversedString;
	}
	/**
	 * Replace lower-case characters with upper-case characters and vice-versa
	 * @param str string whose characters are going to be swapped
	 * @return final string obtained by replacing lower-case with upper-case and vice-versa
	 */
	public static String swapeCase(String str){
		char characterArray[] = str.toCharArray();
		int length = str.length();
		for(int i=0; i<length; i++){
			if((int)characterArray[i] >=65 && (int)characterArray[i] <=90)
				characterArray[i] = (char)((int)characterArray[i] + 32);
			else if((int)characterArray[i] >=97 && (int)characterArray[i] <=122)
				characterArray[i] = (char)((int)characterArray[i] - 32 );
		}
		String result = new String(characterArray);
		return result;
	}
	/**
	 * Determines the longest word in the string. Space is considered as splitter between two words.
	 * @param str string from which longest word is going to be determined.
	 * @return longest word string. In case if there are more than one longest word then it returns the first word
	 */
	public static String longestWord(String str){
		String maxString="";
		String temp="";
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==' '){
				if(temp.length()>maxString.length()){
					maxString = temp;
					temp = "";
				}
				else
					temp="";
			}
			else
				temp+=str.charAt(i);
		}
		if(temp.length()>maxString.length())
			maxString = temp;
		return maxString;
	}

	public static void main(String[] args) {
		System.out.println("Please choose from the following options:");
		System.out.println("1. To compare two strings");
		System.out.println("2. To reverse the string");
		System.out.println("3. Replace string's lowercase characters with uppercase characters & Vice-Versa");
		System.out.println("4. To find the longest word of the string");
		System.out.println("5. Exit");
		String str1="";
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Please enter your choice:");
		choice = sc.nextInt();
		if(choice>=1 && choice<=4){
		sc.nextLine();
		System.out.println("Enter the String:");
		str1 = sc.nextLine();
		}
		switch (choice) {
		case 1:
			System.out.println("Please enter the Second String");
			String str2;
			str2 = sc.nextLine();
			System.out.println(compareStrings(str1, str2));
			break;
		case 2:
			System.out.println("Reversed String is: "+reverseString(str1));
			break;
		case 3:
			System.out.println("String after replacing \nlowercase characters with uppercase characters & Vice-Verse:"+ swapeCase(str1));
			break;
		case 4:
			String word = longestWord(str1);
			System.out.println("Longest word in the string:"+word+" Length is:"+word.length());
			break;
		case 5:
			break;
		default:
			System.out.println("Please enter the correct choice");
			break;
		}
		sc.close();
	}

}
