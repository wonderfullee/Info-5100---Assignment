package Assignemt_6;

public abstract class DessertItem {
	private String name;

	public DessertItem() {
		
	}

	public DessertItem(String name) {
		if(name.length() > DessertShoppe.max_Item_Name_Size) {
			this.name = name.substring(0,DessertShoppe.max_Item_Name_Size);
		}else {
			this.name = name;
		}
	}


	public final String getName() {
		return name;
	}

	public abstract int getCost();

}
