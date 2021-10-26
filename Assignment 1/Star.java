
/*Star.java
Written by Stephen Watson 
Student id C3339952
*/
public class Star
{
	private String name;
	private double ra;
	private double dec;
	private String sType;
	private Planet planet1;
	private Planet planet2;

	public Star(String name, double ra, double dec, String sType, Planet planet1, Planet planet2) 
	{
		super();
		this.name = name;
		this.ra = ra;
		this.dec = dec;
		this.sType = sType;
		this.planet1 = planet1;
		this.planet2 = planet2;
		/*super used for  class constructor.
		I learnt this technique from stackoverflow.com*/
	}
//-----------------------------------------------------------------------------------------------
	/*getter for name*/
	public String getName() 
	{
		return name;
	}
//----------------------------------------------------------------------------------------
	/*Setter for name*/
	public void setName(String name)
	{
		this.name = name;
	}
//-------------------------------------------------------------------------------------------------
	/*getter for right ascension*/
	public double getRa() 
	{
		return ra;
	}
//--------------------------------------------------------------------------------------------
	/*Setter for right ascension*/
	public void setRa(double ra) 
	{
		this.ra = ra;
	}

//---------------------------------------------------------------------------------------------
	/*getter for declination*/
	public double getDec() 
	{
		return dec;
	}
//--------------------------------------------------------------------------------------------
	/*Setter for declination*/
	public void setDec(double dec) 
	{
		this.dec = dec;
	}

//-------------------------------------------------------------------------------------------
	/*getter for sType*/
	public String getsType() 
	{
		return sType;
	}
//-------------------------------------------------------------------------------------------
	/*setter for sType*/
	public void setsType(String sType) 
	{
		this.sType = sType;
	}
//----------------------------------------------------------------------------------------
	/*getter for Planet1*/
	public Planet getPlanet1() 
	{
		return planet1;
	}

//------------------------------------------------------------------------------------------
	/*setter for Planet1*/
	public void setPlanet1(Planet planet1) 
	{
		this.planet1 = planet1;
	}
//--------------------------------------------------------------------------------------------
	/*getter for Planet2*/
	public Planet getPlanet2() 
	{
		return planet2;
	}
//-------------------------------------------------------------------------------------------
	/*setter for Planet2*/
	public void setPlanet2(Planet planet2) 
	{
		this.planet2 = planet2;
	}

	public String toString() 
	{
		return "Star <" + name + ">: Right Ascension <" + ra + ">: Declination <" + dec + ">: spectral type <" + sType + ">";
	}
	//using toString method to return desired outputs of each object. and helps me use less code.
}
