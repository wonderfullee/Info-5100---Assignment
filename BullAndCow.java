//total scores : 10 /10
package Assignment4;

import java.util.Scanner;

public class BullAndCow {
	private String secretNum;

	public void setSecretNum(String num) {
		this.secretNum = num;
	}

	public void bullAndCow() {
		Scanner key = new Scanner(System.in);
		int bullCounter = 0;
		int cowCounter = 0;
		while (bullCounter < secretNum.length()) {// this loop run as many time
													// as guess are all correct
			System.out.println("Please enter your guess(4 digits)");
			String guess = key.nextLine();
			if (guess.length() != 4) {
				System.out.println("enter errors, please try again");
				continue;
			}
			cowCounter = 0;
			bullCounter = 0;
			for (int i = 0; i < secretNum.length(); i++) {// this loop run N
															// times
				char a = secretNum.charAt(i);
				char b = guess.charAt(i);
				if (a == b) {
					bullCounter++;
				} else {
					cowCounter++;
				}
			}

			System.out.println("Great! " + bullCounter + "A" + cowCounter + "B");

		}
	}
}
		
		
