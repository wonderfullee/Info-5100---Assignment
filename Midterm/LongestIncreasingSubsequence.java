package Midterm;

/*
 * Name:Zhihao Li
 * Date: 03/17/2018
 */
public class LongestIncreasingSubsequence {
	public static int findLengthOfLCIS(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int res = 1;
		int cur = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				cur++;
				res = Math.max(cur, res);
			} else {
				cur = 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 3, 5, 4, 7 };
		int arr2[] = { 2, 2, 2, 2, 2 };
		System.out.println(findLengthOfLCIS(arr1));
		System.out.println(findLengthOfLCIS(arr2));
	}
}
