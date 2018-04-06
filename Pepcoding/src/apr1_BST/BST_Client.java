package apr1_BST;

import java.util.*;

public class BST_Client {

	public static void main(String[] args) {		 
		 int[] sa= {12,25,37,50,62,75,87};

		 BST bt=new BST(sa);
		 bt.display();
//		 bt.printInRange(36, 90);
//		 bt.replaceWithSumOfLargerNodes();
//		 bt.display();
//		 bt.lcaBST(62,87);
//		 bt.pairSumTarget(99);
		 bt.add(40);
//		 bt.add(41);
		 bt.display();
		 bt.remove(40);
		 bt.display();
		 
	}
}
