package jan19;

public class Count_palindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPalindromincStrings("abaabc"));
	}

	public static int countPalindromincStrings(String str) {
		int counter = 0;
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(orbit + axis) == str.charAt(axis - orbit)) {
					counter++;
				}else {
					break;
				}
			}
		}
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int)(orbit + axis)) == str.charAt((int)(axis-orbit))) {
					counter++;
				}else {
					break;
				}
			}
		}
		return counter;
	}
}
