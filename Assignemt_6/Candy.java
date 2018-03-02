package Assignemt_6;


public class Candy extends DessertItem {
	private int price;
	private double weight;

	public Candy(String name, double weight, int price) {
		super(name);
		if (weight <= 0 || price <= 0)
			throw new IllegalArgumentException("Candy weight or price implement error");
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int getCost() {
		return (int) Math.round((price * weight));
	}

	public String toString() {
		String s = "\t" + weight + " lbs @ " + (double) price / 100 + "/lb. \n";
		return s + String.format(
				"\t" + "%-" + DessertShoppe.max_Item_Name_Size + "s" + "%" + DessertShoppe.max_width + "s" + "\n",
				getName(), DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
	}
}
