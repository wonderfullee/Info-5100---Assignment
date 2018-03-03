scores : 2 / 2

package Assignment_5;

import java.util.HashMap;
import java.util.Stack;

/*
 * Name: Zhihao Li
 * Date: 2/23/2018
 * Assignment_5
 */
public class Solution {

	public boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else if (map.containsValue(s.charAt(i))) {
				if (stack.isEmpty() == true) {
					return false;
				} else if (map.get(stack.peek()) == s.charAt(i)) {
					stack.pop();
					continue;
				} else
					return false;

			}
		}

		return true;
	}

}
