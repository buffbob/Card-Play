package playingCards;

public class Deck1 extends CardCollection{

	public Deck1(String label){
		super(label);
		
		for(int suit = 0 ; suit <= 3; suit++){
			for (int rank = 1 ; rank <= 13; rank++){
				addCard(new Card(rank, suit));
			}
		}
	}

	public static void main (String[]a){
		Deck1 deck = new Deck1("Deck");
		deck.shuffle();
		Hand hand = new Hand("Hand");
		deck.deal(hand,5);
		hand.display();
	}
}
