package Midterm;

/*
 * Name:Zhihao Li
 * Date: 03/17/2018
 */
public class RotateArray {

	public static void rotatedArray(int nums[], int d) {
		d = d % nums.length;
		Reverse(nums, 0, nums.length - 1);
		Reverse(nums, 0, d - 1);
		Reverse(nums, d, nums.length - 1);
	}

	private static void Reverse(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		rotatedArray(arr, 2);
	}

}
