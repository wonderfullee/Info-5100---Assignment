package ProjectOne;

import java.util.LinkedList;
import java.util.List;

public class GroupOfCards {

	private LinkedList<Card> cards;
	private int topCard;

	GroupOfCards() {
		cards = new LinkedList<Card>();
	}

	// EFFECTS: adds the card "c" to those presently held.
	void addCard(Card c) {
		cards.add(c);
	}

	// EFFECTS: discards any cards presently held , restoring the state
	// of the cards to empty.
	void discardAll() {
		cards.clear();
	}

	int getCurrentSize() {
		return cards.size();
	}
	// EFFECTS: return the length of cards;

	void display() {
		for (int i = 0; i < cards.size(); i++) {
			System.out.println(cards.get(i).toString());
		}
	}
	// EFFECTS: display every card in cards;

	Card deleteCard() {
		Card temp = cards.get(0);
		cards.remove(0);
		return temp;
	};
	// EFFECTS: delete the top card from the group of cards and return the
	// deleted card value;

	Card getCardByIndex(int i) {
		return cards.get(i);
	}

	void removeCardByIndex(int i) {
		cards.remove(i);
	}

}