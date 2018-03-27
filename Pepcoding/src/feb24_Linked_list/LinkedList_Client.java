package feb24_Linked_list;

public class LinkedList_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.addLast(60);
		ll.addLast(70);
//		ll.display();
//		ll.addFirst(500);
//		ll.display();
//		ll.AddAt(2, -55);
//		ll.display();
//		ll.removeFirst();
//		ll.display();
//		ll.removeLast();
//		ll.display();
//		ll.removeAt(1);
//		ll.display();
		
//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
//		System.out.println(ll.getValueAt(2));
//		System.out.println(ll.getValueAt(5));
		
//		ll.displayReverse();
//		ll.reverseDataIterative();
		ll.display();
//		ll.reversePointerIterative();
//		ll.reversePointerRecursive();
//		ll.reverseDataRecursive();
		ll.fold();
		System.out.println("Fold");
		ll.display();
	}

}
