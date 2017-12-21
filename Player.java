
public class Player extends Person {
	
	private String name; //	Player's name
	private int chips;   // Player's chips
	private int bet;     // Player's bet in this time
	
	public Player(String name, int chips)  // The constructor of Player.
	{
		this.name=name; // Overload
		this.chips=chips; // Overload
	}
	public String getName() // Get the Player's name
	{
		return name;
	}
	public int makeBet() // Make a basic bet number
	{
		bet=1;
		return bet;
	}

	public int getCurrentChips() //	Return player's latest chips
	{
		return chips;
	}
	public void increaseChips (int diff) //	Change player's current chips, accroding to the result of game.
	{
		bet=diff;
		chips=chips+bet;
	}
	public void sayHello() //Player greeting
	{
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
		System.out.println("");
	}
	@Override
	public boolean hit_me(Table table) {
		// TODO Auto-generated method stub

		if(getTotalValue()<=16)
			return true;
		else
			return false;
	}
}
