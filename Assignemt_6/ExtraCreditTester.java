package Assignemt_6;

public class ExtraCreditTester {

	public static void main(String[] args) {
		ExtraCredit ec = new ExtraCredit();
		int[][] m1 = { { 1, 2, 3 }, 
						{ 4, 5, 6 }, 
						{ 7, 8, 9 }, 
						{ 10, 11, 12 } };
		ec.spiralOrder(m1);
	}

}
