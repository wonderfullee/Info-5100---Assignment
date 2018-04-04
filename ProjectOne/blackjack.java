package ProjectOne;

import java.util.Scanner;

public class blackjack {

	public static void main(String[] args) throws DeckEmptyExecption {
		int trickCount = 1;
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		Player player;
		Trick tr;

		Scanner key = new Scanner(System.in);
		System.out.println("Welcome to blackjack game");
		System.out.println("Please enter your bankroll (integer)");
		int bankroll = key.nextInt();
		System.out.println("Please enter how many tricks (integer) you want to play");
		int trick = key.nextInt();
		System.out.println("Please enter minimum wager (integer)");
		int minimun = key.nextInt();
		System.out.println("Please enter your perferred player chocie(String) simple or counting ");
		String playerType = key.next();
		if (playerType.equalsIgnoreCase("Simple")) {
			SimplePlayer sp = new SimplePlayer(bankroll, minimun);
			player = sp;
			System.out.println("Simple player ");
		} else if(playerType.equalsIgnoreCase("counting")){
			CountingPlayer cp = new CountingPlayer(bankroll, minimun);
			player = cp;
			System.out.println("Counting player ");
		}else {
			throw new IllegalArgumentException("please check your spelling and  try again");
		}
		
		if(bankroll < 0 || minimun <0 || trick < 0 || bankroll < minimun){
			throw new IllegalArgumentException("please check your input and try again");
		}
		
		deck.shuffle(7);
		System.out.println("Shufﬂing the deck");
		System.out.println("Cut at 7");
		while (player.bankroll >= minimun && trickCount <= trick) {			
			System.out.println("Trick " + trickCount + " Bankroll " + player.bankroll);
			if (deck.getCurrentSize() < 30) {
				System.out.println("Shufﬂing the deck");
				deck.reset();
				deck.shuffle(7);
				player.shuffled();
			}
			tr = new Trick(player, dealer, deck);
			tr.play();
			trickCount++;
			System.out.print("\n");
		}
		System.out.println("your bankroll left is " + player.bankroll );
		System.out.println("Game exiting......  Thank you!");

	}
}