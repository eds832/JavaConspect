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
	}
	public void method() {
		class MetodClass { }
	}
	public static class NestedClass { }
	public class InnerClass { }
}
class OuterClassOne { }
