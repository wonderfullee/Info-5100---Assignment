package Assignment_7;

import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;

import Assignment_7.Solution.Interval;


public class SolutionTest {
	public static void main(String args[]) {
		Solution s = new Solution();
		LinkedList<Interval> list = new LinkedList<Interval>();
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 4);
		Interval i3 = new Interval(5, 7);
		Interval i4 = new Interval(6, 8);
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		LinkedList<Interval> res = (LinkedList<Interval>) s.merge(list);
		System.out.println("Interval test ");
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + " " + res.get(i).end);
		}
		
		int [] arr1 = {1,3};
		int [] arr2 = {2};
		int [] arr3 = {1,2};
		int [] arr4 = {3,4};
		System.out.println("\nfindMedianSortedArrays = "+s.findMedianSortedArrays(arr1, arr2));
		System.out.println("findMedianSortedArrays = "+s.findMedianSortedArrays(arr3, arr4));
	}

}
