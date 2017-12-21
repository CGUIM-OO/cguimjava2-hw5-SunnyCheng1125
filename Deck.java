import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Deck {
	
	private ArrayList<Card> cards; //Record Suits and Numbers
	private ArrayList<Card> usedCard; //Record all used cards
	private ArrayList<Card> openCard; 
	public int nUsed; //Record the quantities of used card
	
	public Deck(int nDeck)// The constructor of Deck
	{
		cards = new ArrayList<Card>(); // Create a new ArrayList (Record Suits and Numbers)
		usedCard = new ArrayList<Card>(); // Create a new ArrayList (Record all used cards)
		openCard = new ArrayList<Card>(); // Create a new ArrayList (Record all opened cards)
		
		//Use for loop to generate a deck of cards into the ArrayList<Card>
		for (int a = 0 ; a < nDeck ; a++) 
		{
			for (Card.Suit s : Card.Suit.values()) 
			{
				for (int j = 1; j < 14 ; j++) //Input the rank data
				{
					Card card = new Card (s,j); 
					cards.add(card); //Generate each card
				}
			}
		}
		shuffle(); //Random the positions of cards
	}	
	
	public void printDeck()
	{
		cards.get(nUsed).printCard(); //Print out chosen card from the ArrayList<Card>
	}
	
	public ArrayList<Card> getAllCards()
	{
		return cards;
	}
	
	public Card getOneCard(boolean isOpened) 
	{
		if(usedCard.size() == cards.size()) //If already gave out 52 cards, then shuffle
			shuffle();
		else
		{
			usedCard.add(cards.get(nUsed)); //Otherwise, give out an unused card
			if(isOpened == true) // If the card didn't open before, then add to openCard.
				openCard.add(cards.get(nUsed));
		}
		nUsed += 1; //Record how many cards used
		
		return usedCard.get(usedCard.size()-1); 		
	}
	public void shuffle() {
		// TODO Auto-generated method stub
		
		Random rnd = new Random(); 
        for(int i = 0; i < cards.size(); i++) 
        {
            	//Random the positions of every elements in the cards list
            Collections.swap(cards, i, (int) (Math.random() * cards.size() - 1)); 
        }
		usedCard.clear(); //Reset the usedCard list
		openCard.clear(); //Reset the openCard list
		nUsed = 0 ; //Reset the used times of cards
	}
	public ArrayList getOpenedCard()
	{
		return openCard;
	}
}
