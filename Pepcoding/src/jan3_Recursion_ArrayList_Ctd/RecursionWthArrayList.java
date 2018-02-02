package jan3_Recursion_ArrayList_Ctd;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecursionWthArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(getss("abc"));
		// System.out.println(getssascii("ab"));
		// System.out.println(getboardpaths(0, 10));
		// System.out.println(getKPC("239"));
		// System.out.println(getpermu("abc"));
		// printss("abc", "");
		// printboardpath(0, 10, "");
		// printKPC("123", "");
		printpermu("abc", "");
	}

	public static ArrayList<String> getss(String str) {
		if (str.equals("")) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recresult = getss(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (String recstr : recresult) {
			myresult.add("" + recstr);
		}
		for (String recstr : recresult) {
			myresult.add(ch + recstr);
		}
		return myresult;
	}
	public static void printss(String que,String asf) {
		if(que.length()==0) {
			System.out.println(asf);
			return;
		}
		char ch=que.charAt(0);
		String ros = que.substring(1);
		printss(ros,asf+"");
		printss(ros, asf+ch);
		return;
	}
	public static ArrayList<String> getssascii(String str) {
		if (str.equals("")) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recresult = getssascii(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (String recstr : recresult) {
			myresult.add("" + recstr);
		}
		for (String recstr : recresult) {
			myresult.add(ch + recstr);
		}
		for (String recstr : recresult) {
			myresult.add((int) ch + recstr);
		}
		return myresult;
	}
	public static void printssascii(String que,String asf) {
		if(que.length()==1) {
			System.out.println(asf);
			return;
		}
		char ch=que.charAt(0);
		String ros = que.substring(1);
		printssascii(ros,asf+"");
		printssascii(ros, asf+ch);
		printssascii(ros, asf+(int)ch);
		return;
	}
	public static ArrayList<String> getboardpaths(int st, int en) {
		if (st > en) {
			ArrayList<String> br1 = new ArrayList<>();
			return br1;
		}
		if (st == en) {
			ArrayList<String> br2 = new ArrayList<>();
			br2.add("");
			return br2;
		}
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 1; i < 7; i++) {
			ArrayList<String> recres = getboardpaths(st + i, en);
			for (String str : recres) {
				myresult.add(i + str);
			}
		}
		return myresult;
	}
	public static void printboardpath(int st,int end,String psf) {
		if(st>end) {
			return;
		}
		if(st==end) {
			System.out.println(psf);
			return;
		}
		for (int i = 1; i < 7;i++) {
			printboardpath(st+i, end, psf+i);
		}
	}

	static String[] codes = { "?", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuvw", "xyz", ".*" };

	public static ArrayList<String> getKPC(String str) {
		if (str.equals("")) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult = getKPC(ros);
		for (String recstr : recresult) {
			for (int i = 0; i < codes[ch-'0'].length(); i++) {
				myresult.add(codes[ch-'0'].charAt(i) + recstr);
			}
		}
		return myresult;
	}
	public static void printKPC(String ques,String asf) {
		if(ques.length()==0) {
			System.out.println(asf);
			return;
		}
		char ch=ques.charAt(0);
		String ros=ques.substring(1);
		for (int i = 0; i < codes[ch-'0'].length(); i++) {
			printKPC(ros,asf+codes[ch-'0'].charAt(i));
		}
	}
	public static ArrayList<String> getpermu(String str){
		if (str.equals("")) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recresult = getpermu(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (String recstr : recresult) {
			for(int i=0;i<=recstr.length();i++) {
				StringBuilder sb=new StringBuilder(recstr);
				sb.insert(i, ch);
				myresult.add(sb.toString());
			}
		}
		return myresult;
	}
	public static void printpermu(String ques,String asf) {
		if(ques.length()==0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		for(int i=0;i<=asf.length();i++) {
			printpermu(ros,asf.substring(0,i)+ch+asf.substring(i));
		}
	}
}
