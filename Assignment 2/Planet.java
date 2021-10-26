
/*Planet.java
Written by Stephen Watson 
Student id C3339952
Assignment 2
*/
public class Planet 
{

    private String name;
    private double ra;
    private double dec;
    private Star orbits;

    public Planet(String name, double ra, double dec, Star orbits) 
    {
        this.name = name;
        this.ra = ra;
        this.dec = dec;
        orbits = orbits;
    }

    public String getName() 
    {
        return name;
    }

    public double getRa() 
    {
        return ra;
    }

    public double getDec() 
    {
        return dec;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setRa(double ra) 
    {
        this.ra = ra;
    }

    public void setDec(double dec) 
    {
        this.dec = dec;
    }

    public Star getOrbits() 
    {
        return orbits;
    }

    public void setOrbits(Star orbits) 
    {
        this.orbits = orbits;
    }
    
}

