package defstatmethod;

interface MyInterface{
	static int myInterfaceStaticMethod() {
		return 1;
	}
}
public class Example3_Java8 extends MyClass {
	static int example3StaticMethod() {
		return 1;
	}
	
	public static void main(String[] args) {
		//Example3_Java8.myInterfaceStaticMethod();
		Example3_Java8.example3StaticMethod();
		MyInterface.myInterfaceStaticMethod();

		Example3_Java8 t = new Example3_Java8();
		t.example3StaticMethod();
		//t.myInterfaceStaticMethod();
		
	}

}
