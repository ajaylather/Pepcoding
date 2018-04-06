package mar18_BinaryTree;

import java.util.*;

public class BinaryTree_Client {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		 50 true 25 true 12 false false true 37 false false true 75 true 62 false false true 87 false false
		 
		 int[] preOrder= {50,25,12,37,75,62,87};
		 int[] inOrder= {12,25,37,50,62,75,87};
		 int[] postOrder={12,37,25,62,87,75,50};
		 int[] inOrder1= {10,12,15,25,37,50,62,75,87};
		 int[] postOrder1= {10,15,12,37,25,62,87,75,50};
		 
//		 BinaryTree bt=new BinaryTree(preOrder,inOrder);
		 BinaryTree bt1=new BinaryTree(postOrder1,inOrder1,0);
//		 BinaryTree bt=new BinaryTree();
		 
//		 bt.display();
//		 bt1.display();
//		 System.out.println(bt.size());
//		 System.out.println(bt.size2());
//		 System.out.println(bt.height());
//		 System.out.println(bt.max());
//		 System.out.println(bt.find(57));
//		 bt.preOrder();
//		 bt.preOrderIter();
//		 bt.inOrder();
//		 bt.inOrderIter();
//		 bt.postOrder();
//		 bt.postOrderIter();
//		 bt.levelOrderIter();
//		 System.out.println(bt.diameter());
//		 System.out.println(bt.diameter2());
//		 System.out.println(bt.isBalanced());
//		 System.out.println(bt.isBalanced2());
//		 System.out.println(bt.isBST());
//		 bt.largestBST();
//		 double start = System.currentTimeMillis();
//		 binaries(1500);
//		 double end = System.currentTimeMillis();
//	     System.out.println(end-start);
//		 bt1.removeLeaves();
//		 bt1.siblingLess();
//		 ArrayList<Integer> pathfromroot=bt1.pathFromRoot(15);
//		 System.out.println(pathfromroot);
//		 bt1.display();
		 bt1.targetLeafPath(102);
	}

	static class levelPair {
		int count;
		String binary;
	}

	public static void binaries(int num) {
		LinkedList<levelPair> queue = new LinkedList<BinaryTree_Client.levelPair>();
		levelPair rootp = new levelPair();
		rootp.count = 1;
		rootp.binary = "1";
		queue.addLast(rootp);
		while (true) {
			levelPair removedp = queue.removeFirst();
			System.out.println(removedp.count + " => " + removedp.binary);
			if (removedp.count >= num) {
				break;
			}
			levelPair leftp = new levelPair();
			leftp.count = removedp.count * 2;
			leftp.binary = removedp.binary + "0";
			queue.addLast(leftp);

			levelPair rightp = new levelPair();
			rightp.count = removedp.count * 2 + 1;
			rightp.binary = removedp.binary + "1";
			queue.addLast(rightp);
		}
	}
}
