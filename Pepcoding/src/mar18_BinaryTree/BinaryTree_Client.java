package mar18_BinaryTree;

import java.util.LinkedList;

public class BinaryTree_Client {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		 50 true 25 true 12 false false true 37 false false true 75 true 62 false false true 87 false false
		 BinaryTree bt=new BinaryTree();
//		 bt.display();
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
		 System.out.println(bt.isBST());
		 bt.largestBST();
//		double start = System.currentTimeMillis();
//		binaries(1500);
//		double end = System.currentTimeMillis();
//	    System.out.println(end-start);
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
