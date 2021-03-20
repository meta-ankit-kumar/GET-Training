package staticCheckingandCodeReview;
import java.util.*;
/**
 * Hexadecimal class which supports many operation that can be performed on the Hexadecimal numbers
 * like addition, subtraction, multiplication and division
 * @author ankit.kumar_metacube
 *
 */
public class HexCalc {
	/**
	 * method to convert hexadecimal number into decimal number
	 * @param hex  hexadecimal value
	 * @param baseOfNumber Base of the number
	 * @return  decimal value corresponds to hexadecimal value
	 * @throws Exception Throws exception in case the hexadecimal number is incorrect
	 */
	public static int HexaDecimalToDecimal(String hexadeimalNumber) throws Exception{
		//storing the length of the hexadecimal number
		int len = hexadeimalNumber.length();
		//Initially the last element of the hexadecimalNumber will be multiplied to 1
		int base = 1;
		int baseOfNumber = 16;
		// it will contain the final result
		int decimal = 0; 
		for (int i = len-1; i >= 0 ; i-- ){
			if ( hexadeimalNumber.charAt(i) >= '0' &&  hexadeimalNumber.charAt(i) <= '9' ) {
				decimal += (  hexadeimalNumber.charAt(i) - 48 ) * base;
			}
			else if (hexadeimalNumber.charAt(i) >= 'A' && hexadeimalNumber.charAt(i) <= 'F' ) {
				decimal += ( hexadeimalNumber.charAt(i) - 55 ) * base;
			}
			else
				throw new Exception("Incorrect Hexadecimal number");
			base *= baseOfNumber;
		}
		return decimal;
	}
	
