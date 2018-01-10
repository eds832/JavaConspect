public enum EnumTest {
	ONE(1), TWO(2), THREE(3);
	
	public int num;
	
	EnumTest(int num) {//default private
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	public static void main(String[ ] args) {
		EnumTest et = EnumTest.ONE;//to init 
		System.out.println (et);
		switch (et) {
			case ONE:
				System.out.println("It is ONE: " + EnumTest.ONE.getNum());
				break;
			case TWO:
				System.out.println("It is TWO: " + EnumTest.TWO.getNum());
				break;
			case THREE:
				System.out.println("It is THREE: " + EnumTest.THREE.getNum());
				break;
			default:
			System.out.println(" Unknown: " + et);
		}
	}
}
