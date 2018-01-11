class ObjectTest {
	public static void main(String ... args) {
		System.out.println(new Object().getClass().getClassLoader());//null
		System.out.println(new Object().getClass().getSuperclass());//null
	}
}