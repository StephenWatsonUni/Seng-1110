/*Planet.java
Written by Stephen Watson 
Student id C3339952
*/
public class Planet 
{
	private String name;
	private double ra;
	private double dec;

	public Planet(String name, double ra, double dec) 
	{
		super();
		this.name = name;
		this.ra = ra;
		this.dec = dec;
		/*super used for  class constructor.
		I learnt this technique from stackoverflow.com*/
	}
//-------------------------------------------------------------------------------------------
	/*getter for name*/
	public String getName() 
	{
		return name;
	}
//-------------------------------------------------------------------------------------------
	/*Setter for name*/
	public void setName(String name) 
	{
		this.name = name;
	}
//-----------------------------------------------------------------------------------------
	/*getter for right ascension*/
	public double getRa() 
	{
		return ra;
	}
//-----------------------------------------------------------------------------------------
	/*Setter for right ascension*/
	public void setRa(double ra) 
	{
		this.ra = ra;
	}
//-----------------------------------------------------------------------------------------
	/*getter for declination*/
	public double getDec() 
	{
		return dec;
	}
//------------------------------------------------------------------------------------------
	/*Setter for declination*/
	public void setDec(double dec) 
	{
		this.dec = dec;
	}
//-------------------------------------------------------------------------------------------
	public String toString() 
	{
		return "Planet <" + name + ">: Right Ascension <" + ra + ">: Declination <" + dec + ">";
	}
	//using toString method to return desired outputs of each object. and helps me use less code.
}