package playingCards;
//In this version of the Card class, a deck is an Array

//of Cards, and everything is written as a class method

public class Card {
	int suit, rank;
	public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	public static final String[] RANKS = { "narf", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };

	public Card() {
		this.suit = 0;
		this.rank = 0;
	}

	public Card(int rank, int suit) {
		this.suit = suit;
		this.rank = rank;
	}

	public String toString() {
		return (RANKS[this.rank] + " of " + SUITS[this.suit]);
	}

	public static String printCard(Card c) {

		return (RANKS[c.rank] + " of " + SUITS[c.suit]);
	}

	public static void printDeck(Card[] deck) {
		for (int i = 0; i < deck.length; i++) {
			System.out.println("index: " + i + "\t" + deck[i].toString());

		}
	}

	// compareCards: returns 1 if the first card is greater
	// -1 if the seconds card is greater, and 0 if they are the same.

	public static int compareCards(Card c1, Card c2) {

		// first compare the SUITS

		if (c1.suit > c2.suit)
			return 1;
		if (c1.suit < c2.suit)
			return -1;

		// if the SUITS are the same,
		// use modulus arithmetic to rotate the RANKS
		// so that the Ace is greater than the King.

		int rank1 = (c1.rank + 11) % 13;
		int rank2 = (c2.rank + 11) % 13;

		// compare the rotated RANKS

		if (rank1 > rank2)
			return 1;
		if (rank1 < rank2)
			return -1;
		return 0;
	}

	// try instance compare cards
	// also changed to make ace the high card and rank as most imp
	public int compare(Card c) {
		int rank1 = (this.rank + 11) % 13;
		int rank2 = (c.rank + 11) % 13;
		if (rank1 > rank2)
			return 1;
		if (rank1 < rank2)
			return -1;
		if (this.suit > c.suit)
			return 1;
		if (this.suit < c.suit)
			return -1;
		return 0;
	}

	public boolean sameCard(Card c1, Card c2) {
		return (c1.suit == c2.suit && c1.rank == c2.rank);
	}

	public static int findCard(Card[] deck, Card card) {
		for (int i = 0; i < deck.length; i++) {
			if (deck[i].equals(card))
				return i;
		}
		return -1;
	}

	public static int binarySearch(Card[] deck, Card card) {
		int low = 0;
		int high = deck.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			System.out.println(mid);
			int comp = compareCards(card, deck[mid]);
			if (comp == 0) {
				return mid;
			} else if (comp < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int findBisect(Card[] deck, Card card, int low, int high) {

		if (high < low)
			return -1;

		int mid = (high + low) / 2;
		int comp = compareCards(card, deck[mid]);

		if (comp == 0) {
			return mid;
		} else if (comp < 0) {
			// card is less than deck[mid]; search the first half
			return findBisect(deck, card, low, mid - 1);
		} else {
			// card is greater; search the second half
			return findBisect(deck, card, mid + 1, high);
		}
	}

	public static Card[] buildDeck() {
		Card[] deck = new Card[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				deck[index] = new Card(rank, suit);
				index++;
			}
		}
		return deck;
	}

	public static void shuffleDeck(Card[] deck) {
		for (int i = 0; i < deck.length; i++) {
			int j = randInt(i, deck.length - 1);
			swapCards(deck, i, j);
		}
	}

	public static int randInt(int low, int high) {
		while (true) {
			int x = (int) (Math.random() * (high - low +1) + low );
			if (x >= low && x <= high)
				return x;
		}
	}

	public static void sortDeck(Card[] deck) {
		for (int i = 0; i < deck.length; i++) {
			int j = indexLowestCard(deck, i, deck.length - 1);
			swapCards(deck, i, j);
		}
	}

	public static void swapCards(Card[] deck, int i, int j) {
		Card temp = deck[i];
		deck[i] = deck[j];
		deck[j] = temp;
	}

	public static int indexLowestCard(Card[] deck, int low, int high) {
		int winner = low;
		for (int i = low + 1; i <= high; i++) {
			if (compareCards(deck[i], deck[winner]) < 0) {
				winner = i;
			}
		}
		return winner;
	}

	public static Card[] subdeck(Card[] deck, int low, int high) {
		Card[] sub = new Card[high - low + 1];

		for (int i = 0; i < sub.length; i++) {
			sub[i] = deck[low + i];
		}
		return sub;
	}

	public static void main(String[] args) {
		Card[] deck = buildDeck();
        

		printDeck(deck);
		shuffleDeck(deck);
		printDeck(deck);
		sortDeck(deck);
		printDeck(deck);

	Card card1 = new Card(2, 1);
		Card card2 = new Card(3, 1);
		//System.out.println(card2.toString());
	//	Card[] z = {card1,card2};
		//.out.println(compareCards(card1,card2));
		System.out.println(printCard(card1));
		System.out.println(printCard(card2));
		System.out.println();
/*		printDeck(z);
		swapCards(z,0,1);
		printDeck(z);
		*/

		
		//shuffleDeck(deck);
	}
}
