package Assignment_7;

public class ExtraCredit {
	public String removeVowelsFromString(String input) {
		if (input == null)
			throw new IllegalArgumentException("input string can't be null");
		int start = 0, end = input.length() - 1;
		String vowels = "aeiouAEIOU";
		char[] ch = input.toCharArray();
		for (; start < end; start++, end--) {
			while (start < end && !vowels.contains(ch[start] + "")) {
				start++;// first pointer search from left
			}
			while (start < end && !vowels.contains(ch[end] + "")) {
				end--;// second pointer search from right
			}
			char temp = ch[start];// swap two vowels
			ch[start] = ch[end];
			ch[end] = temp;
		}
		return new String(ch);

	}
}
