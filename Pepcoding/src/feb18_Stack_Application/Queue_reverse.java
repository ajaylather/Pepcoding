package feb18_Stack_Application;
import feb17_Stack_and_Queue.*;
public class Queue_reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5};
		Queue qu=new Queue(arr); 
		Stack st=new Stack(qu.size());
		//qu.display();
		//QueueReverseUsingStack(qu, st);
		//Stack st1=new Stack(arr);
		Stack st1=new Stack(arr);
  		Queue qu1=new Queue(5);
//		st1.push(5);
//		st1.push(4);
//		st1.push(3);
//		st1.push(2);
//		st1.push(1);
		st1.display();
		StackReverseUsingQueue(st1, qu1);
		st1.display();
	}
	public static void QueueReverseUsingStack(Queue qu,Stack st) {
		if(qu.size()==0) {
			return;
		}
		st.push(qu.deQueue());
		QueueReverseUsingStack(qu, st);
		qu.enQueue(st.pop());
	}
	
	public static void StackReverseUsingQueue(Stack st,Queue qu) {
		if(st.size()==0) {
			return;
		}
		qu.enQueue(st.pop());
		StackReverseUsingQueue(st, qu);
		st.push(qu.deQueue());
	}
}
