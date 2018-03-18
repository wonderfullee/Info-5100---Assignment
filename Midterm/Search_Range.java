package Midterm;

import java.util.Arrays;

/*
 * Name:Zhihao Li
 * Date: 03/17/2018
 */
public class Search_Range {
	public static int[] searchForRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		int low = 0;
		int high = nums.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] < target) {// target on right side
				low = mid + 1;
			} else if (nums[mid] > target) {// target on left side
				high = mid;
			} else {
				if (nums[low] == target && nums[high] == target) {
					return new int[] { low, high };
				} else if (nums[low] != target) {
					low++;
				} else {
					high--;
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		int[] arr = { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(searchForRange(arr, 8)));

	}

}
