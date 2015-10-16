
public class DiceRoller 
{
	private String dExpression; 
	
	public DiceRoller(String dExpression)//constructor for DiceRoller, keeps track of ^^ expression
	{									//Shows up in Driver where whatever is in Driver() parameters is dExpression
		this.dExpression = dExpression;
	}
	
	public void display()//display method
	{
		System.out.println("DiceRoller: " + this.dExpression);
	}
	
	private int stringToInt(String s)//turning a string into an integer
	{
		return Integer.parseInt(s); //<--class method because integer is spelled with a capital "I" which hints that it's class instead of instance
		/*//turning a string into an integer the long way
		int place = 1;
		int total = 0; 
		for(int i = s.length()-1; i >= 0; i--)
		{
			total = total + (place * "0123456789".indexOf(s.charAt(i)));
			place = place * 10; 
		}
		return total; 
		*/
	}
	
	private int parseDice(String d)//first pass through "2D6", second pass through "3D20", separate the number of dice from the number of sides
	{								//separate "2" and "6", "3" and "20"
		System.out.println("Rolling: " + d); 
		String temp = "";//empty string
		int numberOfDice = -1; 
		int numberOfSides = -1;
		
		for(int i = 0; i < this.dExpression.length(); i++)//walking the string until we get to a "D", and once we get to a "D"
		{												  //spit out the string
			if(this.dExpression.charAt(i) != 'D')//if the current character we're looking at is not equal to "D" then..
			{
				temp = temp + this.dExpression.charAt(i);//then I want to COLLECT it(the number) and add it to temp
			}
			else
			{
				numberOfDice = this.stringToInt(temp);//takes the integer of temp from its string form
				//System.out.println(temp);//Stop! Print out what elements you have before the "D", number of dice, prints out 2 and 3
				temp = "";//empty temp, ready to read the next chunk or in this case "3D20"
			}
		}
		numberOfSides = this.stringToInt(temp);//takes the integer of temp from its string form
		//System.out.println(temp);//one final print of temp, number of sides, prints out 6 and 20
		
		Dice aDice = new Dice(numberOfSides);//roll this dice a number of times, D6
		int total = 0; //capture that total by starting a running total, captured each roll
		int aRoll;
		for(int i = 0; i < numberOfDice; i++)//rolled D6 twice
		{
			aRoll = aDice.roll();
			//total += aDice.roll(); //roll, add to total, roll add to total 
			System.out.println("Rolled a: " + aRoll); 
			total += aRoll; 
		}
		return total; //rolling the dice
	}
	private int processExpression()//already knows about the dExpression
	{								//walking the string until we get to a plus sign, and once we get to a plus sign
									//spit out the string
		String temp = ""; //empty string
		int total = 0;
		for(int i = 0; i < this.dExpression.length(); i++)//goes through every element of a string, in this case "2D6+3D20"
		{
			if(this.dExpression.charAt(i) != '+')//if the current character we're looking at is not equal to "+" then..
			{
				temp = temp + this.dExpression.charAt(i);//then I want to COLLECT it(the element) and add it to temp
			}
			else//if it IS a plus sign then..
			{
				//System.out.println(temp);// Stop! Print out what elements you have before the "+" sign
				total += this.parseDice(temp);
				temp = "";//empty temp, ready to read the next chunk or in this case "3D20"
			}
		}
		//System.out.println(temp);//one final print of temp, or in this case "3D20"
		total += this.parseDice(temp); 
		return total; 
	}
	public int roll()//teaching the dice to roll
	{
		//int sum = 0;
		//logic of what it means to roll
		return this.processExpression(); //goes through our String and pulls out each chunk or in this case "2D6" and "3D20" 
		//return sum; 
	}
}
	