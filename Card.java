
public class Card {

	private final String face;// face of card("Ace", "Duece",...)
	private final String suit;// suit of card("heart","diamonds"...)
	int faces, suits;

public Card(String cardFace, String cardsuit)
{
		this.face=cardFace;//initialize face of card 
		this.suit=cardsuit;// initialize suit of card
}
// return string representation of card
public String toString()
{
	return face + " of "+ suit ;
}
//return string representation of face
public String getFace()
{
	return face;
}
// return string representation of suit
public String getSuit()
{
	return suit;
}}
