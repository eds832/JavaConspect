public class ClassFileTest {
	static {
		class StaticBlockClass { }
	}
	{ 
	class LogicBlockClass { }
	}
	ClassFileTest () {
		class InConstructorClass { }
	}
	public static void main(String [] args) {
		class StaticMethodClass { }
		new Object() {
			public String toString() { return "str"; }
		};
	}
	public void method() {
		class MetodClass { }
		new Object() {
			public String toString() { return "str"; }
		};
	}
	public static class NestedClass { }
	public class InnerClass { }
}
class OuterClassOne { }
