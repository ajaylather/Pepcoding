package feb18_Stack_Application;
import feb17_Stack_and_Queue.*;
public class Reverse {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5};
		Queue qu=new Queue(arr); 
		Stack st1=new Stack(qu.size());
		//qu.display();
		//QueueReverseUsingStack(qu, st);
		//Stack st1=new Stack(arr);
  		Queue qu1=new Queue(5);
		st1.push(5);
		st1.push(4);
		st1.push(3);
		st1.push(2);
		st1.push(1);
		st1.display();
		//StackReverseUsingQueue(st1, qu1);
		StackReverseUsingStack(st1, new Stack(), 0);
		st1.display();
	}
	public static void QueueReverseUsingStack(Queue qu,Stack st) throws Exception{
		if(qu.size()==0) {
			return;
		}
		st.push(qu.deQueue());
		QueueReverseUsingStack(qu, st);
		qu.enQueue(st.pop());
	}
	
	public static void StackReverseUsingQueue(Stack st,Queue qu) throws Exception{
		if(st.size()==0) {
			return;
		}
		qu.enQueue(st.pop());
		StackReverseUsingQueue(st, qu);
		st.push(qu.deQueue());
	}
	
	public static void StackReverseUsingStack(Stack stack,Stack helper,int idx) throws Exception{
		if(stack.isEmpty()){
			return;
		}
		int item=stack.pop();
		StackReverseUsingStack(stack, helper, idx+1);
		helper.push(item);
		if(idx==0){
			while(!helper.isEmpty()){
				stack.push(helper.pop());
			}
		}
	}
}
