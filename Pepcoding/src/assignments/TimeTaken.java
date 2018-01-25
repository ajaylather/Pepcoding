package assignments;

public class TimeTaken {
	public static long start = 0;
	public static long end = 0;

	public static void startAlgo() {
		start = System.currentTimeMillis();
	}

	public static long endAlgo() {
		end = System.currentTimeMillis();
		return end - start;
	}
}
