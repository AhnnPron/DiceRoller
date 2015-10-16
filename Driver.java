public class Driver //Main
{

	public static void main(String[] args) 
	{
		DiceRoller dr = new DiceRoller("2D6+3D20");
		//dr.display();
		//dr.roll(); //create a variable called "sum", set it equal to zero, then call our "processExpression" which will show "2D6" and 
				   //"3D20", then return zero. 
		System.out.println(dr.roll()); 
	}
}