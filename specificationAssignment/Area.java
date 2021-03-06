package specificationAssignment;
import java.util.*;
public class Area {
	/**
	 * Calculates the area of triangle
	 * @param height Height of the triangle
	 * @param base Base of the triangle
	 * @return Area of the triangle
	 * @throws ArithmeticException This is not required because there is zero possibility of Any Arithmetic exception
	 */
	static double areaTriangle(double height, double base) throws ArithmeticException{
		double area;
		try{
			area = (height * base)/2;
			area = Math.round(area*100.0)/100.0;
			return area;
		}
		catch(ArithmeticException e){
			area=0;
			System.out.println(e);
		}
		return area;
	}
	/**
	 * Calculates the area of rectangle
	 * @param width Width of the rectangle
	 * @param length Length of the rectangle
	 * @return Area of the Rectangle
	 */
	static double areaRectangle(double width, double length){
		double area;
		area = width * length;
		area = Math.round(area*100.0)/100.0;
		return area;
	}
	/**
	 * Calculates the area of square
	 * @param side Side of the square
	 * @return Area of the square
	 */
	static double areaSquare(double side){
		double area;
		area = side * side;
		area = Math.round(area * 100.0)/100.0;
		return area;
	}
	/**
	 * Calculates the area of Circle
	 * @param radius Radius of the Circle
	 * @return Area of the Circle
	 */
	static double areaCircle(double radius){
		double area;
		area = Math.PI * radius * radius;
		area = Math.round(area * 100.0)/100.0;
		return area;
	}
	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose from the following");
		System.out.println("1. Calculate area of Triangle");
		System.out.println("2. Calculate Area of Rectangle");
		System.out.println("3. Calculate Area of Square");
		System.out.println("4. Calculate Area of Circle");
		System.out.println("5. Exit");
		System.out.println("Please enter your choice:");
		choice = sc.nextInt();
		if(choice==5)
			System.exit(0);
		switch (choice) {
		case 1:
			double height,base;
			System.out.println("Please enter the height of the triangle");
			height = sc.nextDouble();
			System.out.println("Please enter the base of the triangle");
			base = sc.nextDouble();
			System.out.println("Area of the Triangle is:"+areaTriangle(height, base));
			break;
		case 2:
			double length,width;
			System.out.println("Enter the length of the rectangle");
			length = sc.nextDouble();
			System.out.println("Enter the Width of the rectangle");
			width = sc.nextDouble();
			System.out.println("Area of the Rectangle is:"+areaRectangle(width, length));
			break;
		case 3:
			double side;
			System.out.println("Enter the side of the Square");
			side = sc.nextDouble();
			System.out.println("Area of the Square is:"+areaSquare(side));
			break;
		case 4:
			double radius;
			System.out.println("Enter the radius of the Circle");
			radius = sc.nextDouble();
			System.out.println("Area of the Circle is:"+areaCircle(radius));
			break;
		default:
			System.out.println("Please enter the correct choice");
			break;
		}
		sc.close();
	}

}
