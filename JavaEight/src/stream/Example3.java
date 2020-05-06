package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example3 {
	// This example demonstrate forEach and traditional for loops!
	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("AGRA");
		list.add("DELHI");
		list.add("LUCKNOW");
		list.add("BOMBAY");

		//Because this is list, both .stream() and Stream.of() will work. If it was Array, only Stream.of() would work.
		Stream<String> stream1 = list.stream();
		Stream<List<String>> stream2 = Stream.of(list);

		/*
		 * THE COMMENTED PART WILL NOT WORK 
		 * 
		 * 
		 * for(int i=0;i<stream1.count();i++) {
			System.out.println(stream1.collect(Collectors.toList()).get(i));
		}
		
		for(int i=0;i<stream2.count();i++) {
			System.out.println(stream2.collect(Collectors.toList()).get(i));
		}*/
		
		for(int i=0;i<list.stream().count();i++) {
			System.out.println(list.stream().collect(Collectors.toList()).get(i));
		}
		
		for(int i=0;i<Stream.of(list).count();i++) {
			System.out.println(Stream.of(list).collect(Collectors.toList()).get(i));
		}
		
		
		stream1.forEach(l -> {
			System.out.print(l.length());
		});
		
	}
}
