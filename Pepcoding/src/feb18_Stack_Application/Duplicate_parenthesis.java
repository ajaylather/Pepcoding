package feb18_Stack_Application;

import feb17_Stack_and_Queue.Stack;

public class Duplicate_parenthesis {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str = "(((a+b)+c)+d)";
		System.out.println(isParenDupl(str));
	}

	public static boolean isParenDupl(String str) throws Exception{
		Stack st = new Stack(str.length());

		for (int i = 0; i < str.length(); i++) {
			int charct = 0;
			char ch = str.charAt(i);
			if (ch == '(') {
				st.push(ch);
			} else if (ch != '(' && ch != ')') {
				charct++;
			} else if (ch == ')') {
				if (charct != 0) {
					charct = 0;
					st.pop();
				} else
					return true;
			}
		}
		return false;
	}
}
