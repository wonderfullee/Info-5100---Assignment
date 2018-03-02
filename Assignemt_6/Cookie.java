package Assignemt_6;

public class Cookie extends DessertItem {
	private double piece;
	private int dzPrice;

	public Cookie(String name, int piece, int dzPrice) {
		super(name);
		if (piece <= 0 || dzPrice <= 0)
			throw new IllegalArgumentException("cookie implement error");
		this.piece = piece;
		this.dzPrice = dzPrice;
	}

	@Override
	public int getCost() {
		return (int) Math.round(((piece / 12) * dzPrice));
	}

	public String toString() {

		String s = "\t" + piece + " @ " + (double) dzPrice / 100 + "/dz. \n";
		return s + String.format("\t" + "%-" + DessertShoppe.max_Item_Name_Size + "s" + "%"+DessertShoppe.max_width+"s" + "\n", getName(),
				DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
	}

}
