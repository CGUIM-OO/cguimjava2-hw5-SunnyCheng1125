import java.util.ArrayList;

public class Table 
{	
	public static final int MAXPLAYER = 4;
	private Deck deck;
	private Player[] players;
	private Dealer dealer;
	private int[] pos_betArray;
	private int nDecks;
	private int faceUpCard;
	
	//Record dealer and players cards
	ArrayList<Card> dealerCard=new ArrayList<Card>();
	ArrayList<Card> player1Card=new ArrayList<Card>();
	ArrayList<Card> player2Card=new ArrayList<Card>();
	ArrayList<Card> player3Card=new ArrayList<Card>();
	ArrayList<Card> player4Card=new ArrayList<Card>();
	
	
	public Table (int nDeck)
	{
		this.nDecks = nDecks;
		deck = new Deck(nDeck);
		players = new Player[MAXPLAYER]; 
	}
	
	public void set_player(int pos, Player p)
	{
		players[pos]=p;
	}
	public Player[] get_player()
	{
		return players;
	}
	public void set_dealer(Dealer d)
	{
		dealer=d;
	}
	public Card get_face_up_card_of_dealer()
	{
		return get_face_up_card_of_dealer();
	}
	private void ask_each_player_about_bets()
	{
		//Each player greeting to others
		for(int i=0;i<MAXPLAYER;i++)
		{
			players[i].sayHello();
			players[i].makeBet();
		}
	}
	private void distribute_cards_to_dealer_and_players()
	{
		//Everyone get cards
		player1Card.add(deck.getOneCard(true));
		player2Card.add(deck.getOneCard(true));
		player3Card.add(deck.getOneCard(true));
		player4Card.add(deck.getOneCard(true));
		dealerCard.add(deck.getOneCard(true));
		for(int i=0;i<MAXPLAYER;i++)
		{
			if(i==0)
			{
				players[i].setOneRoundCard(player1Card);
			}
			else if(i==1)
			{
				players[i].setOneRoundCard(player2Card);
			}
			else if(i==2)
			{
				players[i].setOneRoundCard(player3Card);
			}
			else if(i==3)
			{
				players[i].setOneRoundCard(player4Card);
			}
		}
		dealer.setOneRoundCard(dealerCard);
		System.out.println("Dealer's face up card is : ");
		dealerCard.get(faceUpCard).printCard(); //dealer's open card
		System.out.println("");
	}
	private void ask_each_player_about_hits()
	{
		//Use For Loop to ask each player if they want to get another card 
		boolean hit=false;
		for(int i=0; i<MAXPLAYER; i++)
		{
			if(i==0)
			{
				do{
					hit=players[i].hit_me(this); //this
					if(hit)
					{
						player1Card.add(deck.getOneCard(true));
						players[i].setOneRoundCard(player1Card);
						System.out.print("Hit! ");
						System.out.println(players[i].getName()+"'s Cards now:");
						for(Card c : player1Card){
							c.printCard();
							}
					}
					else
					{
						System.out.println("Pass hit!");
						System.out.println(players[i].getName()+"'s hit is over!");
						System.out.println("");
					}
				}while(hit);
			}
			else if(i==1)
			{
				do{
					hit=players[i].hit_me(this); //this
					if(hit)
					{
						player2Card.add(deck.getOneCard(true));
						players[i].setOneRoundCard(player2Card);
						System.out.print("Hit! ");
						System.out.println(players[i].getName()+"'s Cards now:");
						for(Card c : player2Card){
							c.printCard();
							}
					}
					else
					{
						System.out.println("Pass hit!");
						System.out.println(players[i].getName()+"'s hit is over!");
						System.out.println("");
					}
				}while(hit);
			}
			else if(i==2)
			{
				do{
					hit=players[i].hit_me(this); //this
					if(hit)
					{
						player3Card.add(deck.getOneCard(true));
						players[i].setOneRoundCard(player3Card);
						System.out.print("Hit! ");
						System.out.println(players[i].getName()+"'s Cards now:");
						for(Card c : player3Card){
							c.printCard();
							}
					}
					else
					{
						System.out.println("Pass hit!");
						System.out.println(players[i].getName()+"'s hit is over!");
						System.out.println("");
					}
				}while(hit);
			}
			else if(i==3)
			{
				do{
					hit=players[i].hit_me(this); //this
					if(hit)
					{
						player4Card.add(deck.getOneCard(true));
						players[i].setOneRoundCard(player4Card);
						System.out.print("Hit! ");
						System.out.println(players[i].getName()+"'s Cards now:");
						for(Card c : player4Card){
							c.printCard();
							}
					}
					else
					{
						System.out.println("Pass hit!");
						System.out.println(players[i].getName()+"'s hit is over!");
						System.out.println("");
					}
				}while(hit);
			}
		}
	}
	private void ask_dealer_about_hits()
	{
		//Ask dealer if need next card
		boolean hit=false;
		do{
			hit=dealer.hit_me(this); //this
			if(hit)
			{
				dealerCard.add(deck.getOneCard(true));
				dealer.setOneRoundCard(dealerCard);
			}
			else
			{
				System.out.println("Dealer's hit is over!");
			}
		}while(hit);
	}
	private void calculate_chips()
	{
		System.out.println("Dealer's cards value is "+dealer.getTotalValue()+" , Cards :");
		for(Card c : dealerCard){
			c.printCard();
			}
		System.out.println("");
		for(int i=0; i<MAXPLAYER; i++)
		{	
			if(i==0)
			{
				int p1Bet=players[i].makeBet();
				System.out.println(players[i].getName()+"'s Cards :");
				for(Card c : player1Card){
					c.printCard();
					}
				System.out.print(players[i].getName()+"'s card value is :"+players[i].getTotalValue());
				
				//if dealer and player1 get draw
				if((dealer.getTotalValue())==(players[i].getTotalValue()))
				{
					//When player1 wins exception
					if(((dealer.getTotalValue()) & (players[i].getTotalValue())) == 21)
					{
						players[i].increaseChips(p1Bet);
						System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
					}
					else
					{
						System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
					}
				}
				else if((dealer.getTotalValue() & players[i].getTotalValue()) > 21)
				{
					System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
				}
				
				//if dealer wins
				else if( (dealer.getTotalValue() == 21) & (((players[i].getTotalValue()) < 21) || (players[i].getTotalValue() > 21)))
				{
					players[i].increaseChips(-p1Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (dealer.getTotalValue() <= 21) & ( ( ((dealer.getTotalValue() > players[i].getTotalValue()) & ((players[i].getTotalValue()<21)) )|| (players[i].getTotalValue() > 21))))
				{
					players[i].increaseChips(-p1Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				
				//if player1 wins
				else if( (players[i].getTotalValue() == 21) & (((dealer.getTotalValue()) < 21) || (dealer.getTotalValue() > 21)))
				{
					players[i].increaseChips(p1Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (players[i].getTotalValue() <= 21) & ( ( ((players[i].getTotalValue() > dealer.getTotalValue()) & ((dealer.getTotalValue()<21)) )|| (dealer.getTotalValue() > 21))))
				{
					players[i].increaseChips(p1Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				
				System.out.println("");	
			}
			else if(i==1)
			{
				int p2Bet=players[i].makeBet();
				System.out.println(players[i].getName()+"'s Cards now:");
				for(Card c : player2Card){
					c.printCard();
					}
				System.out.print(players[i].getName()+"'s card value is :"+players[i].getTotalValue());
				//if dealer and player get draw
				if((dealer.getTotalValue())==(players[i].getTotalValue()))
				{
					//@hen player2 wins exception
					if(((dealer.getTotalValue()) & (players[i].getTotalValue())) == 21)
					{
						players[i].increaseChips(p2Bet);
						System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
					}
					else
					{
						System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
					}
				}
				else if((dealer.getTotalValue() & players[i].getTotalValue()) > 21)
				{
					System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
				}
				
				//if dealer wins
				else if( (dealer.getTotalValue() == 21) & (((players[i].getTotalValue()) < 21) || (players[i].getTotalValue() > 21)))
				{
					players[i].increaseChips(-p2Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (dealer.getTotalValue() <= 21) & ( ( ((dealer.getTotalValue() > players[i].getTotalValue()) & ((players[i].getTotalValue()<21)) ) || (players[i].getTotalValue() > 21))))
				{
					players[i].increaseChips(-p2Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				
				//if player2 wins
				else if( (players[i].getTotalValue() == 21) & (((dealer.getTotalValue()) < 21) || (dealer.getTotalValue() > 21)))
				{
					players[i].increaseChips(p2Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (players[i].getTotalValue() <= 21) & ( ( ((players[i].getTotalValue() > dealer.getTotalValue()) & ((dealer.getTotalValue()<21)) )|| (dealer.getTotalValue() > 21))))
				{
					players[i].increaseChips(p2Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				System.out.println("");
			}
			else if(i==2)
			{
				int p3Bet=players[i].makeBet();
				System.out.println(players[i].getName()+"'s Cards now:");
				for(Card c : player3Card){
					c.printCard();
					}
				System.out.print(players[i].getName()+"'s card value is :"+players[i].getTotalValue());
				//if dealer and player get draw
				if((dealer.getTotalValue())==(players[i].getTotalValue()))
				{
					//When player3 wins exception
					if(((dealer.getTotalValue()) & (players[i].getTotalValue())) == 21)
					{
						players[i].increaseChips(p3Bet);
						System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
					}
					else
					{
						System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
					}
				}
				else if(((dealer.getTotalValue()) & (players[i].getTotalValue())) > 21)
				{
					System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
				}
				
				//if dealer wins
				else if( (dealer.getTotalValue() == 21) & (((players[i].getTotalValue()) < 21) || (players[i].getTotalValue() > 21)))
				{
					players[i].increaseChips(-p3Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (dealer.getTotalValue() <= 21) & ( ( ((dealer.getTotalValue() > players[i].getTotalValue()) & ((players[i].getTotalValue()<21)) )|| (players[i].getTotalValue() > 21))))
				{
					players[i].increaseChips(-p3Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				
				//if player3 wins
				else if( (players[i].getTotalValue() == 21) & (((dealer.getTotalValue()) < 21) || (dealer.getTotalValue() > 21)))
				{
					players[i].increaseChips(p3Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (players[i].getTotalValue() <= 21) & ( ( ((players[i].getTotalValue() > dealer.getTotalValue()) & ((dealer.getTotalValue()<21)) )|| (dealer.getTotalValue() > 21))))
				{
					players[i].increaseChips(p3Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				System.out.println("");
			}
			else if(i==3)
			{
				int p4Bet=players[i].makeBet();
				System.out.println(players[i].getName()+"'s Cards now:");
				for(Card c : player4Card){
					c.printCard();
					}
				System.out.print(players[i].getName()+"'s card value is :"+players[i].getTotalValue());
				//if dealer and player get draw
				if((dealer.getTotalValue()==players[i].getTotalValue()))
				{
					//When player4 wins exception
					if(((dealer.getTotalValue()) & (players[i].getTotalValue())) == 21)
					{
						players[i].increaseChips(p4Bet);
						System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
					}
					else
					{
						System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
					}
				}
				else if(((dealer.getTotalValue()) & (players[i].getTotalValue())) > 21)
				{
					System.out.println(",chips have no change! The Chips now is: " + players[i].getCurrentChips());
				}
				
				//if dealer wins
				else if( (dealer.getTotalValue() == 21) & (((players[i].getTotalValue()) < 21) || (players[i].getTotalValue() > 21)))
				{
					players[i].increaseChips(-p4Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (dealer.getTotalValue() <= 21) & ( ( ((dealer.getTotalValue() > players[i].getTotalValue()) & ((players[i].getTotalValue()<21)) )|| (players[i].getTotalValue() > 21))))
				{
					players[i].increaseChips(-p4Bet);
					System.out.println(", Loss  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				
				//if player4 wins
				else if( (players[i].getTotalValue() == 21) & (((dealer.getTotalValue()) < 21) || (dealer.getTotalValue() > 21)))
				{
					players[i].increaseChips(p4Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				else if( (players[i].getTotalValue() <= 21) & ( ( ((players[i].getTotalValue() > dealer.getTotalValue()) & ((dealer.getTotalValue()<21)) )|| (dealer.getTotalValue() > 21))))
				{
					players[i].increaseChips(p4Bet);
					System.out.println(", Get  "+players[i].makeBet()+"  Chips, the Chips now is: "+ players[i].getCurrentChips());
				}
				System.out.println("");
			}
		}
	}
	public int[] get_palyers_bet()
	{
		pos_betArray = new int[MAXPLAYER]; //Initialize the pos_betArray Array
		return pos_betArray;
	}
	public void play()
	{
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();
	}
}