	/**
	 * method to convert decimal number into hexadecimal number
	 * @param decimal Decimal number which is going to be converted
	 * @return -> HexaDecimal Value
	 * @throws Exception Throws exception in case of any exception
	 */
	public static String DecimalToHexaDecimal(int decimal) throws Exception{
		String hexaDecimal = "";
		if(decimal == 0)
			return "0";
		int remainder;
		int baseOfNumber = 16;
		while(decimal > 0){
			try{
				remainder = decimal % baseOfNumber;
			}
			catch(Exception e){
				throw new Exception("Incorrect Decimal Number");
			}
			if (remainder < 10 ){
				hexaDecimal = (char) ( remainder + 48 ) + hexaDecimal;
			}
			else {
				hexaDecimal = (char) ( remainder + 55 ) + hexaDecimal;
			}
			decimal = decimal / baseOfNumber;
		}
		return hexaDecimal;
	}
	/**'
	 * function to add two HexaDecimal Value
	 * @param hexaDecimalNumber1
	 * @param hexaDecimalNumber2
	 * @return -> HexaDecimal Value after addition
	 */
	public static String addHexaDecimal(String hexaDecimalNumber1 , String hexaDecimalNumber2){ 
		int tempResult;
		String finalResult = "";
		int decimal1, decimal2;
		try{
			decimal1 = HexaDecimalToDecimal(hexaDecimalNumber1);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		try{
			decimal2 = HexaDecimalToDecimal(hexaDecimalNumber2);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		tempResult =  decimal1 + decimal2;
		try{
		finalResult = DecimalToHexaDecimal(tempResult);
		}
		catch(Exception e){
			return finalResult;
		}
		return finalResult;
	}
	
	/**
	 * Method to subtract two HexaDecimal Value. If subtraction produces negative result then it returns the absolute value.
	 * @param hexaDecimalNumber1 first hexadecimal number
	 * @param hexaDecimalNumber2 second hexadecimal number
	 * @return Hexadecimal number which is obtained by subtraction of hexaDecimalNumber1 and hexaDecimalNumber2
	 */
	public static String subtractHexaDecimal(String hexaDecimalNumber1 , String hexaDecimalNumber2){ 
		int tempResult;
		String finalResult = "";
		int decimal1, decimal2;
		try{
			decimal1 = HexaDecimalToDecimal(hexaDecimalNumber1);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		try{
			decimal2 = HexaDecimalToDecimal(hexaDecimalNumber2);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		tempResult =  Math.abs(decimal1 - decimal2);
		try{
		finalResult = DecimalToHexaDecimal(tempResult);
		}
		catch(Exception e){
			return finalResult;
		}
		return finalResult;
	}
	
	/**
	 * Method to multiply two HexaDecimal numbers
	 * @param hexaDecimalNumber1 first hexadecimal number
	 * @param hexaDecimalNumber2 second hexadecimal number
	 * @return Multiplication of two hexadecimal numbers
	 */
	public static String multiplyHexaDecimal(String hexaDecimalNumber1 , String hexaDecimalNumber2){ 
		int tempResult;
		String finalResult = "";
		int decimal1, decimal2;
		try{
			decimal1 = HexaDecimalToDecimal(hexaDecimalNumber1);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		try{
			decimal2 = HexaDecimalToDecimal(hexaDecimalNumber2);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		tempResult =  decimal1 * decimal2;
		try{
		finalResult = DecimalToHexaDecimal(tempResult);
		}
		catch(Exception e){
			return finalResult;
		}
		return finalResult;
	}
	
	/**
	 * method to divide hexaDecimal numbers
	 * @param hexaDecimalNumber1 First hexadecimal numbers
	 * @param hexaDecimalNumber2 Second hexadecimal numbers
	 * @return Integer division of two hexadecimal numbers
	 */
	public static String divideHexaDecimal(String hexaDecimalNumber1 , String hexaDecimalNumber2){ 
		if (hexaDecimalNumber2.equals("0")){
			throw new ArithmeticException("Second Hexadecimal number should be non-zero positive number");
		}
		int tempResult;
		String finalResult = "";
		int decimal1, decimal2;
		try{
			decimal1 = HexaDecimalToDecimal(hexaDecimalNumber1);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		try{
			decimal2 = HexaDecimalToDecimal(hexaDecimalNumber2);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
		tempResult =  decimal1 / decimal2;
		try{
		finalResult = DecimalToHexaDecimal(tempResult);
		}
		catch(Exception e){
			return finalResult;
		}
		return finalResult;
	}
	
	/**
	 * function to check hexaDecimalNumber1 == hexaDecimalNumber2
	 * @param hexaDecimalNumber1
	 * @param hexaDecimalNumber2
	 * @return
	 */
	public static boolean isEqual(String hexaDecimalNumber1 , String hexaDecimalNumber2){
		return hexaDecimalNumber1.equals(hexaDecimalNumber2);
	}
	
	/**
	 * function to check hexaDecimalNumber1 > hexaDecimalNumber2
	 * @param hexaDecimalNumber11
	 * @param hexaDecimalNumber2
	 * @return
	 */
	public static boolean isGreaterThan(String hexaDecimalNumber1 , String hexaDecimalNumber2){
		if (hexaDecimalNumber1.length() > hexaDecimalNumber2.length()){
			return true;
		}
		else if (hexaDecimalNumber1.length() < hexaDecimalNumber2.length()){
			return false;
		}
		else{
			for (int i = hexaDecimalNumber1.length() - 1; i >= 0; i-- ){
				if ( hexaDecimalNumber1.charAt(i) > hexaDecimalNumber2.charAt(i) ){
					return true;
				}
				if ( hexaDecimalNumber1.charAt(i) < hexaDecimalNumber2.charAt(i) ){
					return false;
				}
			}
			return false;
		}
	}
	
	/**
	 * function to check if hexaDecimalNumber1 < hexaDecimalNumber2
	 * @param hexaDecimalNumber1
	 * @param hexaDecimalNumber2
	 * @return
	 */
	public static boolean isLessThan(String hexaDecimalNumber1 , String hexaDecimalNumber2){
		if (hexaDecimalNumber1.length() < hexaDecimalNumber2.length()){
			return true;
		}
		else if (hexaDecimalNumber1.length() > hexaDecimalNumber2.length()){
			return false;
		}
		else{
			for (int i = hexaDecimalNumber1.length() - 1; i >= 0; i-- ){
				if ( hexaDecimalNumber1.charAt(i) < hexaDecimalNumber2.charAt(i) ){
					return true;
				}
				if ( hexaDecimalNumber1.charAt(i) > hexaDecimalNumber2.charAt(i) ){
					return false;
				}
			}
			return false;
		}
	}
	/**
	 * checks if the given input is hexadecimal or not
	 * @param hex
	 * @return true if the given number is hexadecimal otherwise false
	 */
	public static boolean isHexaDecimal(String hex) {
		int len = hex.length();
		for (int i = len-1; i >= 0 ; i-- ){
			if ( hex.charAt(i) >= '0' &&  hex.charAt(i) <= '9' ) {
			}
			else if (hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F' ) {
			}
			else {
				return false;
			}
		}
		return true;
	}
	/**
	 * To take input from the user
	 * @param scan Scanner class object
	 * @return Hexadecimal number
	 */
	public static String inputHexaDecimal(Scanner scan ) {
		String hex;
		hex = scan.nextLine();
		while ( !isHexaDecimal(hex.toUpperCase()) ) {
			System.out.println("Wrong input..Please enter a hexadecimal number : ");
			hex = scan.nextLine();
		}
		return hex.toUpperCase();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String hexaDecimalNumber1,hexaDecimalNumber2;
		System.out.println("Please enter first hexadecimal number");
		hexaDecimalNumber1 = inputHexaDecimal(sc);
		System.out.println("Please enter second hexadecimal number");
		hexaDecimalNumber2 = inputHexaDecimal(sc);
		int choice;
		while(true){
			boolean loopCheck = false;
			System.out.println("Please choose from the following"
					+ "\n1. Addition"
					+ "\n2. Subtraction"
					+ "\n3. Multiplication"
					+ "\n4. Division"
					+ "\n5. Check whether the first hexadecimal number is greater than second or not"
					+ "\n6. Check whether the first hexadecimal number is lesser than second or not"
					+ "\n7. Check whether the first hexadecimal number is equal to second or not"
					+ "\n8. Exit");
			System.out.println("Please enter your choice");
			try{
				choice = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e){
				System.out.println("Please enter the correct choice");
				continue;
			}
			switch (choice) {
			case 1:
				System.out.println("Addition of the entered hexadecimal numbers is " + addHexaDecimal(hexaDecimalNumber1, hexaDecimalNumber2));
				break;
			case 2:
				System.out.println("Subtraction of the entered hexadecimal numbers is " + subtractHexaDecimal(hexaDecimalNumber1, hexaDecimalNumber2));
				break;
			case 3:
				System.out.println("Multiplication of the entered hexadecimal numbers is " + multiplyHexaDecimal(hexaDecimalNumber1, hexaDecimalNumber2));
				break;
			case 4:
				System.out.println("Division of the entered hexadecimal numbers is " + divideHexaDecimal(hexaDecimalNumber1, hexaDecimalNumber2));
				break;
			case 5:
				System.out.println("Whether the first hexadecimal number is greater than second or not:" + isGreaterThan(hexaDecimalNumber1, hexaDecimalNumber2));
				break;
			case 6:
				System.out.println("Whether the first hexadecimal number is lesser than second or not:" + isLessThan(hexaDecimalNumber1, hexaDecimalNumber2));
				break;
			case 7:
				System.out.println("Whether the first hexadecimal number is equal to second or not:" + isEqual(hexaDecimalNumber1, hexaDecimalNumber2));
				break;
			case 8:
				loopCheck = true;
				break;
			default:
				System.out.println("Please enter the correct choice");
				break;
			}
			if(loopCheck)
				break;
		}
	}
	
	
}