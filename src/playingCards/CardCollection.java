package playingCards;

import java.util.ArrayList;
import java.util.Random;

public class CardCollection {

	private String label;
	private ArrayList<Card> cards;
	
	
	public CardCollection(String label) {
		super();
		this.label = label;
		this.cards = new ArrayList<Card>();
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public void addCard(Card card){
		this.cards.add(card);
	}
	
	public Card removeCard(int i){
		return cards.remove(i);
	}
	
	public Card removeCard(){
		int i = this.size() -1;
		return removeCard(i);
	}
	
	public int size() {
		return cards.size();
	}
	
	public boolean empty(){
		return cards.size() == 0;
	}
	
	public void deal(CardCollection that, int n){
		for (int i = 0; i < n; i++){
			Card card = this.removeCard();
			that.addCard(card);
		}
	}
	public void dealAll(CardCollection that){
		int size = size();
		for(int i = 0; i < size;i++){
			Card card = this.removeCard();
			that.addCard(card);
			//or just use deal(card, size);
		}
		
	}
	public Card getCard(int i) {
		return cards.get(i);
	}
// unsure about this one
	public void setCard(int i, Card card){
		cards.set(i, card);
	}
	
	public Card last(){
		int i = size()-1;
		return cards.get(i);
	}
	
	public void swapCards(int i, int j){
		Card temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
	}

	public void shuffle(){
		Random rand = new Random();
		for(int i = size() -1; i > 0; i--){
			int j = rand.nextInt(i);
			swapCards(i,j);
		}
	}
	public static void main (String[]a){
		Deck1 deck = new Deck1("Deck");
		deck.shuffle();

		System.out.println(deck.size());
		System.out.println("-------------------------------");

		Hand hand = new Hand("Hand");
		deck.deal(hand,5);
		hand.display();
		
		System.out.println(deck.size());
		System.out.println("-------------------------------");
		Hand drawPile = new Hand("Draw Pile");
		System.out.printf("Draw pile has %d cards. \n", drawPile.size());
		deck.dealAll(drawPile);
		System.out.printf("Draw pile has %d cards. \n", drawPile.size());
		System.out.println("-------------------------------");
		drawPile.display();
	}
}
