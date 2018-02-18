package feb_18_Stack_Application;

import feb17_Stack_and_Queue.Stack;

public class Equation_Balanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isEqnBal("{[c+d][a+b]}"));
	}
	public static boolean isEqnBal(String str) {
		Stack st=new Stack(str.length());
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='['||ch=='{'||ch=='(') {
				st.push(ch);
			}
			if(ch==']'&&st.top()=='[') {
				st.pop();
			}
			if(ch=='}'&&st.top()=='{') {
				st.pop();
			}
			if(ch==')'&&st.top()=='(') {
				st.pop();
			}
		}
		return st.isEmpty();
	}
}
