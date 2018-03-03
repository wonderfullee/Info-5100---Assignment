scores : 2 / 2

package Assignment_5;

/*
 * Name: Zhihao Li
 * Date: 2/23/2018
 * Assignment_5
 */
public class Transform {
	public boolean checkTransformable(String input, String target) {
		char[] input_C = input.toCharArray();
		char[] target_C = target.toCharArray();
		int counter_L = 0;
		int counter_R = 0;
		int counter_X = 0;

		if (input.length() != target.length())
			return false;

		for (int i = 0; i < target_C.length; i++) {
			if (target_C[i] == 'X') {
				counter_X++;
			}
			if (target_C[i] == 'L') {
				counter_L++;
			}
			if (target_C[i] == 'R') {
				counter_R++;
			}
			if (input_C[i] == 'X') {
				counter_X--;
			}
			if (input_C[i] == 'L') {
				counter_L--;
			}
			if (input_C[i] == 'R') {
				counter_R--;
			}
			if (input_C[i] != 'X' && input_C[i] != 'R' && input_C[i] != 'L') {
				return false;
			}
		}
		if (counter_X == 0 && counter_L == 0 && counter_R == 0)
			return true;
		return false;
	}

}
