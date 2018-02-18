package feb17_Stack_and_Queue;

import java.util.Scanner;

public class Stack_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scn=new Scanner(System.in);
		int capacity=scn.nextInt();
		Stack stck=new Stack(capacity);
		stck.push(10);
		stck.push(20);
		stck.push(30);
		stck.top();
		System.out.println(stck.pop());
		stck.display();
		stck.push(40);
		stck.push(50);
		stck.display();
	}

}
