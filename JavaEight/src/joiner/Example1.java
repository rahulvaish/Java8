package joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Example1 {
	public static void main(String[] args) {

		// FORMAT: public StringJoiner(CharSequence delimiter)
		StringJoiner joinNames0 = new StringJoiner(","); // passing comma(,) as delimiter
		joinNames0.add("aaa");
		joinNames0.add("bbb").add("ccc");
		System.out.println(joinNames0);
		System.out.println(joinNames0.length());

		// FORMAT: public StringJoiner(CharSequence delimiter,CharSequence prefix,CharSequence suffix)
		StringJoiner joinNames1 = new StringJoiner(",", "#", "!"); // passing comma(,) as delimiter
		joinNames1.add("aaa");
		joinNames1.add("bbb").add("ccc");
		System.out.println(joinNames1);
		System.out.println(joinNames1.length());
		
		System.out.println(joinNames0.merge(joinNames1)); // THE PREFIX-POSTFIX did not turned up !

		//___________________________________________________________________
		//Apart from StringJoiner, String Class is also advanced with .join() method.
		// String's join() internally calls StringJoiner
		//___________________________________________________________________

		String stringJoin1=String.join("|","A","B","C");
		System.out.println(stringJoin1);

		

		List<String>strlist=new ArrayList<String>();
		strlist.add("L");
		strlist.add("M");
		strlist.add("N");
		String [] strarray = new String [] {"D","E"};
		String stringJoin3=String.join("|",strarray);
		System.out.println(stringJoin3);
		String stringJoin4=String.join("|",strlist);
		System.out.println(stringJoin4);
		
		//DO NOT USE THIS WAY - THIS DOES NOT WORKS:
		String stringJoin2 = "|";
		stringJoin2 = stringJoin2.join("A");//returns ""
		System.out.println(stringJoin2);
	    //The join() method takes 3 arguments- the delimeter and then varargs. here we have supplied only one 
		// argument, rest two by default becomes "" and "". Now Sting's join method internally calls StringJoiner's join, which on receiving "" and "" makes emptyValue = ""+"" = "".
		// and toString checks if 'value==null' here yes therefore returns emptyValue, hence we receive "". 
		//P.S. The value of 'value' gets initialised when we call add() which call prepareBuilder().
		


	}
}
