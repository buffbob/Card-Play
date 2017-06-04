package playingCards;
import java.util.Arrays;
import java.util.Random;



/**
 * A deck of playing cards (of fixed size).
 * 
 * everything seems to work but wierdness when implementing selection sort fix later
 */
public class Deck1 {

    private static Card[] cards;
	private Random random = new Random();


    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck1() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (null).
     */
    public Deck1(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (int i = 0; i < this.cards.length; i++) {
            System.out.printf(this.cards[i]+"    "+i );
            System.out.println();     
            }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
    //	System.out.println(Arrays.toString(this.cards));
        return Arrays.toString(this.cards);
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    public int randomInt(int low, int high) {
    	int randomNumber = random.nextInt(high - low) + low; 
    	
        return randomNumber;
    }

   

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
    	for (int i = 0; i < cards.length; i++){
    		swapCards(i,randomInt(i,cards.length));
    	}
    }
    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) { 
    	Card temp = cards[i];
    	cards[i] = cards[j];
    	cards[j] = temp;
    }
    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    public int indexLowest(int lowI, int highI) {
    	int lowestIndex = lowI;
    	for(int i = lowI; i < highI-1; i++){
    		for(int j = i +1; j < highI; j++){
    			if(cards[i].compareTo(cards[j]) == 1){
    				lowestIndex = j;
    			}
    	}    	System.out.printf("lowestIndex is %d  %d", lowestIndex,i);
    			System.out.println();

    		}
    	return lowestIndex; }
    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
    	for (int i = 0; i < cards.length; i++){
    		if(i<cards.length){
    		swapCards(i, indexLowest(i,(cards.length)));
    		}
    	}
    }
    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck1 subdeck(int low, int high) {
        Deck1 sub = new Deck1(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    public static Deck merge(Deck d1, Deck d2) {
        return null;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck1 mergeSort() {
        return this;
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    } 
    
    /////////////////////////////////////////////////////
    public static void main(String[] args ){
    	Deck1 d = new Deck1();
    	d.print();
    	d.shuffle();
    	d.print();
    	d.selectionSort();
    	d.print();
    	 


    	
    	
    }

}