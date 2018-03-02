package Assignemt_6;

import java.util.LinkedList;

public class Checkout {
	public DessertItem item;
	public double cost;
	LinkedList<DessertItem> list;

	public Checkout() {
		list = new LinkedList<DessertItem>();
	}

	public int numberOfItems() {
		return list.size();
	}

	public void enterItem(DessertItem item) {
		list.add(item);
	}

	public void clear() {
		list.clear();
	}

	public int totalCost() {
		int cost = 0;
		for (int i = 0; i < list.size(); i++) {
			cost += list.get(i).getCost();
		}
		return cost;
	}

	public int totalTax() {
		return (int) Math.round((totalCost() * DessertShoppe.saleTax));
	}

	public String toString() {
		String s = "\t     " + DessertShoppe.storeName + "\n";
		s += "\t     ----------------------\n\n";
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i);
		}
		s += String.format("\t%-" + DessertShoppe.max_Item_Name_Size + "s%" + DessertShoppe.max_width + "s", "Tax",
				DessertShoppe.cents2dollarsAndCentsmethod(totalTax()));
		s += String.format("\n\t%-" + DessertShoppe.max_Item_Name_Size + "s%" + DessertShoppe.max_width + "s",
				"Total Cost", DessertShoppe.cents2dollarsAndCentsmethod(totalCost() + totalTax()));
		s += "\n\n\t" + "Thank you! have a great day";
		return s;
	}

}
