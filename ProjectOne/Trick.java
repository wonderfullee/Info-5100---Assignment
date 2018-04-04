package ProjectOne;

public class Trick {

	Player player;
	Dealer dealer;
	Deck deck;

	Trick(Player player, Dealer dealer, Deck deck) {
		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
	};

	void play() throws DeckEmptyExecption {

		wager();
		DealFour();
		playerTurn();
		dealerTurn();
		closeTurn();
	}
	// execute the five following steps;

	int wager() {
		return player.bet();
	};

	void DealFour() throws DeckEmptyExecption {
		player.playerHand = new Hand();
		dealer = new Dealer();
		Card dealCard = deck.deal();

		player.playerHand.addCard(dealCard);
		System.out.print("Player dealt ");
		player.expose(dealCard);

		dealCard = deck.deal();
		dealer.hand.addCard(dealCard);
		System.out.print("Dealer dealt ");
		player.expose(dealCard);

		dealCard = deck.deal();
		player.playerHand.addCard(dealCard);
		System.out.print("Player dealt ");
		player.expose(dealCard);

		dealCard = deck.deal();
		dealer.hand.addCard(dealCard);

		System.out.println("player's total " + getPlayerCount());
		System.out.println("dealer's current count (without hole card value) "
				+ dealer.hand.getCardByIndex(0).getSpot().getValue());

	};
	// After the wager, the dealer deals a total of four cards:
	// the first face-up to the player, the second face-up to
	// himself, the third face-up to the player, and the fourth
	// face-down to himself.

	void playerTurn() throws DeckEmptyExecption {
		while (player.draw(dealer.hand.getCardByIndex(0), getPlayerCount()) == true) {
			Card dealCard = deck.deal();
			player.playerHand.addCard(dealCard);
			System.out.print("Player dealt ");
			player.expose(dealCard);
			System.out.println("player's total " + getPlayerCount());
		}
	};

	void dealerTurn() throws DeckEmptyExecption {
		while (dealer.draw() == true && getDealerCount() < 21 && getPlayerCount() <= 21) {
			Card dealCard = deck.deal();
			dealer.hand.addCard(dealCard);
			System.out.print("Dealer dealt ");
			player.expose(dealCard);
			System.out.println("dealer's total " + getDealerCount());
		}
	};

	// dealer's turn only happens if the player hasn’t busted or the player is
	// not dealt a natural 21 .

	void closeTurn() {
		System.out.println("player's total " + getPlayerCount() + " VS " + "dealer's total " + getDealerCount());
		if (getPlayerCount() == 21) {
			System.out.println("Player dealt natural 21");
			player.bankroll = (int) (player.bankroll + wager() * 1.5);
		} else if (getPlayerCount() > 21) {
			player.bankroll = player.bankroll - wager();
			System.out.println("Player busts");
		} else if (getDealerCount() > 21 && getPlayerCount() < 21) {
			System.out.println("Dealer busts");
			System.out.print("Dealer's hole card is  ");
			player.expose(dealer.hand.getCardByIndex(1));
			player.win(wager());
			System.out.println("player win");
		} else if (getPlayerCount() > getDealerCount()) {
			System.out.print("Dealer's hole card is  ");
			player.expose(dealer.hand.getCardByIndex(1));
			player.win(wager());
			System.out.println("player win");
		} else if (getPlayerCount() < getDealerCount()) {
			System.out.print("Dealer's hole card is  ");
			player.expose(dealer.hand.getCardByIndex(1));
			player.bankroll = player.bankroll - wager();
			System.out.println("dealer win");
		} else if (getPlayerCount() == getDealerCount()) {
			System.out.print("Dealer's hole card is  ");
			player.expose(dealer.hand.getCardByIndex(1));
			System.out.println("Push");
		}
	};
	// compare the count and give back reward to player if win.

	private int getPlayerCount() {
		return player.playerHand.getHandValue().count;
	}

	private int getDealerCount() {
		return dealer.hand.getHandValue().count;
	}

}