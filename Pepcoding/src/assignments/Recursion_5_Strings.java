package assignments;

import java.util.Scanner;

public class Recursion_5_Strings {

	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String str=scn.next();
		// int div=scn.nextInt();
		String str1 = scn.next();
		int i = scn.nextInt();
		// String str2=scn.next();
		// System.out.println(sum(str));
		// System.out.println(division(str,div));
		// System.out.println(chkreverse(str1, str2));
		// System.out.println(chkreverse(str1, str2,0));
		// System.out.println(chkpal(str1, 0));
		String result= duplStar(str1, 0);
		System.out.println(result.charAt(i));
		System.out.println(result);
		//System.out.println(duplRemove(str1, 0));
	}

	public static int sum(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int ch = (int) (str.charAt(0)) - 48;
		int sumn1 = sum(str.substring(1));
		int sum = ch + sumn1;
		return sum;
	}

	public static long StrToNum(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int ch = (int) str.charAt(0) - 48;
		String ros = str.substring(1);
		long numk1 = StrToNum(ros);
		long num = numk1 + ch * (long) Math.pow(10, ros.length());
		return num;
	}

	public static long division(String str, int div) {
		return StrToNum(str) / div;
	}

	public static boolean chkreverse(String str1, String str2, int i) {
		if (i == str1.length()) {
			return true;
		}
		if (str1.charAt(i) != str2.charAt(str2.length() - 1 - i)) {
			return false;
		}
		boolean chkrest = chkreverse(str1, str2, i + 1);
		return chkrest;
	}

	public static boolean chkreverse(String str1, String str2) {
		if (str1.length() == 0) {
			return true;
		}
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(str2.length() - 1);
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(0, str2.length() - 1);
		boolean chkros = chkreverse(ros1, ros2);
		if (ch1 != ch2) {
			return false;
		}
		return chkros;
	}

	public static boolean chkpal(String str, int i) {
		if (i == str.length() / 2) {
			return true;
		}
		if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
			return false;
		}
		boolean chkpal = chkpal(str, i + 1);
		return chkpal;
	}

	public static String duplStar(String str, int si) {
		if(si==str.length()-1) {
			return str.charAt(si)+"";
		}
		char ch = str.charAt(si);
		char nxt = str.charAt(si + 1);
		String recresult = duplStar(str, si + 1);
		if (ch == nxt) {
			return ch + "*"+recresult;
		} else
			return ch + recresult;
	}
	public static String duplRemove(String str, int si) {
		if(si==str.length()-1) {
			return str.charAt(si)+"";
		}
		char ch = str.charAt(si);
		char nxt = str.charAt(si + 1);
		String recresult = duplRemove(str, si + 1);
		if (ch == nxt) {
			return recresult;
		} else
			return ch + recresult;
	}
	public static String putChend(String str, int si,char ch,String result) {
		if (str.length() == 0) {
			return "";
		}
		if (si >= str.length()) {
			return result;
		}
		if (str.charAt(si) != ch) {
			return result+str.charAt(si)+putChend(str, si+1,ch,result);
		}
		else{
			return result+putChend(str, si+1,ch,result)+ch;
		}
	}
}
