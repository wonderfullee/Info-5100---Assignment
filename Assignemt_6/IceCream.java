package Assignemt_6;

public class IceCream extends DessertItem {
	private int cost;

	public IceCream(String name, int cost) {
		super(name);
		if (cost <= 0)
			throw new IllegalArgumentException("ice cream cost implement error");
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return cost;
	}

	public String toString() {
		return String.format("\t%-" + DessertShoppe.max_Item_Name_Size + "s" + "%"+DessertShoppe.max_width+"s" + "\n", getName(),
				DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
	}

}
