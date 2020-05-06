package optional;

import java.util.Optional;

public class Example1 {
	public static void main(String[] args) {
	    String str0 = "RAHUL";  
        String lowercaseString0 = str0.toLowerCase();  
        System.out.println(lowercaseString0);  
        
	    String str1 = "";  
        String lowercaseString1 = str1.toLowerCase();  
        System.out.println(lowercaseString1);  
        
        /*String str2 = null;  
        String lowercaseString2 = str2.toLowerCase();  
        System.out.println(lowercaseString2);*/
        
        String str3 = "";
        Optional<String> checknull1 = Optional.ofNullable(str3);
		if (checknull1.isPresent()) {
			String lowercaseString3 = str3.toLowerCase();
			System.out.println(lowercaseString1);
		} else {
			System.out.println("str3 is absent");
		}
         
        
		String str4 = null;
		Optional<String> checknull2 = Optional.ofNullable(str4);
		if (checknull2.isPresent()) {
			String lowercaseString4 = str4.toLowerCase();
			System.out.println(lowercaseString4);
		} else {
			System.out.println("str4 is absent");
		}
		
		String str5 = "";
		Optional<String> checknull = Optional.ofNullable(str5);
		System.out.println(checknull);
        
		
		/*
		 * .of() is used for not null values! Practically useless for me :P
		 * 
		 * String str6 = null;
		Optional<String> checknull3 = Optional.of(str6);
		if (checknull3.isPresent()) {
			String lowercaseString6 = str6.toLowerCase();
			System.out.println(lowercaseString6);
		} else {
			System.out.println("str6 is absent");
		}*/
		
		/*String str6 = "TAJ";
		Optional<String> checknull3 = Optional.of(str6);
		if (checknull3.isPresent()) {
			String lowercaseString6 = str6.toLowerCase();
			System.out.println(lowercaseString6);
		} else {
			System.out.println("str6 is absent");
		}*/
		
		
	}
}
