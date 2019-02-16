package Iterators;

public class employeeIterating {
	
	public static void main(String[] args) {
		createEmployee empl = new createEmployee();
		
		for (Employee employees : empl) {
			System.out.println(employees);
		}
	}

}
