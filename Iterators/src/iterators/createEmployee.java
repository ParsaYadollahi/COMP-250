package Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class createEmployee implements Iterable<Employee> {
	
	List<Employee> empls = new ArrayList<Employee>();
	
	public createEmployee() {
//		Create the employees
		Employee first = new Employee("Parsa", 1, "Slave" , 40000, new String[] {});
		Employee second =  new Employee("Abbas", 2 , "Dev", 120000, new String[] {"Piatti", "Swarez"});
		Employee third = new Employee("Big flex", 3, "Boss", 200000, new String[] {"Everyone", "Including"});
		empls.add(first);
		empls.add(second);
		empls.add(third);
	}
	
	@Override
	public Iterator<Employee> iterator(){
		return empls.iterator();
	}
}
