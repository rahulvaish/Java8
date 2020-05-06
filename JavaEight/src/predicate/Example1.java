package predicate;

import java.util.function.Predicate;

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

		// Creating & CALLING predicate [SAMPLE#1]
		Predicate<String> name = n -> n.length() > 4;
		Predicate<String> city = c -> c.startsWith("L");

		System.out.println(name.test("SHAH"));
		System.out.println(city.test("London"));
		System.out.println(name.and(city).test("Lak"));// Rules of name and city combined - length>4 && startsWith("L")

		
		
		
		// Creating & CALLING predicate [SAMPLE#2]
		Predicate<Integer> lesserthan = i -> (i <= 10);
		Predicate<Integer> greaterthan = j -> (j >= 10);
		Predicate<Integer> qualto = k -> (k == 10);

		System.out.println(greaterthan.test(10) && lesserthan.test(10) && qualto.test(10));
		System.out.println(greaterthan.and(lesserthan).and(qualto).test(10));

		
		
		
		// Creating & CALLING predicate [SAMPLE#3]
		Predicate<Person> personName = p -> ((Person)p).getName().startsWith("K");
		Predicate<Person> personCity = p -> ((Person)p).getCity().startsWith("R");
		Person person = new Person("Kritika","Rome");
		
		System.out.println(personName.test(person) && personCity.test(person));
		System.out.println(personName.and(personCity).test(person));

	}

}
