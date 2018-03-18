package mar10_11_17_GenericTree;

public class GenericTree_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10 3 20 2 50 0 60 0 30 2 70 3 110 0 120 0 130 0 80 0 40 2 90 0 100 2 140 0 150 0	
		//10 3 20 2 50 0 60 0 30 2 700 3 110 0 120 0 190 0 80 0 40 2 90 0 100 3 170 0 150 0 500 0
		GenericTree gt=new GenericTree();
//		GenericTree gt2=new GenericTree();
		
//		gt.display();
//		System.out.println(gt.size());
//		System.out.println(gt.size2());
//		System.out.println(gt.find(500));
//		System.out.println(gt.max());
//		System.out.println(gt.height());
//		gt.flatten();
//		gt.preOrder();
//		gt.postOrder();
//		gt.levelOrder();
//		gt.levevOlineWise();
//		gt.levelOZigzag();
//		gt.predsucc(10);
//		gt.predsucc(150);
//		gt.predsucc(90);
//		gt.justLarger(90);
//		System.out.println(gt.kthSmallest(3));
//		gt.AreIdenticallyShaped(gt2);
//		gt.AreMirrorImaged(gt2);
//		gt.IsSelfMirrorImaged();
		gt.printTargetSum(gt.root,70,"");
		
	}
	
}
