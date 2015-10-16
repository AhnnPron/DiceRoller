import java.util.Random;

public class Dice //Constructor //what the dice is
{
	//Fields--variables owned by an instance of an object
	private int numSides; 
	private String name;   
	private Random r = new Random(); 
	
	
	public Dice(int numSides) //no static for constructors 
	{
		this.numSides = numSides; 
		this.name = "D" + numSides; 
	}
	
	public int roll()
	{
		return r.nextInt(this.numSides) + 1; 
	}
}
