package Assignment_5;

/*
 * Name: Zhihao Li
 * Date: 2/23/2018
 * Assignment_5
 */
public class Assignment_5_Test {
	public static void main(String args[]) {

		Solution s = new Solution();
		Transform tr = new Transform();
		Calculator ca = new Calculator();
		System.out.println("Check ([]{[]}) is vaild?");
		System.out.println(s.isValid("([]{[]})"));
		ca.calculate();
		System.out.println("Start: " + "RXXLRXRXL" + " End: " + "XRLXXRRLX");
		System.out.println(tr.checkTransformable("RXXLRXRXL", "XRLXXRRLX"));

	}

}
