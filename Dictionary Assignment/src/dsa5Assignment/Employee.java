package dsa5Assignment;

public class Employee {
	int salary;
	int age;
	int empId;
	Employee next;
	static int counter = 0;
	public Employee(int s, int a){
		counter++;
		salary = s;
		age = a;
		next = null;
		empId = counter;
	}
}
