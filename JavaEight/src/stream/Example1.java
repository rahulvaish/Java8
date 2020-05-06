package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
	String name;
	String city;

	public Person(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + "]";
	}

}

public class Example1 {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("SHAH", "AGRA"));
		personList.add(new Person("AKBAR", "DELHI"));
		personList.add(new Person("NOOR", "LUCKNOW"));
		personList.add(new Person("HUMANYUN", "LAHORE"));

		// WITHOUT STREAM:
		/*
		 * for(Person p : personList) { if(p.getCity().startsWith("L")) {
		 * System.out.println("L===>"+p.getCity()); } }
		 */

		// List->Stream
		Stream<Person> personStream1 = personList.stream(); // PREFERRED WAY
		Stream<List<Person>> personStream2 = Stream.of(personList); // OTHER WAY CREATED A STREAM OF LIST OF PERSON

		// Stream->List (AL)
		List<Person> prsonList1 = personStream1.collect(Collectors.toList());//When Stream created from PREFERRED WAY
		List<List<Person>> prsonList2 = personStream2.collect(Collectors.toList()); // When Stream created from OTHER WAY
		
	    // How to iterate List<Person>
		prsonList1.forEach(i -> System.out.println("-->"+i.getCity()));

		//How to iterate List<List<Person>> 
		prsonList2.forEach(i -> {
			for (Person p : i) {
				System.out.println("--<"+p.getCity());
			}
		});
		
		
		// Array -> Stream -> List -> Iterate
		// We don't have arr_reference.stream(). Instead, we have Arrays.stream().  Stream.of() is universal!
		Person[] persons = { new Person("Raj", "SF"), new Person("Rah", "LA") };
		List<Person> prsnList = Arrays.stream(persons).collect(Collectors.toList());
		prsnList.forEach(n -> System.out.print(n.getCity()));
		
		// Array -> Stream -> List -> Iterate
		Person[] persons1 = { new Person("Raj", "SF"), new Person("Rah", "LA") };
		List<Person> prsnList1 = Stream.of(persons1).collect(Collectors.toList());
		prsnList1.forEach(n -> System.out.print(n.getCity()));
	
		// Array -> Stream -> Filter -> List -> Iterate
		Person[] persons2 = { new Person("Raj", "SF"), new Person("Rah", "LA") };
		List<Person> prsnList2 = Arrays.stream(persons2).filter(p->p.getCity().startsWith("L")).collect(Collectors.toList());
		prsnList2.forEach(n -> System.out.print(n.getCity()));
		
		
		//==============================ONE THING TO OBSERVER IS RETURN TYPE B/W LIST & ARRAY===========================
		List<List<Person>> persns5 = Stream.of(personList).collect(Collectors.toList());
		List<Person> prsnList5 =     Stream.of(persons1).collect(Collectors.toList());
		
		//==============================================================================================================
		
		// String->CharArray->Stream
		String str = "RAHUL";
		Stream<char[]> charraypersonStream = Stream.of(str.toCharArray());


		// WITH STREAMS: S-F-C
		List<Person> personList3 = personList.stream().filter(p -> p.getCity().startsWith("L")).collect(Collectors.toList());
		System.out.println(personList3);

		// WITH STREAMS: S-C
		List<Person> personList4 = personList.stream().collect(Collectors.toList());
		System.out.println(personList4);
		
		// --------------------------------------------------------------------------
		// forEach works for List/Stream | Not for Arrays refs* But for Arrays Class
		// --------------------------------------------------------------------------
		
		// WITH STREAM:S-F-M-C-FE
		personList.stream().filter(p -> p.getCity().startsWith("L")).map(p -> p.getCity()).collect(Collectors.toList()).forEach(p-> System.out.println("======="+p));

		// WITH STREAMS: S-F-C-FE
		personList.stream().filter(p -> p.getCity().startsWith("L")).collect(Collectors.toList()).forEach(p-> System.out.println("======="+p));
			
		// WITH STREAM:S-F-FE
		personList.stream().filter(p -> p.getCity().startsWith("L")).forEach(p -> System.out.println(p.getCity()));

		// WITH STREAM:S-FE
		personList.stream().forEach(p -> System.out.println(p.city));
				
		// WITH STREAMS: S-C-FE
		personList.stream().collect(Collectors.toList()).forEach(p-> System.out.println("======="+p.getCity()));
		

		
		
		
		
		// -----------------------------------------------
		// map | reduce | filter in Java 8 streams
		// -----------------------------------------------
		
	
		//Inside map() compute something which returns further :
		List<String> one = personList.stream().map(p -> p.getName().toLowerCase()).collect(Collectors.toList());
		List<Boolean> two = personList.stream().map(p -> p.getName().startsWith("A")).collect(Collectors.toList());
		List<Person> three = personList.stream().map(p -> new Person(p.getName(),"")).collect(Collectors.toList());

		//Inside filter() compute something which returns the same type object/s (Person) :
		List<Person> four = personList.stream().filter(p -> p.getName().startsWith("A")).collect(Collectors.toList());
		
		// Inside reduce() compute and it returns single value.
		Optional<Person> five = personList.stream().reduce((p1, p2) -> p1.getName().length() > p2.getName().length() ? p1 : p2);// .collect(Collectors.toList());
		System.out.println("----------<>"+five.get().getName());
		
		Optional<Person> six = personList.stream().reduce((p1, p2) -> p1.getName().startsWith("R")  ? p1 : p2);
		System.out.println("----------<>"+six.get().getName());
		
		Optional<String> seven = personList.stream().map(p -> p.getName()).collect(Collectors.toList()).stream().reduce((p1, p2) -> p1 + "-" + p2);
		System.out.println("----------<>" + seven.get());
		
	}

}
