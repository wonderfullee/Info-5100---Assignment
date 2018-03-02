package Assignemt_6;

import java.util.ArrayList;
import java.util.List;

public class ExtraCredit {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;

		int x_start = 0;
		int y_start = 0;
		int x_end = matrix.length - 1;
		int y_end = matrix[0].length - 1;
		while (x_start <= x_end && y_start <= y_end) {
			for (int i = y_start; i <= y_end; i++) {// going right
				result.add(matrix[x_start][i]);
			}
			x_start++;// move begin row one unit right

			for (int i = x_start; i <= x_end; i++) {// going down
				result.add(matrix[i][y_end]);
			}
			y_end--;// move end col one unit down

			if (x_start <= x_end) {
				for (int i = y_end; i >= y_start; i--) {// going left
					result.add(matrix[x_end][i]);
				}
				x_end--;//move end row one unit left
			}

			if (y_start <= y_end) {
				for (int i = x_end; i >= x_start; i--) {// going up
					result.add(matrix[i][y_start]);
				}
				y_start++;//move begin col one unit up
			}

		}

		printList(result);
		return result;
	}

	public void printList(List list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

}
