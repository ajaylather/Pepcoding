package apr22_Median_Priority_Queue;

public class Median_PQ_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median_PQ mpq=new Median_PQ();
		mpq.add(10);
		mpq.add(2);
		mpq.add(15);
		mpq.add(-1);
		mpq.add(17);
		mpq.add(11);
		mpq.add(50);

		
		//-1,2,10,11,15,17,50
		System.out.println(mpq.peek());
		System.out.println(mpq.remove());
		
		//-1,2,10,15,17,50
		System.out.println(mpq.peek());
		System.out.println(mpq.remove());
		
		//-1,2,15,17,50
		System.out.println(mpq.peek());
		System.out.println(mpq.remove());
		
		//-1,2,17,50
		System.out.println(mpq.peek());
		System.out.println(mpq.remove());
		
		//-1,17,50
	}
}
