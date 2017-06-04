package playingCards;

public class Deck {
	private  Card[] cards;

	public Deck(int n) {
		cards = new Card[n];
	}

	public Deck() {
		cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit < Card.SUITS.length; suit++) {
			for (int rank = 1; rank < Card.RANKS.length; rank++) {
				cards[index] = new Card(suit, rank);
				index++;
			}
		}
	}

	public void printDeck() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(cards[i]);
		}
	}

	public static int randInt(int low, int high) {
		while (true) {
			int x = (int) (Math.random() * (high - low + 1) + low);
			if (x >= low && x <= high)
				return x;
		}
	}

	public  void shuffle() {
		for (int i = 0; i < this.cards.length - 1; i++) {
			int rand = randInt(i, this.cards.length - 1);
			Card.swapCards(cards, i, rand);
		}

	}

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.printDeck();
		System.out.println();
		Deck shuffled = deck;
		deck.printDeck();
		shuffled.shuffle();
		shuffled.printDeck();


	}

}
