package maths;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Computing {

	public static void main(String[] args) {
	     
		String anotherDate = "Apr 04 2016";
		 
		DateTimeFormatter df = DateTimeFormatter.ofPattern("mm dd yyyy");
		LocalDate random = LocalDate.parse(anotherDate, df);
		 
		System.out.println(anotherDate + " parses as " + random);
	}

}
