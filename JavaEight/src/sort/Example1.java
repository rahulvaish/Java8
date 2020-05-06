package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee{
    private int id;
    private String firstName;
    private String secondName;
        
	public Employee(int id, String firstName, String secondName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + "]";
	}
	
}


public class Example1 {
	public static void main(String args[]) {
		List<Employee> emplist = new ArrayList<Employee>();
		Employee emp1 = new Employee(1,"Rahul","Vaish");
		Employee emp2 = new Employee(2,"Rajan","Gupta");
		Employee emp3 = new Employee(3,"Haris","Aggarwal");
		Employee emp4 = new Employee(4,"Hardayal","Singh");
		Employee emp5 = new Employee(5,"Harish","Pandey");
		
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);
		emplist.add(emp4);
		emplist.add(emp5);
		
		emplist.sort(Comparator.comparing(e -> e.getFirstName()));
		for(Employee e: emplist) {
			System.out.println(e.getFirstName());
		}
		System.out.println("==============");
		emplist.sort(Comparator.comparing(e -> e.getSecondName()));
		for(Employee e: emplist) {
			System.out.println(e.getSecondName());
		}
		System.out.println("==============");
		emplist.sort(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSecondName));
		for(Employee e: emplist) {
			System.out.println(e.getSecondName());
		}
		
		
		
		
		System.out.println("==============================================");
		//Sort all employees by first name; And then reversed
		//WAY#1:
		emplist.sort(Comparator.comparing(e -> e.getSecondName()));
		Collections.reverse(emplist);//I FIND THIS EASY
		for(Employee e: emplist) {
			System.out.println(e.getSecondName());
		}
		
		//WAY#2:
	    Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
	    emplist.sort(comparator.reversed());
	    for(Employee e: emplist) {
			System.out.println(e.getFirstName());
		}
	}
}
