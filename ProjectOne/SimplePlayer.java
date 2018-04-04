package ProjectOne;

import ProjectOne.Hand.HandValue;

public class SimplePlayer extends Player {
	SimplePlayer(int bankroll, int minimum) {
		super(bankroll, minimum);
	}

	@Override
	public boolean draw(Card dealer, int player_count) throws DeckEmptyExecption {
		HandValue currValue = playerHand.getHandValue();
		int cardValue = currValue.count;
		boolean softCard = currValue.soft;

		if (softCard == false) {
			if (cardValue <= 11) {
				return true;
			} else if (cardValue == 12) {
				return dealer.getSpot().getValue() > 6 || dealer.getSpot().getValue() < 4;

			} else if (cardValue <= 16 && cardValue >= 13) {
				return dealer.getSpot().getValue() > 6 || dealer.getSpot().getValue() < 2;

			}
		} else if (softCard == true) {
			if (cardValue <= 17) {
				return true;
			} else if (cardValue == 18) {
				if (dealer.getSpot().getValue() != 2 && dealer.getSpot().getValue() != 7
						&& dealer.getSpot().getValue() != 8) {
					return true;
				}
			} else if (cardValue >= 19) {
				return false;
			}
		}

		return false;
	}

	@Override
	public int bet() {
		return minimum;
	}

	@Override
	public void expose(Card c) {
		System.out.print(c.toString());
		System.out.println();
	}

	@Override
	public void shuffled() {
	}
}
