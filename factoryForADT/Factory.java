package factoryForADT;
import java.util.*;

import factoryForADT.Shape.ShapeType;
//Point class to store point coordinates
class Point{
	final double x;
	final double y;
	/**
	 * Constructor to initialize Point coordinates
	 * @param xCoordinate x coordinate
	 * @param yCoordinate y coordinate
	 */
	public Point(double xCoordinate, double yCoordinate) {
		x = xCoordinate;
		y = yCoordinate;
	}
}
//Shape interface
interface Shape
{
	enum ShapeType{
		TRIANGLE, RECTANGLE, SQUARE, CIRCLE;
	}
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point pt); 
	String getType();
}
//Triangle class which implements Shape interface
class Triangle implements Shape
{
	Point p;//It will contain the origin of the space
	String type;
	double base;
	double height;
	// constructor of Triangle
	Triangle(String t, Point o, ArrayList<Double> a)
	{
		base = a.get(0);
		height = a.get(1);
		type = t;
		p = o;
	}
	// method to get Area of triangle
	public double getArea()
	{
		double area = base * height / 2;
		//rounding off up-to 2 decimal digits
		return Math.round(area * 100.0) / (double) 100.0;
	}
	// method to get perimeter
	public double getPerimeter()
	{	
		double perimeter = (base + height + Math.sqrt(base*base+height*height));
		return Math.round(perimeter * 100.0) / (double) 100.0;
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to find point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
			Point v1,v2,v3;
			v1=new Point(p.x,p.y);
			v2=new Point(p.x+base,p.y);
			v3=new Point(p.x,p.y+height);
		    double area, area1, area2, area3;
		    area = calculateArea(v1, v2, v3);
		    area1 = calculateArea(v1, v2, pt);
		    area2 = calculateArea(v1, pt, v3);
		    area3 = calculateArea(pt, v2, v3);
		    if(area == (area1 + area2 + area3))
		    	return true;
		    else
		    	return false;
	}
	public static double calculateArea(Point v1, Point v2, Point v3){
		return Math.abs((v1.x * (v2.y - v3.y)) + v2.x * (v3.y - v1.y) + v3.x * (v1.y - v2.y));
	}
	// method to get type of shape
	public String getType()
	{
		return type;
	}
}
//Square class which implements Shape interface
class Square implements Shape
{
	double side;
	Point p;
	String type;
	Square(String t,Point o, ArrayList<Double> a)
	{
		side = a.get(0);
		type = t;
		p = o;
	}
	// method to get area
	public double getArea()
	{
		double area = side * side;
		//rounding off up-to 2 decimal digits
		return Math.round(area * 100.0) / (double) 100.0;
	}
	// method to get perimeter
	public double getPerimeter()
	{
		double perimeter = 4 * side;
		//rounding off up-to 2 decimal digits
		return Math.round(perimeter * 100.0) / (double) 100.0;
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to find point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
		if(pt.x < p.x || pt.y < p.y)
			return false;
		if(pt.x > p.x + side || pt.y > p.y + side)
			return false;
		return true;
	}
	// method to get type of shape
	public String getType()
	{
		return type;
	}
}
//Rectangle class which implements Shape interface
class Rectangle implements Shape
{
	Point p;
	String type;
	double length;
	double width;
	Rectangle(String t,Point o, ArrayList<Double> a)
	{
		length = a.get(0);
		width = a.get(1);
		type = t;
		p = o;
	}
	// method to get area
	public double getArea()
	{
		double area = length * width;
		//rounding off upto 2 decimal digits
		return Math.round(area * 100.0) / (double) 100.0;
	}
	// method to get perimeter
	public double getPerimeter()
	{
		double perimeter = 2 * (length + width);
		//rounding off upto 2 decimal digits
		return Math.round(perimeter * 100.0) / (double) 100.0;
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to find point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
		if((pt.x >= p.x && pt.x <= pt.x + length) && (pt.y >= p.y && pt.y <= p.y + width))
			return true;
		return false;
	}
	// method to find type of shape
	public String getType()
	{
		return type;
	}
}
//Circle class which implements Shape interface
class Circle implements Shape
{
	double radius;//Stores the address of the Circle
	Point p;//Stores the origin point coordinates
	String type;
	// constructor
	Circle(String t,Point o, ArrayList<Double> a)
	{
		radius = a.get(0);
		type = t;
		p = o;
	}
	// method to get area of circle
	public double getArea()
	{
		double area = Math.PI * radius * radius;
		//rounding off up-to 2 decimal digits
		return Math.round(area * 100.0) / (double) 100.0;
	}
	// method to get perimeter
	public double getPerimeter()
	{
		double perimeter = Math.PI * 2 * radius;
		return Math.round(perimeter * 100.0) / (double) 100.0; 
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to check point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
		if(Math.sqrt(( pt.x - p.x) * (pt.x - p.x)+(pt.y - p.y) * (pt.y - p.y)) <= radius)
			return true;
		else 
			return false;
	}
	// method to get type of shape
	public String getType()
	{
		return type;
	}
}
public class Factory {
	// Create shapes
		public static Shape createShape(String type,Point o,ArrayList<Double> a)
		{
			Shape shapeInstance = null;
			if("TRIANGLE".equals(type.toUpperCase()) )
			{
				shapeInstance = new Triangle(type,o,a);
			}
			if("SQUARE".equals(type.toUpperCase()))
			{
				shapeInstance = new Square(type,o,a);
			}
			if("RECTANGLE".equals(type.toUpperCase()))
			{
				shapeInstance = new Rectangle(type,o,a);
			}
			if("CIRCLE".equals(type.toUpperCase()))
			{
				shapeInstance = new  Circle(type,o,a);
			}
			return shapeInstance;
		}
	}
	// Screen class
	class Screen
	{	
		static Scanner sc = new Scanner(System.in);
		//list of shapes
		static ArrayList<Shape> listShape = new ArrayList<Shape>();
		//list of the date when a particular shape was added
		static ArrayList<Date>  date = new ArrayList<Date>(); 
		// method to add shape to the list
		void addShape(Shape s)
		{
			listShape.add(s);
			date.add(new Date());
		}
		/**
		 * Delete a particular shape object from the list
		 * @param s Type of the shape whose object is going to be deleted
		 * @throws Exception If the given shape is not present
		 */
		void removeShape(double xCoordinate, double yCoordinate, String shapeType) throws Exception
		{
			boolean isPresent = false;
			for(int i=0; i<listShape.size(); i++)
			{
				if(listShape.get(i).getType().equalsIgnoreCase(shapeType) && listShape.get(i).getOrigin().x == xCoordinate && listShape.get(i).getOrigin().y == yCoordinate)
				{
					listShape.remove(i);
					date.remove(i);
					isPresent = true;
					break;
				}
			}
			if(!isPresent)
				throw new Exception("Given shape is not present in the list");
		}
		// method to remove all shapes
		void removeAllShape(String shapeType)
		{
			for(int i=0; i < listShape.size(); i++)
				if(listShape.get(i).getType().equalsIgnoreCase(shapeType))
				{
					listShape.remove(i);
					i -= 1;
				}
		}
		/**
		 * Swaps two elements of list of shapes.
		 * @param list List which contains the shapes
		 * @param x Shape instance
		 * @param y Shape instance
		 */
		private void swap(int x, int y)
		{
			
			Shape s;
			s = listShape.get(x);
			listShape.set(x,listShape.get(y));
			listShape.set(y,s);
		}
		/**
		 * Swaps the two elements of list of dates of shapes
		 * @param list List which contains creation date of a particular shape
		 * @param x Date instance
		 * @param y	Date instance
		 */
		private void swapDate(int x, int y)
		{
			Date s;
			s = date.get(x);
			date.set(x,date.get(y));
			date.set(y,s);
		}
		/**
		 * Sort the shape list on the basis of Area, Perimeter, Origin and Time
		 * @param s type of the shape
		 * @return Modified list after sorting
		 * @throws Exception 
		 */
		ArrayList<Shape> sort(String s) throws Exception
		{
				for(int i=0; i<listShape.size()-1; i++)
				{
					for(int j=0;j<listShape.size()-i-1;j++)
					{
						if("Area".toUpperCase().equals(s.toUpperCase()))
						{
							if(listShape.get(j).getArea() > listShape.get(j+1).getArea())
							{
								swap(j,j+1);
								swapDate(j,j+1);
							}
						}
						else if("Perimeter".toUpperCase().equals(s.toUpperCase()))
						{
							if(listShape.get(j).getPerimeter() > listShape.get(j+1).getPerimeter())
							{
								swap(j,j+1);
								swapDate(j,j+1);
							}
						}
						else if("Origin".toUpperCase().equals(s.toUpperCase()))
						{
							Point p = listShape.get(j).getOrigin();
							Point q = listShape.get(j+1).getOrigin();
							double a = p.x * p.x + p.y * p.y;
							double b = q.x * q.x + q.y * q.y;
							if(a > b)
							{
								swap(j, j+1);
								swapDate(j, j+1);
							}
						}
						else if("time".toUpperCase().equals(s.toUpperCase()))
						{
							if(1 == date.get(j).compareTo(date.get(j+1)))
							{
								swap(j,j+1);
								swapDate(j,j+1);
							}
						}
						else{
							throw new Exception("Enter the correct parameter for sorting.");
						}
					}
				}
			return listShape;
		}
		void printShapeList(ArrayList<Shape> shapeList){
			if(shapeList.size() != 0){
				System.out.println("Shape Name | Origin | Area | Perimeter | Time of Insertion");
				for(int i = 0; i < shapeList.size(); i++){
					Shape shapeObject = shapeList.get(i);
					System.out.println(shapeObject.getType() + "  " + "  (" + shapeObject.getOrigin().x + "," + shapeObject.getOrigin().y + ")   " + shapeObject.getArea() + "  " + shapeObject.getPerimeter() + "      " + date.get(i));
				}
			}
				
		}
		/**
		 * Maintains a enclosedPointList array in which every element represent at i index [0,length-1] represents
		 * whether the point pt is enclosed in i-th shape or not
		 * @param pt Point to be checked
		 * @return Array enclosedPointList
		 */
		ArrayList<Shape> enclosed(Point pt)
		{
			ArrayList<Shape> enclosedPointList = new ArrayList<Shape>();
			for(int i = 0; i < listShape.size(); i++)
			{
				if(listShape.get(i).isPointEnclosed(pt))
				{
					enclosedPointList.add(listShape.get(i));
				}
			}
			return enclosedPointList;
		}
		/**
		 * Checks whether the input string is available or not
		 * @param typeOfShapeString Input string which is going to be checked
		 * @return If the entered string is available then true otherwise false
		 */
		static boolean checkValidShape(String typeOfShapeString){
			if(Shape.ShapeType.CIRCLE.name().equalsIgnoreCase(typeOfShapeString)
				|| Shape.ShapeType.TRIANGLE.name().equalsIgnoreCase(typeOfShapeString)
				|| Shape.ShapeType.RECTANGLE.name().equalsIgnoreCase(typeOfShapeString)
				|| Shape.ShapeType.SQUARE.name().equalsIgnoreCase(typeOfShapeString))
				return true;
			else
				return false;
		}
	public static void main(String[] args) {
		int choice;
		Screen screenObject = new Screen();
		while(true){
			System.out.println("\n------------------------------------------------------------------------"
					+ "\nPlease choose from the following options"
					+ "\n1.Add a shape object to the screen at a specified location with default orientation."
					+ "\n2.Delete a shape object from the screen"
					+ "\n3.Delete all shape objects of a specific type"
					+ "\n4.Sort the shape objects on a particular paramter"
					+ "\n5.Get list of shape objects enclosing a specified point."
					+ "\n6.Print the shape object list."
					+ "\n7.Exit");
			boolean loopCheck = false;
			try{
				System.out.println("Please enter your choice");
				choice = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e){
				System.out.println("Please enter the correct choice");
				continue;
			}
			switch (choice) {
			case 1:
				System.out.println("Please enter the x and y coordinates of the position where you want to insert the shape");
				double xCoordinate, yCoordinate;
				System.out.println("Enter the X Coordinate");
				try{		
					xCoordinate = Double.parseDouble(sc.nextLine());
					if(xCoordinate < 0)
						throw new Exception("X coordinate should be greater than or equals to zero");
				}
				catch(Exception e){
					System.out.println("Please enter the correct x coordinate." + e.getMessage());
					continue;
				}
				System.out.println("Enter the Y Coordinate");
				try{
					yCoordinate = Double.parseDouble(sc.nextLine());
					if(yCoordinate < 0)
						throw new Exception("X coordinate should be greater than or equals to zero");
				}
				catch(Exception e){
					System.out.println("Please enter the correct y coordinate" + e.getMessage());
					continue;
				}
				Point originPoint = new Point(xCoordinate, yCoordinate);
				ArrayList<Double> argumentsForShape = new ArrayList<Double>();
				System.out.println("Please enter the arguments of shape."
						+ "\n For triangle there will be two arguments specifying the base and height of the triangle."
						+ "\n For rectangle there will be two arguments specifying the length and width of the recatangle."
						+ "\n For circle there will be one argument specifying the radius of the circle"
						+ "\n For square there will be one argument specifying the side of the square");
				System.out.println("Enter the number of arguments");
				int numberOfArguments;
				try{
					numberOfArguments = Integer.parseInt(sc.nextLine());
					if(numberOfArguments <= 0)
						throw new Exception("Number of arguments should be positive");
					if(numberOfArguments > 2)
						throw new Exception("Number of arguments should be either 1 or 2.");
				}
				catch(Exception e){
					System.out.println("Enter the correct number of arguments." + e.getMessage());
					continue;
				}
				System.out.println("Enter each argument one by one.");
				boolean checkInnerLoop = false;
				while(numberOfArguments > 0){
					try{
						Double argument = Double.parseDouble(sc.nextLine());
						if(argument < 0)
							throw new Exception("Should be a positive number");
						argumentsForShape.add(argument);
					}
					catch(Exception e){
						System.out.println("Enter the correct argument." + e.getMessage());
						checkInnerLoop = true;
						break;
					}
					numberOfArguments -= 1;
				}
				if(checkInnerLoop)
					continue;
				String shapeType;
				System.out.println("Enter the type of the shape. Available shapes Triangle, Rectangle, Circle, Square");
				shapeType = sc.nextLine();
				if(shapeType.length() == 0){
					System.out.println("Enter the correct shape");
					continue;
				}
				if(checkValidShape(shapeType)){
					try{
						Shape shapeInstance = Factory.createShape(shapeType, originPoint, argumentsForShape);
						screenObject.addShape(shapeInstance);
					}
					catch(Exception e){
						System.out.println("Incorrect number of arguments for particular shape type.");
						continue;
					}
				}
				else{
					System.out.println("Please enter a valid shape type");
					continue;
				}
				System.out.println("Shape added successfully");
				break;
			case 2:
				double xCoordinate1, yCoordinate1;
				System.out.println("Enter the x coordinate of the origin of the shape");
				try{
					xCoordinate1 = Double.parseDouble(sc.nextLine());
					if(xCoordinate1 < 0)
						throw new Exception("X Coordinate should be positive number");
				}
				catch(Exception e){
					System.out.println("Enter a valid x coordinate." + e.getMessage());
					continue;
				}
				System.out.println("Enter the y coordinate of the origin of the shape");
				try{
					yCoordinate1 = Double.parseDouble(sc.nextLine());
					if(yCoordinate1 < 0)
						throw new Exception("Y Coordinate should be positive number");
				}
				catch(Exception e){
					System.out.println("Enter a valid Y coordinate." + e.getMessage());
					continue;
				}
				System.out.println("Enter the type of the shape");
				String shapeTypeDelete = sc.nextLine();
				if(!checkValidShape(shapeTypeDelete)){
					System.out.println("Enter the valid shape type");
					continue;
				}
				try{
					screenObject.removeShape(xCoordinate1, yCoordinate1, shapeTypeDelete);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					continue;
				}
				System.out.println("Successfully Deleted");
				break;
			case 3:
				if(listShape.size() == 0)
					System.out.println("Shape list is empty");
				else{
					String shapeType2;
					System.out.println("Enter the shape name");
					shapeType2 = sc.nextLine();
					if(checkValidShape(shapeType2)){
						screenObject.removeAllShape(shapeType2);
						System.out.println("Successfully deleted the given the shape types");
					}
					else{
						System.out.println("Enter the valid shape type");
					}
				}
				break;
			case 4:
				String parameter;
				System.out.println("Enter the name of the parameter on the basis of which you want sorting.");
				System.out.println("Avaiable list of parameters is as follows"
						+ "\nArea"
						+ "\nPerimeter"
						+ "\nOrigin"
						+ "\nTime");
				try{
					parameter = sc.nextLine();
					screenObject.sort(parameter);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					continue;
				}
				System.out.println("Successfully sorted on the basis of " + parameter);
				screenObject.printShapeList(listShape);
				break;
			case 5:
				double xCoordinate2, yCoordinate2;
				System.out.println("Enter the x coordinate");
				try{
					xCoordinate2 = Double.parseDouble(sc.nextLine());
					if(xCoordinate2 < 0)
						throw new Exception("X Coordinate should be positive number");
				}
				catch(Exception e){
					System.out.println("Enter a valid x coordinate." + e.getMessage());
					continue;
				}
				System.out.println("Enter the y coordinate.");
				try{
					yCoordinate2 = Double.parseDouble(sc.nextLine());
					if(yCoordinate2 < 0)
						throw new Exception("Y Coordinate should be positive number");
				}
				catch(Exception e){
					System.out.println("Enter a valid Y coordinate." + e.getMessage());
					continue;
				}
				Point pointToBeChecked = new Point(xCoordinate2, yCoordinate2);
				ArrayList<Shape> result = screenObject.enclosed(pointToBeChecked);
				if(result.size() == 0)
					System.out.println("There is no shape enclosing this specific point");
				else{
					System.out.println("Points enclosing the particular ");
					screenObject.printShapeList(result);
				}
				break;
			case 6:
				if(listShape.size() == 0)
					System.out.println("List is empty");
				else
					screenObject.printShapeList(listShape);
				break;
			case 7:
				loopCheck = true;
				break;
			default:
				System.out.println("Please enter a valid choice");
				break;
			}
			if(loopCheck)
				break;
		}
	}
}
