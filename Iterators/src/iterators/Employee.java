package Iterators;

import java.util.Arrays;

public class Employee {
	String employeeName;
	int employeeId;
	String employeePos;
	int employeeSalary;
	String[] employeeTeam;
	
	public Employee (String name, int id, String pos, int salary, String[] team) {
		this.employeeName = name;
		this.employeePos = pos;
		this.employeeSalary = salary;
		this.employeeId = id;
		this.employeeTeam = team;
	}
	public String getName() {
		return this.employeeName;
	}
	public int getSalary() {
		return this.employeeSalary;
	}
	public String getPosition() {
		return this.employeePos;
	}
	public int getId() {
		return this.employeeId;
	}
	public String[] getTeam() {
		return this.employeeTeam;
	}
	public String toString() {
		return this.employeeName + "\t" + this.employeeId + "\t" + this.employeePos + "\t" + this.employeeSalary + "\t" + Arrays.toString(this.employeeTeam) + "\n";
	}
}
