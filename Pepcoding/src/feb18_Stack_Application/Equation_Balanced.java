package feb18_Stack_Application;

import feb17_Stack_and_Queue.Stack;

public class Equation_Balanced {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str="{[c+d][a+b])}";
		System.out.println(isEqnBal(str));
	}
	public static boolean isEqnBal(String str) throws Exception{
		Stack st=new Stack(str.length());
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='['||ch=='{'||ch=='(') {
				st.push(ch);
			}
			if((ch==']'||ch=='}'||ch==')')&&st.isEmpty()) {
				return false;
			}
			
			else if(ch==']') {
				if(st.top()=='[') {
					st.pop();
				}
				else return false;
			}
			else if(ch=='}') {
				if(st.top()=='{') {
					st.pop();
				}
				else return false;
			}
			else if(ch==')') {
				if(st.top()=='(') {
					st.pop();
				}
				else return false;
			}
		}
		return st.isEmpty();
	}
}
