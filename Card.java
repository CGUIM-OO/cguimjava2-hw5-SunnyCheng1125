public class Card {
	
	enum Suit { Club, Diamond, Heart, Spade } ;
	private Suit suit; //Definition: Clubs, Diamonds, Hearts, Spades
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s,int value) //The constructor of Card
	{
		suit=s;
		rank=value;
	}	
	
	public void printCard()
	{
		switch(suit) //Determine the input is which suit
		{
		
		case Club:
			if ( rank == 1 )
			{
				System.out.println("Club Ace");
			}
			else if ( rank == 11 )
			{
				System.out.println("Club Jake");
			}
			else if ( rank == 12 )
			{
				System.out.println("Club Queen");
				break;
			}
			else if ( rank == 13 )
			{
				System.out.println("Club King");
			}
			else
			{
				System.out.println("Club "+rank);
			}
			break;
			
		case Diamond:
			if ( rank == 1 )
			{
				System.out.println("Diamond Ace");
			}
			else if ( rank == 11 )
			{
				System.out.println("Diamond Jake");
			}
			else if ( rank == 12 )
			{
				System.out.println("Diamond Queen");
			}
			else if ( rank == 13 )
			{
				System.out.println("Diamond King");
			}
			else
			{
				System.out.println("Diamond "+rank);
			}
			break;
			
		case Heart:
			if ( rank == 1 )
			{
				System.out.println("Heart Ace");
			}
			else if ( rank == 11 )
			{
				System.out.println("Heart Jake");
			}
			else if ( rank == 12 )
			{
				System.out.println("Heart Queen");
			}
			else if ( rank == 13 )
			{
				System.out.println("Heart King");
			}
			else
			{
				System.out.println("Heart "+rank);
			}
			break;
			
		case Spade:
			if ( rank == 1 )
			{
				System.out.println("Spade Ace");
			}
			else if ( rank == 11 )
			{
				System.out.println("Spade Jake");
			}
			else if ( rank == 12 )
			{
				System.out.println("Spade Queen");
			}
			else if ( rank == 13 )
			{
				System.out.println("Spade King");
			}
			else
			{
				System.out.println("Spade "+rank);
			}
			break;
		}	
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public int getRank()
	{
		return rank;
	}  
}
