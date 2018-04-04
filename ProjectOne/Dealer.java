package ProjectOne;

public class Dealer {

	Hand hand;

	Dealer() {
		hand = new Hand();
	};

	public boolean draw() throws DeckEmptyExecption {
		if (this.hand.getHandValue().count < 17) {
			return true;
		}
		return false;
	}
	// EFFECTS: For dealer The dealer must
	// hit until he either reaches a total greater than or equal to 17
	// (hard or soft), or busts.
}
