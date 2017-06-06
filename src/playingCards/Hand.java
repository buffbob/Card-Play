package playingCards;

public class Hand extends CardCollection{

	public Hand (String label){
		super(label);
	}
	
	public void display(){
		System.out.println(getLabel() + ": ");
		for (int i = 0; i<size(); i++){
			System.out.println(getCard(i));
		}
		System.out.println();
	}
	public static void main (String[]a){
		Deck1 deck = new Deck1("Deck");
		deck.shuffle();
		Hand hand = new Hand("Hand");
		deck.deal(hand,5);
		hand.display();
	}
}
