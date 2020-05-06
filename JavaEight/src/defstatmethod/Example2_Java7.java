package defstatmethod;

class MyClass{
	static int myClassStaticMethod() {
		return 1;
	}
}
public class Example2_Java7 extends MyClass {
	static int testStaticIneritanceClassStaticMethod() {
		return 1;
	}
	
	public static void main(String[] args) {
		Example2_Java7.myClassStaticMethod();
		Example2_Java7.testStaticIneritanceClassStaticMethod();
		MyClass.myClassStaticMethod();
		
		Example2_Java7 t = new Example2_Java7();
		t.testStaticIneritanceClassStaticMethod();
		t.myClassStaticMethod();
		
	}

}
