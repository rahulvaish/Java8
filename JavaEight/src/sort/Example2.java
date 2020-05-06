package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class People {
	String firstName;
	String secondName;

	public People(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
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
		return "Person [firstName=" + firstName + ", secondName=" + secondName + "]";
	}
}

public class Example2 {
	public static void main(String args[]) {
		//LIST OF OBJECTS OF TYPE 'OBJECTS' !!
		List peopleList = new ArrayList();
		peopleList.add(new People("Rahul", "Vaish"));
		peopleList.add(new People("Shah", "Alam"));
		peopleList.add(new People("Shah", "Jahan"));
		peopleList.add(new People("Akbar", "Oman"));

		peopleList.sort(Comparator.comparing(e -> ((People)e).getFirstName()));

		System.out.println("----------LISTING ALL--------------");
		peopleList.forEach((n) -> System.out.println( ((People)n).getFirstName()));
	}
}
