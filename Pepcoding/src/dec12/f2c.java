package dec12;

public class f2c {

	public static void main(String[] args) {
		// System.out.println(5 / 2);
		// System.out.println(5.0 / 2);
		int minf = 0, maxf = 300, stepf = 20;
		int far = minf;
		while (far <= maxf) {
			int cel = (int) (5.0 / 9 * (far - 32));
			// System.out.println(far + ' ' + cel);
			System.out.println(far + " " + cel);
			far += stepf;
		}
	}

}
