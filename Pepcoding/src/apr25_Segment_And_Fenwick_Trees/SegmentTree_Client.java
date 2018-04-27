package apr25_Segment_And_Fenwick_Trees;

public class SegmentTree_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,5,-4,16,7,1,9};
//		SegmentTree gt=new SegmentTree(arr);
//		gt.display();
//		System.out.println(gt.query(2, 5));
//		gt.update(3, 9);
//		System.out.println(gt.query(2, 5));
		FenwickTree ft=new FenwickTree(arr);
		System.out.println(ft.getSum(2, 5));
		ft.update(3, 9);
		System.out.println(ft.getSum(2, 5));
	}

}
