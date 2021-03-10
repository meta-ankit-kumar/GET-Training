package objectsAndCollectionsDSASession4;
import java.util.*;
public class Employee implements Comparable<Employee>{
	// To store the unique employee id
	static Set<Integer> uniqueEmployeeList = new HashSet<Integer>();
	// Collection of employees objects
	static List<Employee> employeeCollection = new ArrayList<Employee>();
	int empId;
	String firstName;
	static Scanner sc = new Scanner(System.in);
	String lastName;
	String address;
	Employee(int id, String fname, String lname, String addr){
		empId = id;
		firstName = fname;
		lastName = lname;
		address = addr;
	}
	/**
	 *  Overriding compareTo present in Comparable interface
	*/
	@Override
	  public int compareTo(Employee employee) {
	    return this.empId - employee.empId;
	  }
	/*
	 * To print the Employee details
	 */
	public static void printEmployees(){
		if(employeeCollection.size() == 0)
			System.out.println("List is empty");
		else{
			System.out.println("Employee Id  | First Name |  Last Name |  Address");
			for(Employee e : employeeCollection){
				System.out.println(e.empId + "     	" + e.firstName + "     " + e.lastName + "     " + e.address);
			}
		}
	}
	/**
	 * Add a new employee to the collection if it is not present in the collection.
	 * @return String which contains the result of operation
	 */
	public static String addNewEmployee(){
//		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Empid");
		try{
			int id = Integer.parseInt(sc.next());
			if(uniqueEmployeeList.contains(id)){
				
				return "Employee ID is already present";
			}
			else{
				String fname, lname;
				System.out.println("Enter Employee's First Name");
				try{
					fname = sc.next();
					for(int i=0; i < fname.length(); i++){
						if(!(Character.isLetter(fname.charAt(i)))){
						
							return "First Name Can Only Contain UpperCase and LowerCase Letters";
						}
					}
					System.out.println("Enter Employee's Last Name");
					lname =sc.next();
					for(int i=0; i < lname.length(); i++){
						if(!(Character.isLetter(lname.charAt(i)))){
						
							return "Last Name Can Only Contain UpperCase and LowerCase Letters";
						}
					}
					String addr;
					System.out.println("Please Enter the Employee Address");
					try{
						addr = sc.next();
						Employee e = new Employee(id, fname, lname, addr);
						uniqueEmployeeList.add(id);
						employeeCollection.add(e);
						
						return "Employee Added successfully";
						
					}
					catch(Exception e){
						return "Please enter a valid Address";
					}
				}
				catch(Exception e){
					
					return "Please Enter a valid Name. Name can only contain alphabates";
				}
			}
		}
		catch(Exception e){
			return "Please enter a valid Integer Employee ID";
		}
	}
	/**
	 * Combines the first name and last name of the employee to get the full name
	 * @param e Employee Object
	 * @return String that is obtained by combining first name and last name
	 */
	public String getEmployeeName(){
		return this.firstName + this.lastName;
	}
	public static void main(String[] args) {
		//Creating some Employee Objects
		Employee e1 = new Employee(1, "Ankit", "Bishnoi", "Sriganganagar");
		Employee e2 = new Employee(32, "Ankit", "Kumar", "Jaipur");
		Employee e3 = new Employee(67, "Amit", "Bishnoi", "Kota");
		Employee e4 = new Employee(87, "Dhruv", "Godara", "Jodhpur");
		Employee e5 = new Employee(98, "Raghav", "Agarwal", "Jaipur");
		Employee.employeeCollection.add(e1);
		Employee.employeeCollection.add(e2);
		Employee.employeeCollection.add(e3);
		Employee.employeeCollection.add(e4);
		Employee.employeeCollection.add(e5);
		Employee.uniqueEmployeeList.add(e1.empId);
		Employee.uniqueEmployeeList.add(e2.empId);
		Employee.uniqueEmployeeList.add(e3.empId);
		Employee.uniqueEmployeeList.add(e4.empId);
		Employee.uniqueEmployeeList.add(e5.empId);
		System.out.println("Available list of Employees");
		Employee.printEmployees();
		int choice;
		System.out.println("1.To add  a new Employee"
				+ "\n2.Perform Natural Sorting"
				+ "\n3.Sorting Based on Employee Name"
				+ "\n4.Print the list of employees"
				+ "\n5.Exit");
		while(true){
			boolean check = false;
			System.out.println("Enter your choice:");
			try{
				
				choice = Integer.parseInt(sc.next());
				switch (choice) {
				case 1:
					System.out.println(Employee.addNewEmployee());
					break;
				case 2:
					Collections.sort(Employee.employeeCollection);
					System.out.println("Sorted");
					Employee.printEmployees();
					break;
				case 3:
					Collections.sort(Employee.employeeCollection, new NameComparator());
					Employee.printEmployees();
					break;
				case 4:
					Employee.printEmployees();
					break;
				case 5:
					check = true;
					break;
				default:
					System.out.println("Please select from the given choices only");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter a valid choice Integer Number"+ e);
			}
			if(check)
				break;
		}
		sc.close();
	}
}
