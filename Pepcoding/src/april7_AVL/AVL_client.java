package april7_AVL;

public class AVL_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] sa= {12,25,37,50,62,75,87};
		 AVL avl=new AVL(sa);
//		 avl.display();
		 avl.add(40);
		 avl.add(45);
		 avl.display();
		 avl.remove(12);
		 avl.display();
	}
	
}
