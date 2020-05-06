package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exmaple2 {
	public static void main(String args[]) {

		//WHEN DEALING WITH PRIMITIVES
		int nums [] = {1,2,3,4,5};
		List<Integer> ints = IntStream.of(nums).boxed().collect(Collectors.toList());
		ints.forEach(i -> System.out.println(i));

		// We don't have arr_reference.stream(). Instead, we have Arrays.stream().  Stream.of() is universal!
		
		// Array -> Stream[OTHER WAY] -> List -> Iterate 
		int[] nums1 = { 5, 4, 3, 2, 1 };
		List<int[]> intvals1 = Stream.of(nums1).collect(Collectors.toList());
		intvals1.forEach(i -> System.out.println(i));
		
		// Array -> Stream -> Filter -> List -> Iterate 
		int[] nums2 = { 5, 4, 3, 2, 1 };
		List<Integer> intvals2 = Arrays.stream(nums2).filter(n -> n > 4).boxed().collect(Collectors.toList());;
		intvals2.forEach(i -> System.out.println(i));
			
	}
}
