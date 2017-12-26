class Simple {
	public static void main(String [] args) {
		printHello(args);
	}
	
	public static void printHello(String [] args) {
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println("Hello!");
	}
}
