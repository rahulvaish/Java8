package defstatmethod;

interface myDefInterface {
	// Default Method Body is permissible in all interface design (Normal Interface
	// or Functional Interface) of Java 8
	default void myDefintefacemethod() {
		System.out.println("Printing from interface");
	}

	// Normal method declaration
	public void myintefacemethod1();
}

public class Example1 implements myDefInterface {

	public void myDefintefacemethod() {
		System.out.println("Printing from Example1");
	}

	@Override
	public void myintefacemethod1() {
		System.out.println("Giving Body to method defination present in myinterface :)");

	}

	public static void main(String[] args) {
		Example1 ex1 = new Example1();
		ex1.myDefintefacemethod();
		ex1.myintefacemethod1();

	}

}
