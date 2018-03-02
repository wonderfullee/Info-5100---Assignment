package Assignemt_6;

public class Sundae extends IceCream {
	private int cost;
	private String topping;
	private int toppingPrice;

	public Sundae(String i_name, int i_cost, String tName, int tPrice) {
		super(i_name, i_cost);
		if (i_cost <= 0 || tPrice <= 0)
			throw new IllegalArgumentException("sundae cost implement error");
		this.cost = i_cost;
		this.topping = tName;
		this.toppingPrice = tPrice;
	}

	@Override
	public int getCost() {
		return cost + toppingPrice;
	}

	public String toString() {
		String s = String.format("\t" + "%-" + DessertShoppe.max_Item_Name_Size + "s" + "\n", topping + " Sundae with");
		s += String.format("\t" + "%-" + DessertShoppe.max_Item_Name_Size + "s" + "%"+DessertShoppe.max_width+"s" + "\n", getName(),
				DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
		return s;
	}

}
