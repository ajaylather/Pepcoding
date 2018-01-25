package jan21;

import java.util.ArrayList;
import java.util.Arrays;

public class Snakes_Ladders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] moves= {3,2,4,6,3,6,4,2};
		BoardGameSnL(20, moves);
	}
	public static void BoardGameSnL(int n,int[] moves) {
		int[] board =new int[n+1];
		boolean[] bboard=new boolean[n+1];
  		Arrays.fill(board, -1);
//		for(int i=0;i<n;i++) {
//			board[i]=i;
//		}
		Arrays.fill(bboard, true);
		bboard[0]=bboard[1]=false;
		for (int i = 2; i * i <= n; i++) {
			if (bboard[i]) {
				for(int j=i;j*i<=n;j++) {
					bboard[j*i]=false;
				}
			}
		}
		int left=0;
		int right=bboard.length-1;
		
		while (left <= right) {
			boolean isLadder=true;
			while (bboard[left] !=true ) {
				left++;
			}
			while (bboard[right]!=true) {
				right--;
			}
			if (left <= right) {
				if(isLadder) {
					board[left]=right;
				}else {
					board[right]=left;
				}
				isLadder=!isLadder;
				left++;
				right--;
			}
		}
		int pos=0;
		for(int i=0;i<moves.length;i++) {
			if(pos+moves[i]<board.length) {
				pos=pos+moves[i];
			}
			if(pos==board.length-1) {
				System.out.println("khel khtm,ab kya chahiye?????????");
				return;
			}
			if(board[pos]==0) {
				pos=board[pos];
			}
		}
		System.out.println(pos);
	}
}
