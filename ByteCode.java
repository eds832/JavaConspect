public class ByteCode {
	{
		System.out.println("1-st logic block");
	}
	private int intVar = 7;
	{
		System.out.println("logic block #2");
	}
	static {
		System.out.println("static block #1");
	}	
	private static double doubleVar = 5.0;
	static {
		System.out.println("static block #2");
	}
	public ByteCode() {
		intVar = 10;
	}
}
		