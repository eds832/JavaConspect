interface InterfaceWithMain {
	double publicStaticFinalVar = Math.random(); //this field is public final static!

	static void staticMethod(int var) {//public
		System.out.println("Interface static method");
	}

	default void notAbstractMethod() {//public
		System.out.println(publicStaticFinalVar + "defaultMethod");
	}

	void abstractMethod(); //this method is public abstract

	static void main(String[] args) { //all methods are public!
		System.out.println(InterfaceWithMain.publicStaticFinalVar);
		InterfaceWithMain n1 = new NotAbstract() {
			@Override
			public void notAbstractMethod() {//Overridden default method
				System.out.println(publicStaticFinalVar + "OverridenMethod");
			}
		};
		n1.notAbstractMethod();
		NotAbstract n2 = new NotAbstract();
		n2.notAbstractMethod();
		n2.abstractMethod();
		staticMethod(7);
		InterfaceWithMain.staticMethod(7);
		n2.staticMethod(7);//illegal static access!
	}
}

class NotAbstract implements InterfaceWithMain {

	@Override
	public void abstractMethod() {
		System.out.println("OverridenAbstractMethod");
	}

	public static void staticMethod(int var) {//it is not Overridden - it calls by Class's name
		System.out.println("New static method");
	}
	
	@Override
	public void notAbstractMethod() {
		System.out.println(publicStaticFinalVar + "OverridenNotAbstractMethod");
		InterfaceWithMain.super.notAbstractMethod();
	}
}