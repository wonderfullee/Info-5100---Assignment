package Assignment_7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Solution{
	public List<Interval> merge(List<Interval> intervals) {
		int len =intervals.size();
		if (intervals.isEmpty())
			return intervals;
		int[] x = new int[len];
		int[] y = new int[len];
		for (int i = 0; i < len; i++) {
			x[i] = intervals.get(i).start;
			y[i] = intervals.get(i).end;
		}
		Arrays.sort(x);
		Arrays.sort(y);
		List<Interval> merge = new LinkedList<Interval>();

		for (int i = 0, j = 0; i < len; i++) {
			if (i == len -1 || x[i + 1] > y[i] ) {
				//there is overlap so need to merge
				merge.add(new Interval(x[j], y[i]));
				j = i + 1;
			}
		}
		
		return merge;
	}

	public static class Interval {
		int start , end ;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			this.start = s;
			this.end = e;
		}

	}
	
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if(m == 0 || n == 0){
			throw new IllegalArgumentException("both impelement arrays can not be null ");
		}
		if(m > n) return findMedianSortedArrays(nums2, nums1);
		int i = 0, j = 0;
		int imin = 0, imax = m, half = (m+n+1)/2;
		double maxLeft, minRight;
		while(imin <= imax){
			i = (imin + imax) / 2;// i is upper part of two divided arrays
			j = (half) - i;//j is lower part of two divided array
			if(i < m && nums1[i] < nums2[j-1]){
				imin  = i +1; // i is too small so need to increase i
			}else if( i > 0 && nums1[i -1] > nums2[j]){
				imax = i -1; // i is too big so need to decrease i
			}else break; // found nums1 [i-1]<= nums2 [j] 
		}
		if( i == 0) {
			maxLeft = nums2[j-1];
		}else if(j == 0) {
			maxLeft = nums1[i-1];
		}else {
			maxLeft = Math.max(nums1[i-1], nums2[j-1]);
		}
		if((m + n ) % 2 != 0) return maxLeft;// median = max of left part when arr length is odd
		// median = (max of left part + min of right part) / 2 when arr length is even 
		if( i == m) {
			minRight = nums2[j];
		}else if(j == n){
			minRight = nums1[i];
		}else {
			minRight = Math.min(nums2[j], nums1[i]);
		}
		return (maxLeft + minRight) / 2 ;
		
	}

}
