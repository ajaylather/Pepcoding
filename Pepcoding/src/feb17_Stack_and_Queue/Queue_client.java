package feb17_Stack_and_Queue;

public class Queue_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue que=new Queue();
		que.enQueue(10);
		que.display();
		que.enQueue(20);
		que.display();
		que.enQueue(30);
		que.display();
		System.out.println(que.deQueue());
		que.display();
		System.out.println(que.deQueue());
		que.display();
		que.enQueue(40);
		que.display();
		que.enQueue(50);
		que.display();
		
	}

}
