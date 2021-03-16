package dsa5Assignment;

public class EmployeeLinkedList {
	Employee head, last;
	/**
	 * Add a employee node to the Linked List
	 * @param salary Salary of Employee
	 * @param age Age of Employee
	 */
	public void addNode(int salary, int age){
		Employee newNode = new Employee(salary, age);
		if(head == null){
			head = last = newNode;
		}
		else{
			last.next = newNode;
			last = newNode;
		}
	}
	/**
	 * Swaps the data of salary and age of current and index nodes
	 * @param current Node
	 * @param index	Node
	 */
	void swapData(Employee current, Employee index){
		int salary = current.salary;
		int age = current.age;
		current.salary = index.salary;
		current.age = index.age;
		index.salary = salary;
		index.age = age;
		index.salary = salary;
	}
	/**
	 * Sorts the Employee Linked List on the basis of their salary and then their age
	 */
	public void sortList(){
		Employee current = head;
		Employee index = null;
		if(head == null)
			return;
		else{
			while(current != null){
				index = current.next;
				while(index != null){
					if(current.salary < index.salary){
						swapData(current, index);
					}
					if(current.salary == index.salary){
						if(current.age > index.age){
							swapData(current, index);
						}
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}
	/**
	 * Displays the list of employees along with their details
	 */
	public void displayList(){
		Employee traverse  = head;
		if(traverse == null){
			System.out.println("List is empty");
			return;
		}
		System.out.println("Emp Id  Emp Salary  Emp Age");
		while(traverse != null){
			System.out.println(traverse.empId + "       " + traverse.salary + "        " + traverse.age);
			traverse = traverse.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeLinkedList e = new EmployeeLinkedList();
		e.addNode(1000, 22);
		e.addNode(9822, 32);
		e.addNode(8700, 22);
		e.addNode(1000, 20);
		e.addNode(12000, 43);
		e.addNode(1000, 21);
		e.addNode(26000, 19);
		e.addNode(500, 32);
		System.out.println("Original List");
		e.displayList();
		e.sortList();
		System.out.println("List after sorting by salary and age");
		e.displayList();
	}

}