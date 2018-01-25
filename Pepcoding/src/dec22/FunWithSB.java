package dec22;

public class FunWithSB {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder("hello");

		// append
		sb2.append('e');
		System.out.println(sb2);

		// add in between
		sb2.insert(6, 'f');
		sb2.insert(2, 'z');
		System.out.println(sb2);

		// get
		char ch = sb2.charAt(2);
		System.out.println(ch);

		// set
		sb2.setCharAt(0, 't');
		System.out.println(sb2);

		// remove
		sb2.deleteCharAt(5);
		System.out.println(sb2);

		// toString
		String str = sb2.toString();
		System.out.println(str);
	}

}
