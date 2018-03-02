package Assignemt_6;

public class DessertShoppe {
	public final static double saleTax = 0.05;
	public final static String storeName = "Wonderful Dessert store";
	public final static int max_Item_Name_Size = 30;
	public final static int max_width = 5;

	public static String cents2dollarsAndCentsmethod(int cents) {
		if (cents < 0)
			throw new IllegalArgumentException("cents error");

		if (cents < 100)
			return new String("0." + (int) cents);
		if (cents % 100 < 10)
			return new String((int) cents / 100 + ".0" + (int) (cents % 100));

		return new String((int) cents / 100 + "." + cents % 100);
	}
}
	
	
	

