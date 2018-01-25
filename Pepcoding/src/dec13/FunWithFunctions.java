package dec13;

public class FunWithFunctions {

	public static void main(String[] args) {
		// Part 1 - Normal Function
		// System.out.println("Hello World");
		// HelloFun();

		// Part 2 - Multiple calls
		// System.out.println("Hello World");
		// HelloFun();
		// System.out.println("Hello World");
		// HelloFun();

		// Part 3 - Multiple functions
		// System.out.println("Hello World");
		// HelloFun();
		// HelloGun();

		// Part 4 - Function making call to another function
		// System.out.println("Hello World");
		// HelloNestedFun();
		// System.out.println("Hello World");
		// HelloNestedFun();

		// System.out.println("Hello World");
		// HelloFunWithParams("Hello from main");

		// Part 6 - Function with return value
		System.out.println("Hello World");
		String value = HelloFunWithReturns("Hello from main");
		System.out.println(value);
	}

	public static void HelloFun() {
		System.out.println("Hello Fun");
	}

	public static void HelloGun() {
		System.out.println("Hello Gun");
	}

	public static void HelloNestedFun() {
		System.out.println("Hello Nested Fun");
		HelloFun();

		System.out.println("Hello Nested Fun");
		HelloGun();
	}

	public static void HelloFunWithParams(String msg) {
		System.out.println("Your message is : " + msg);
	}

	public static String HelloFunWithReturns(String msg) {
		String retVal = "I did your work";

		HelloFunWithParams(msg);

		return retVal;
	}

}
