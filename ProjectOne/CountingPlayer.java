package ProjectOne;

public class CountingPlayer extends Player {

	private int memoryCard;
	private boolean shufﬂed = false;
	private int bet = 0;

	CountingPlayer(int bankroll, int minimum) {
		super(bankroll, minimum);
		memoryCard = 0;
	}

	@Override
	public int bet() {
		return bet;
	}

	@Override
	public boolean draw(Card dealer, int player_count) {

		if ( memoryCard >= 2 && bankroll >=  2 * minimum ) {
			bet = minimum * 2;
		} else {
			bet = minimum;
		}

		return false;

	}

	@Override
	public void expose(Card c) {

		if (shufﬂed == true) {
			memoryCard = 0;
			shufﬂed = false;
		}
		System.out.println(c.toString());
		int cardValue = c.getSpot().getValue();
		if (cardValue == 10 || cardValue == 1) {
			memoryCard--;
		} else if (cardValue >= 2 && cardValue <= 6) {
			memoryCard++;
		}
	}

	@Override
	public void shuffled() {
		shufﬂed = true;
	}

}
