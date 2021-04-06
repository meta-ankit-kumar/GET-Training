package employee;

/**
 * Linked list representation of employee list
 * @author ankit.kumar_metacube
 *
 */
public class EmployeeList {
	
	private EmployeeNode head;
	private EmployeeNode last;
	private int size = 0;
	
	/**
	 * Method to add employee to List
	 * @param id Employee Id
	 * @param salary Salary of the employee
	 * @param age Age of the employee
	 * @throws Exception if invalid input is passed
	 */
	public void addEmployee(String id, Double salary , int age) throws Exception{
		if(id == null ||  salary == null || age <= 0 || salary <= 0){
			throw new Exception("Invalid Input");
		}
		EmployeeNode node = new EmployeeNode(id , salary , age);
		size += 1;
		if(head == null){
			head = node;
			last = node;
			return ;
		}
		last.next = node;
		last = last.next;
	}
	
	/**
	 * Method to get size of LIst
	 * @return size of the list
	 */
	public int sizeOfEmployeeLinkList(){
		return size;
	}
	
	/**
	 * method for printing Employee linked list
	 */
	public void printEmployeeLinkList(){
		if (head == null){
			System.out.println("Empty List");
			return ;
		}
		EmployeeNode currNode = head;
		while (currNode != null){
			System.out.println("ID : " + currNode.id +"     Salary : " +  currNode.salary + "     Age : " +  currNode.age);
			currNode = currNode.next;
		}
	}
	
	/**
	 * Method to get head node
	 * @return EmployeeNode, head node
	 */
	public EmployeeNode getHead(){
		return head;
	}
	
	/**
	 * Method to get Last Node of List
	 * @return EmployeeNode, last node
	 */
	public EmployeeNode getLast(){
		return last;
	}
	
	/**
	 * Method to sort Employee List
	 */
	public void sortList() {
		EmployeeNode last = this.head;
		while(last.next != null){
			last = last.next;
		}
        quickSort(head,last);
    }
    
	/**
	 * Method to partition List 
	 * @param start EmployeeNode 
	 * @param end EmployeeNode 
	 * @return EmployeeNode, partition Node (Position of the pivot element)
	 */
	private EmployeeNode paritionLast(EmployeeNode start, EmployeeNode end)
    {
        if (start == end || start == null || end == null)
            return start;
 
        EmployeeNode pivot_prev = start;
        EmployeeNode curr = start;
        double  salaryPivot = end.salary;
        double  agePivot = end.age;
 
        while (start != end) {
            if (start.salary > salaryPivot || (start.salary == salaryPivot && start.age < agePivot)) {
                pivot_prev = curr;
                double tempSalary = curr.salary;
                int tempAge = curr.age;
                String tempId = curr.id;
                curr.salary = start.salary;
                curr.age = start.age;
                curr.id = start.id;
                start.salary = tempSalary;
                start.age = tempAge;
                start.id = tempId;
                curr = curr.next;
            }
            start = start.next;
        }
        
        double tempSalary = curr.salary;
        int tempAge = curr.age;
        String tempId = curr.id;
        curr.salary = start.salary;
        curr.age = start.age;
        curr.id = start.id;
        end.salary = tempSalary;
        end.age = tempAge;
        end.id = tempId;
        
        return pivot_prev;
    }
 
	/**
	 * Method to Sort List using Quick Sort
	 * @param start EmployeeNode,  startNode
	 * @param end EmployeeNode, endNode
	 */
    void quickSort(EmployeeNode start, EmployeeNode end)
    {
        if(start == null || start == end || start == end.next )
            return;
        
        EmployeeNode pivot_prev = paritionLast(start, end);
        quickSort(start, pivot_prev);
     
        if (pivot_prev != null && pivot_prev == start)
        	quickSort(pivot_prev.next, end);
 
       
        else if (pivot_prev != null
                 && pivot_prev.next != null)
        	quickSort(pivot_prev.next.next, end);
    }
}