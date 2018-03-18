package Midterm;

/*
 * Name:Zhihao Li
 * Date: 03/17/2018
 */
public class SmallestSubArraySum {
	public static int smallestSubWithSum(int arr[], int n, int x) {
		n = arr.length;
		int start = 0;
		int sum = 0;
		int res = n;
		boolean found = false;
		for (int curr = 0; curr < n; curr++) {
			sum += arr[curr];
			if (arr[curr] > x)
				return 1;
			while (sum > x) {
				found = true;
				sum = sum - arr[start];
				res = Math.min(res, curr - start + 1);
				start++;
			}
		}
		if (found == false)
			return 0;
		else
			return res;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 4, 45, 6, 0, 19 };
		int arr2[] = { 1, 10, 5, 2, 7 };
		int arr3[] = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
		int arr4[] = { 1, 2, 4 };
		System.out.println(smallestSubWithSum(arr1, arr1.length, 51));
		System.out.println(smallestSubWithSum(arr2, arr2.length, 9));
		System.out.println(smallestSubWithSum(arr3, arr3.length, 280));
		System.out.println(smallestSubWithSum(arr4, arr4.length, 8));
	}

}
