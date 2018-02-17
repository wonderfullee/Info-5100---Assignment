package Assignment4;

/*
 * Name: Zhihao Li
 * Date: 2/16/2018
 * HashMap can collects and stores both key object and value 
 * because when finding or comparing values, the hashMap is less time complexity which is more efficient.
 * For example 
 * since hashMap has already store all the value and object, 
 * user can direct use map.containsKey to check is the target value is exit in stead of run though loop
 */
public class Assignment4Tester {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 5, 2, 2, 2, 6, 8, 3, 2, 1 };
		Hashmap map = new Hashmap();
		map.setArr(arr);
		map.hashMaping();
		//System.out.println(map.addDigits(85));
		BullAndCow bc = new BullAndCow();
		bc.setSecretNum("1122");
		bc.bullAndCow();

	}

}
