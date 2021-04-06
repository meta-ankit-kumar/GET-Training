package employee;


/**
 * Main App
 * @author ankit.kumar_metacube
 *
 */
public class MainApp {

	public static void main(String[] args) {
		EmployeeList employeeList = new EmployeeList();
		EmployeeList employeeList2 = new EmployeeList();
		EmployeeList employeeList3 = new EmployeeList();
		
		try{
			employeeList.addEmployee("Emp1", 10000.0, 24 );
			employeeList.addEmployee("Emp2", 20000.0, 25);
			employeeList.addEmployee("Emp3", 30000.0, 23);
			employeeList.addEmployee("Emp4", 40000.0, 25);
			
			employeeList2.addEmployee("Emp1", 40000.0, 24 );
			employeeList2.addEmployee("Emp2", 30000.0, 25);
			employeeList2.addEmployee("Emp3", 20000.0, 23);
			employeeList2.addEmployee("Emp4", 10000.0, 25);
			
			employeeList3.addEmployee("Emp1", 40000.0, 25 );
			employeeList3.addEmployee("Emp2", 20000.0, 25);
			employeeList3.addEmployee("Emp3", 20000.0, 23);
			employeeList3.addEmployee("Emp4", 40000.0, 24);
			
			System.out.println("\nLIST 1 : \n");
			System.out.print("Before Sort: \n");
			employeeList.printEmployeeLinkList();
			
			employeeList.sortList();
			
			System.out.print("\nAfter Sort: \n");
			employeeList.printEmployeeLinkList();
			
			System.out.println("\nLIST 2 : \n");
			System.out.print("Before Sort: \n");
			employeeList2.printEmployeeLinkList();
			
			employeeList2.sortList();
			
			System.out.print("\nAfter Sort: \n");
			employeeList2.printEmployeeLinkList();
			
			System.out.println("\nLIST 3 : \n");
			System.out.print("Before Sort: \n");
			employeeList3.printEmployeeLinkList();
			
			employeeList3.sortList();
			
			System.out.print("\nAfter Sort: \n");
			employeeList3.printEmployeeLinkList();

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			}

}

