
import java.util.*;
public class Assignment3 {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int [] arr1 = {-1, 0, 1, 2, -1, -4};
		System.out.println("Employee Salary = $"+ employeeSalary(36));
		System.out.println(threeSumZero(arr1));
		System.out.println(longestSubstring("pwwkewfs"));
	}
	
	public static double employeeSalary(double hours) {
		if(hours < 0 ) {// check if hours is negative 
			return 0;
		}else if(hours <= 36) {// check if hours is between 0 and 36
			return 15 * hours;	
		}else{ // check if hours is greater than 36
			return 15 * 36 + 15 * 1.5 * (hours - 36);
		}
	}
	
	/*
	 * time complexity : o(n * n)
	 * space complexity : o(1)
	 */
	public static List<List<Integer>> threeSumZero(int [] arr) {
		if(arr == null || arr.length < 3) {
			throw new NullPointerException("implement array error");
		}
		List<List <Integer>> listSet = new ArrayList<List <Integer>>();
		Arrays.sort(arr); // sorted the whole array
		for(int i = 0; i < arr.length ; i++) {
			if(i >0 && arr[i] == arr[i-1]) continue; // Reduced duplicates number
			 
			int left = i + 1; //first pointer start with i +1 
			int right = arr.length - 1;//second pointer start with end
			while(left < right) { // compare sum of every element with fixed i
				if(arr[i] + arr[left] + arr[right] == 0) {
					listSet.add(Arrays.asList(arr[i] , arr[left], arr[right] ));
					// insert the array set into the linked list
					
					while (left  < right && arr[left] == arr[left +1]) {
						left ++; // Reduced duplicates number from left
					}
					
					while (left < right && arr[right] == arr[right -1]) {
						right --;// Reduced duplicates number from right
					}
					
					left ++;
					right --;
				}else if(arr[i] + arr[left] + arr[right] >0) { // move right pointer to left if sum is positive
					right --;
				}else{// move right pointer to left if sum is negative
					left ++;
				}
			}
			
			
		}
		
		return listSet;
		
	}
	
	
	/*
	 * time complexity : o(n)
	 * space complexity : o(1)
	 */
	public static int longestSubstring(String s) {
		if (s == null || s.length() == 0) return -1; // check is string is valid
		int max = 0;
		int index = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//stored all character from the string

		for (int i = 0 ,index1 = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {//when duplicate char detected, the index is updated
				index1 = Math.max(index1, map.get(c) + 1);
			}
			map.put(c, i);// skip the repeated character
			max = Math.max(max, i - index1 + 1);// the case that the substring is in the end of the string
		}
		
		return max;
	}
}
	


