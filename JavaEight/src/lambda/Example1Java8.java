package lambda;

// In Java8 there is a concept introduced as Functional Interface. 
// [1] Functional interfaces (@FunctionalInterface) permits exactly one abstract method. because of which they are also called Single Abstract Method interfaces (SAM Interfaces).
// [2] Default Method Body is permissible in all interface design (Normal Interface or Functional Interface) of Java 8
// [3] Static Method Body is permissible in all interface design (Normal Interface or Functional Interface) of Java 8

@FunctionalInterface
interface Calculator1 {
	void greetCalculator(); // Abstract Method (Definition)
	//void greetCalculator2(); // ERROR - Functional Interface can't have more than 1 method definition.
}

//==============================================

interface CalculatorInterface { // This is a normal interface - No @FunctionalInterface annotation
	void greetCalculator1();  // Abstract Method - Permissible
	void greetCalculator2(); // Abstract Method - Permissible
}

//==============================================
@FunctionalInterface
interface Calculator2 {  // This is a Functional Interface
	int sum(int a, int b); // Abstract Method (Definition)
	
	default int defaultFunction() { // Default Method Body is permissible in all interface design of Java 8
		return 0;
	}
   
    static int staticFunction() { // Default Method Body is permissible in all interface design of Java 8
		return 0;
	}
    
    @Override
    public boolean equals(Object obj); //Overridden from Object class
}

//==============================================
//@FunctionalInterface
interface Calculator3 {
	default int defaultFunction() {   // Default Method Body is permissible in all interface design (Normal Interface or Functional Interface) of Java 8
		return 0;
	}
	static int staticFunction() { // Static Method Body is permissible in all interface design (Normal Interface or Functional Interface) of Java 8
		return 0;
	}
}

class Calculator3Impl implements Calculator3{
	
}
//===============================================

public class Example1Java8 {

	public static void main(String[] args) {

		//EVOLUTION#1
		/*Calculator1 cal1 = new Calculator1() {

			@Override
			public void greetCalculator() {
				System.out.println("Hi Calculator");
			}
		};*/
		
		//EVOLUTION#2
		/*Calculator1 cal1 = () {
		@Override
		public void greetCalculator() {
			System.out.println("Hi Calculator");
		}
	    };*/
		
		//EVOLUTION#3
		/*Calculator1 cal1 = () {
			System.out.println("Hi Calculator");
	    };*/
		
		//EVOLUTION#4
		/*Calculator1 cal1 = () -> {
				System.out.println("Hi Calculator");
		};*/
		
		//EVOLUTION#5
		Calculator1 cal1 = () -> System.out.println("Hi Calculator");
		//NOTE[ABOVE]:
		// () means no parameters. 
		// After -> The statement is returning nothing, therefore void.
		// Interface Calculator1 has a method that satisfies this requirement, therefore all is well !
		Calculator2 cal2 = (a,b) -> {
			if(a<0 || b<0) {
				return 0;
			}
			return a+b;
		};
		//NOTE[ABOVE]:
		// (a,b) means two parameters are expected. 
		// After -> The statement is returning an integer value.
		// Interface Calculator2 has a method that satisfies this requirement, therefore all is well !
		
		cal1.greetCalculator();
		System.out.println(cal2.sum(3, 3));
		System.out.println(cal2.defaultFunction());
		System.out.println(Calculator2.staticFunction());
		//==================START[NFI]=======================
		Calculator3 cal3 = new Calculator3Impl();
		System.out.println(cal3.defaultFunction());
		System.out.println(Calculator3.staticFunction());
		//==================END[NFI]=========================
		
	}
}





