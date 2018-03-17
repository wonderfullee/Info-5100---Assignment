package Assignment_7;

class Tool {
	private int strength;
	private char type;

	public Tool() {
	}

	public Tool(int s, char type) {
		setStrength(s);
		this.type = type;
	}

	public void setStrength(int s) {
		this.strength = s;
	}

	public int getStrength() {
		return strength;
	}

	public char getType() {
		return type;
	}
}

class Scissors extends Tool {
	public Scissors(int num) {
		super(num, 's');
	}

	public boolean fight(Tool tool) {
		if (tool.getType() == 'p')
			return this.getStrength() * 2 > tool.getStrength();
		else if (tool.getType() == 'r')
			return this.getStrength() / 2.0 > tool.getStrength();
		return this.getStrength() * 1.0 >= tool.getStrength();
	}
}

class Paper extends Tool {
	public Paper(int num) {
		super(num, 'p');
	}

	public boolean fight(Tool tool) {
		if (tool.getType() == 'r')
			return this.getStrength() * 2 > tool.getStrength();
		else if (tool.getType() == 's')
			return this.getStrength() / 2.0 > tool.getStrength();
		return this.getStrength() * 1.0 >= tool.getStrength();
	}
}

class Rock extends Tool {
	public Rock(int num) {
		super(num, 'r');
	}

	public boolean fight(Tool tool) {
		if (tool.getType() == 's')
			return this.getStrength() * 2 > tool.getStrength();
		else if (tool.getType() == 'p')
			return this.getStrength() / 2.0 > tool.getStrength();
		return this.getStrength() * 1.0 >= tool.getStrength();
	}
}

class RockPaperScissorsGame {
	public static void main(String args[]) {
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		System.out.println(s.fight(p) + " , " + p.fight(s));
		System.out.println(p.fight(r) + " , " + r.fight(p));
		System.out.println(r.fight(s) + " , " + s.fight(r));
	}
}
