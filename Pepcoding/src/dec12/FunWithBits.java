package dec12;

public class FunWithBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isTheBitSet(200, 8));
		printBits(65633);
		System.out.println(getLastSetBit(200));

		printBits(-300);
		System.out.println(getLastSetBit(-300));
	}

	public static boolean isTheBitSet(int num, int bitCount) {
		int mask = 1 << bitCount;
		if ((num & mask) == mask) {
			return true;
		} else {
			return false;
		}
	}

	public static void printBits(int num) {
		for (int bitnum = 31; bitnum >= 0; bitnum--) {
			boolean isthebitset = isTheBitSet(num, bitnum);
			if (isthebitset == true) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}

		System.out.println();
	}

	public static int getLastSetBit(int num) {
		// int mask = 1;
		//
		// for(int bitnum = 0; bitnum <= 31; bitnum++){
		// boolean isthebitset = isTheBitSet(num, bitnum);
		// if(isthebitset == true){
		// mask = 1 << bitnum;
		// break;
		// }
		// }
		//
		// return mask;

		return num & -num;
	}

}
