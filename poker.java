import java.awt.List;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;


public class Poker {
	
	private Card[] deck;// array of Card object
	private Card[] poker_hand;// five card pker hand array of Card object
	private int CurrentCard, count[], totalpairs, threekinds;
	private static final int NUMBER_OF_CARDS = 52; // constant number of cards 
	private static final int NUMBER_OF_HANDS = 5; // constant number of each poker hand
	private String face[],suit[];
	private int number[];

	private static final SecureRandom randomNumbers = new SecureRandom();
	//constructor fills deck of cards
	public Poker()
	{
	// Arrays of faces and suits
	String[] faces= {"Ace", "Deuce","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	String[] suits= {"Hearts", "Diamonds", "Clubs","spades"};
		
		face=faces;
		suit=suits;
		
		count = new int[13];
		deck = new Card[NUMBER_OF_CARDS];// create array of Card objects
		poker_hand = new Card[NUMBER_OF_HANDS];// create array of poker cards of Card object
		CurrentCard=0;// first card dealt will be deck[0]
		// populate deck of cards with Card object
		for(int count = 0; count<deck.length; count++)
		
			deck[count]= new Card(faces[count % 13], suits[count/13]);
		
	}	
	// shuffle deck of cards 
	public void shuffle()
	{
		// next call to method dealCard should start at deck[0] again
		CurrentCard=0;
		//for each card pick another random card (0-51) and swap them
		for(int first = 0; first< deck.length; first++)
		{
			// select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			// swap current card with randomly selected card
			Card temp= deck[first];
			deck[first] = deck[second];
			deck[second]= temp;
		}
	}
	// deal one card
	public Card dealCard()
	{
		//determine whether card remains to be dealt
		if(CurrentCard < deck.length)
		{
			return deck[CurrentCard++];// return current card in array
		}
		else
		{
			return null; // return null to indicate that all cards were dealt
		}
	}
	//Deal five-card poker card
	public void handDealer()
	{
		//new line
		System.out.println();
		System.out.println( "The five poker cards are: \n");
		// deal one round
		for(int cards= 0; cards<poker_hand.length;cards++)
		{
			Card eachCard = dealCard();
			
		if(eachCard!=null)
		{
			poker_hand[cards]=eachCard;
			// print the five dealing cards of a hand
			System.out.println( poker_hand[cards]);
		}
		else
		{
			System.out.println("No Cards");
			// shuffle if no card left to be dealt
			shuffle();
		}
		}
		// calculate what one poker hand contains
		calculateHand();
		aPair();
		threeofKind();
		fourofKind();
		twoPairs();
		aFlush();
		aStraight();
		afullHouse();
		}
// determine how many face cards are present in a hand
	private void calculateHand()
	{
		// initialize count array with all elements to be zero
		for(int p= 0; p<face.length;p++)
		{
			 count[p]=0;
		}
		// compare each card in hand with each face element in face array 
		for (int h=0; h<poker_hand.length; h++)
		{
			for(int f=0; f<face.length; f++)
			{
				if(poker_hand[h].getFace().equals(face[f]))
				{
					count[f]=count[f]+1;
					// if hand contains a face card matching in face array, the count will increment to 1 and so on. This count array will help in defining all the methods that a hand contains
				}
			}
		}
		
		
	}
	// determine if hand contains a pair
	
	private void aPair()
	{
		// new line
		System.out.println();
		// if count array has value 2 it means there are two cards of same face in a hand which is hence a pair
		for(int pair = 0; pair< face.length; pair++)
		{
			if(count[pair]==2)
			{
				System.out.println("Pair of  " +face[pair]+ "'s");
				totalpairs++;// increment totalpairs so as to use this for finding a full house or other contents in a hand.
			}
		}
	}
	// determine if a hand contains three same face card
	private void threeofKind()
	{
		System.out.println();
		for(int pair = 0; pair< face.length; pair++)
		{
			// if count array has value 3 then it means it has three same face card.
			if(count[pair]==3)
			{
				System.out.println("Three kinds of " +face[pair]+ "'s");
				threekinds++;//increment threekinds so as to use this for finding a full house or other contents in a hand.
				
				break;
			}
		}
	}
	// determine if hand contains two cards of one face and three cards of another face
	private void afullHouse() {
		
		System.out.println();
		//if totalpairs and threekinds have value 1, & operation checks for both conditions to be true. If it is true, we get a full house
		if(totalpairs==1 && threekinds==1)
		{
			System.out.println("Full House");
		}
	}
	private void aStraight() {
		//initializing the array for storing int value of respective face
		number=new int[13];
		
		
		face[0]=poker_hand[0].getFace();
		face[1]=poker_hand[1].getFace();
		face[2]=poker_hand[2].getFace();
		face[3]=poker_hand[3].getFace();
		face[4]=poker_hand[4].getFace();
		// retrieve all the integer value of face in poker cards
	for(int i=0; i<poker_hand.length;i++){
		if(face[i].equals("Ace"))
	{
		number[0]=1;
		
	}
	if(face[i].equals("Deuce"))
		{
			number[1]=2;
			
		}
	 if(face[i].equals("Three"))
		{
			number[2]=3;
			
		}
	 if(face[i].equals("Four"))
		{
			number[3]=4;
		}
	 if(face[i].equals("Five"))
		{
			number[4]=5;
			
		}
	 if(face[i].equals("Six"))
		{
			number[4]=6;
			
		}
	 if(face[i].equals("Seven"))
		{
			number[6]=7;
			
		}
	 if(face[i].equals("Eight"))
		{
			number[7]=8;
			
		}
	 if(face[i].equals("Nine"))
		{
			number[8]=9;
			
		}
	 if(face[i].equals("Ten"))
		{
			number[9]=10;
			
		}
	if(face[i].equals("Jack"))
		{
			number[10]=11;
			
		}
	if(face[i].equals("Queen"))
		{
			number[11]=12;
			
		}
	if(face[i].equals("King"))
		{
			number[12]=13;
			
		}
		}
	//if cards are Ace,King.Queen,Jack,Ten, its a straight
	if(number[0]==1&&number[12]==13&&number[11]==12&&number[10]==11&&number[9]==10){
		System.out.println("It is a Straight");
	//sorting the array to check other consective numbers
	Arrays.sort(number);
	// checking for consecutive numbers
	int start= number[8];
	for(int k=9;k<13;k++)
	{
		if(start!= number[k]-1)
			return;
		else 
			start=number[k];

}
	System.out.println("It is a Straight");
	}	
	}
	
	
	// Determine if a hand contains all cards of same suits
	private void aFlush() {
		System.out.println();
		// get the suit of first dealt card of a hand
		String mysuit = poker_hand[0].getSuit();
		// comapare the first card with other 4 cards, if found same it is a flush
		for(int suitflush= 1; suitflush< poker_hand.length; suitflush++)
		
			if(poker_hand[suitflush].getSuit().compareTo(mysuit)!=0)
			return;										
		System.out.println("Flush in "+ mysuit);
	}
	// determine if a hand contains two pairs
	private void twoPairs() {
		// new line
	//if totalpairs which increments if we find a pair in apair() method defined above has value 2, it means we have two pairs in a hand
		System.out.println();
		if(totalpairs==2)
			
		{
			System.out.println("Two Pairs");
		}
	}
		// determine if we have 4 cards of same face value in a hand
		private void fourofKind() {
			// new line
		System.out.println();
		// 
		for(int pair = 0; pair< face.length; pair++)
		{
			//if count has value 4, it means we have 4 same face card in one cand 
			if(count[pair]==4)
			{
			System.out.println("Four kinds of " +face[pair]+ "'s");
			
		}
		}
	}

}
