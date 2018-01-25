package dec14;

public class f2c {

	public static void main(String[] args) {
		// System.out.println(5 / 2);
		// System.out.println(5.0 / 2);

		int farMin = 0, farMax = 300, farStep = 20;
		int far = farMin;
		while (far <= farMax) {
			int cel = (int) (5.0 / 9 * (far - 32));
			System.out.println(far + " " + cel);
			far += farStep;
		}
	}

}
