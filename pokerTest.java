public class PokerTest {

	public static void main(String[] args) {
		Poker abc = new Poker();
		// placing cards in random order
		abc.shuffle();
		// printing all the 52 cards in order which they are dealt
	for(int i= 1; i<=52; i++)
	{
		//deal and display a card
		System.out.printf("%-19s", abc.dealCard());
		if(i%4==0)// output a new line after every fourth card.
		{
			System.out.println();
		}
		
	}
//shuffle the cards
	abc.shuffle();
// Deal with five card poker hand
	abc.handDealer();
	}
}