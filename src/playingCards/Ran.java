package playingCards;

public class Ran {
	static int counts;
	public static void main(String [] args){
		counts =0;
		for(int i = 0; i<1000; i++){
			double rand = (int)(Math.random()*2 + 50);
			System.out.println(rand);
			if(rand==51)counts++;
		}
		System.out.println(counts);
	}
}
