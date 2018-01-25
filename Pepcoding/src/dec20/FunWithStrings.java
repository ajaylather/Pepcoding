package dec20;

public class FunWithStrings {

	public static void main(String[] args) {
		// String str;
		//
		// str = "Hello";
		// System.out.println(str);
		//
		// System.out.println(str.length());
		// System.out.println(str.charAt(5));
		// System.out.println(str.charAt(str.length() - 1));

		// System.out.println(str.substring(2, 4));
		// System.out.println(str.substring(2, 3));
		// System.out.println(str.substring(2, 2));
		// System.out.println(str.substring(2, 1));
		// System.out.println(str.substring(2, 5));
		// System.out.println(str.substring(2, 6));
		// System.out.println(str.substring(2));

		// Part 8
		// String s1 = "Hello";
		// String s2 = s1;
		// String s3 = "Hello";
		// String s4 = new String("Hello");
		//
		// System.out.println((s1 == s2) + ", " + s1.equals(s2));
		// System.out.println((s1 == s3) + ", " + s1.equals(s3));
		// System.out.println((s1 == s4) + ", " + s1.equals(s4));
		//
		// s1 = "malayalam";
		// String s5 = s1.replace("l", "t");
		// System.out.println(s5);

		stringPoorPerformance();
		stringPoorPerformanceManaged();
	}

	public static void stringPoorPerformance() {
		long start = System.currentTimeMillis();

		int n = 40000;
		String s = "";
		for (int i = 1; i <= n; i++) {
			s = s + i;
		}

		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println(duration);
		// System.out.println(s);
	}

	public static void stringPoorPerformanceManaged() {
		long start = System.currentTimeMillis();

		int n = 40000;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(i);
		}

		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println(duration);
		// System.out.println(sb);
	}

}
