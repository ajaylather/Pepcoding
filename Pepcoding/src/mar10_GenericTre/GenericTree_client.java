package mar10_GenericTre;

public class GenericTree_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10 3 20 2 50 0 60 0 30 2 70 0 80 0 40 2 90 0 100 0
		GenericTree gt=new GenericTree();
		//gt.display();
		//System.out.println(gt.size());
		System.out.println(gt.size2());
		System.out.println(gt.find(500));
		System.out.println(gt.max());
		System.out.println(gt.height());
	}
	
}
