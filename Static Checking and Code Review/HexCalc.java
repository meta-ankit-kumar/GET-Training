package Assignment2;
import java.util.*;
public class HexCalc {
	// this variable will contain hexadecimal representation of number from 10 to 15 
	static Map<Character, Integer> decimal_represent_hex = new HashMap<Character, Integer>();
	//Constructor
	public HexCalc(){
		decimal_represent_hex.put('a',10);
		decimal_represent_hex.put('b', 11);
		decimal_represent_hex.put('c',12);
		decimal_represent_hex.put('d', 13);
		decimal_represent_hex.put('e', 14);
		decimal_represent_hex.put('f', 15);
	}
	String add(String hexnum1,String hexnum2,int base){
		int decimal1=to_decimal(hexnum1,base );
		int decimal2=to_decimal(hexnum2, base);
		int sum=decimal1+decimal2;
		return "Sum is(In Hexadecimal Representation):"+decimal_to_other(sum, base);
	}
	//This function always returns a positive number
	//Smaller number will be subtracted from Larger number
	String subtract(String hexnum1,String hexnum2,int base){
		int decimal1=to_decimal(hexnum1,base );
		int decimal2=to_decimal(hexnum2, base);
		int sub=Math.abs(decimal1-decimal2);//to store the subtraction
		return "Subtraction(Absolute Value) is(In Hexadecimal Representation):"+decimal_to_other(sub, base);
	}
	String multiply(String hexnum1,String hexnum2,int base){
		int decimal1=to_decimal(hexnum1,base );
		int decimal2=to_decimal(hexnum2, base);
		//mul variable will contain the required multiplication
		int mul=decimal1*decimal2;
		return "Multiplication is(In Hexadecimal Representation):"+decimal_to_other(mul, base);
	}
	//this function returns only Integral part of the division
	//It is assumed that user will provide hexadecimal value without any decimal
	String divide(String hexnum1,String hexnum2,int base){
		int decimal1=Integer.parseInt(hexnum1, base);
		int decimal2=Integer.parseInt(hexnum2,base);
		//to store the division
		int div=decimal1/decimal2;
		return "Division is (In Hexadecimal Representation ):"+decimal_to_other(div, base);
	}
	boolean equals_to(String hexnum1,String hexnum2){
		if(hexnum1.equals(hexnum2)){
			return true;
		}
		return false;
	}
	boolean greater_than(String hexnum1,String hexnum2){
		//if the number returned by compareTo function is positive then first number is greater than second
		if(hexnum1.compareTo(hexnum2)>0){
			return true;
		}
		return false;
	}
	boolean lesser_than(String hexnum1,String hexnum2){
		if(hexnum1.compareTo(hexnum2)<0){
			return true;
		}
		return false;
	}
	static String decimal_to_other(int decimal1,int base){
		String num="";
		if(decimal1==0)
			return "0";
		while(decimal1!=0){
			num+=String.valueOf(Character.toUpperCase(Character.forDigit(decimal1%base, base)));
			decimal1=decimal1/base;
		}
		//New we need to reverse the content of num to get the actual output
		StringBuilder target_number = new StringBuilder();
		
        target_number.append(num);
 
        // reverse StringBuilder input1
        target_number.reverse();
        num=target_number.toString();
		return num;
	}
	static int to_decimal(String hexnum,int base){
		int i=hexnum.length()-1;
		int decimal=0;
		int power=0;
		while(i>=0){
			Character digit=Character.toLowerCase(hexnum.charAt(i));
			
			double multiply=Math.pow(base, power);
			if(decimal_represent_hex.containsKey(digit)){
				
				decimal+=decimal_represent_hex.get(digit)*multiply;
			}
			else{
			decimal+=Character.getNumericValue(hexnum.charAt(i))*multiply;
			}
			i-=1;
			power+=1;
		}
		return decimal;
	}
	public static void main(String []args){
		HexCalc c= new HexCalc();
		System.out.println("Please Choose from the following:");
		System.out.println("1. Convert Hexadecimal Number to Decimal Number");
		System.out.println("2. Convert Decimal Number to Hexadecimal Number");
		System.out.println("3. Add two Hexadecimal Numbers");
		System.out.println("4. Subtract two Hexadecimal Numbers");
		System.out.println("5. Multiply two Hexadecimal Numbers");
		System.out.println("6. Divide two Hexadecimal Numbers");
		System.out.println("7. Whether 1st Hexadecimal Number is equal to 2nd Hexadecimal Number");
		System.out.println("8. Whether 1st Hexadecimal Number is Greater 2nd Hexadecimal Number");
		System.out.println("9. Whether 1st Hexadecimal Number is Lesser than  2nd Hexadecimal Number");
		System.out.println("10. Exit");
		System.out.println("Enter Your Choice:");
		int choice;
		//Base is assumed to be 16....For other number system change the value of base variable
		int base=16;
		Scanner sc= new Scanner(System.in);
		choice=sc.nextInt();
		sc.nextLine();
		String hexdec1,hexdec2;
		switch (choice) {
		case 1:
			System.out.println("Enter Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println(c.to_decimal(hexdec1, base));
			break;
		case 2:
			System.out.println("Enter Decimal Number");
			int dec=sc.nextInt();
			System.out.println(c.decimal_to_other(dec, base));
			break;
		case 3:
			System.out.println("Enter 1st Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println("Enter 2nd Hexadecimal Number");
			hexdec2=sc.nextLine();
			System.out.println(c.add(hexdec1,hexdec2,base));
			break;
		case 4:
			System.out.println("Enter 1st Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println("Enter 2nd Hexadecimal Number");
			hexdec2=sc.nextLine();
			System.out.println(c.subtract(hexdec1,hexdec2,base));
			break;
		case 5:
			System.out.println("Enter 1st Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println("Enter 2nd Hexadecimal Number");
			hexdec2=sc.nextLine();
			System.out.println(c.multiply(hexdec1,hexdec2,base));
			break;
		case 6:
			System.out.println("Enter 1st Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println("Enter 2nd Hexadecimal Number");
			hexdec2=sc.nextLine();
			System.out.println(c.divide(hexdec1,hexdec2,base));
			break;
		case 7:
			System.out.println("Enter 1st Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println("Enter 2nd Hexadecimal Number");
			hexdec2=sc.nextLine();
			if(c.equals_to(hexdec1, hexdec2))
				System.out.println("Both Numbers are Equal");
			else
				System.out.println("Not Equal");
			break;
		case 8:
			System.out.println("Enter 1st Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println("Enter 2nd Hexadecimal Number");
			hexdec2=sc.nextLine();
			if(c.greater_than(hexdec1, hexdec2))
				System.out.println("First Number is greater than Second");
			else
				System.out.println("First Number is not greater than Second");
			break;
		case 9:
			System.out.println("Enter 1st Hexadecimal Number");
			hexdec1=sc.nextLine();
			System.out.println("Enter 2nd Hexadecimal Number");
			hexdec2=sc.nextLine();
			if(c.lesser_than(hexdec1, hexdec2))
				System.out.println("First Number is lesser than Second");
			else
				System.out.println("First Number is not lesser than Second");
			break;
		case 10:
			break;
		default:
			System.out.println("Please Enter the correct choice");
			break;
		}
	}

}
