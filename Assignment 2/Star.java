/*Star.java
Written by Stephen Watson 
Student id C3339952
Assignment 2
*/
public class Star 
{

    //star's name, right ascension, declination, and spectral type
    private Star[] stars;
    private String name;
    private double ra;
    private double dec;
    private String sType;
    private Planet[] planets;

    

    public Star(String name, double ra, double dec, String sType, Planet[] planets) 
    {
        super();
        this.name = name;
        this.ra = ra;
        this.dec = dec;
        this.sType = sType;
        this.planets = planets;

    }
     

    public Star[] getStars() 
    {
        return stars;
    }

    public void setstars(Star[] s) 
    {
        this.stars = stars;
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

    public String getsType() 
    {
        return sType;
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

    public void setsType(String sType) 
    {
        this.sType = sType;
    }

     public Planet[] getPlanets() 
    {
        return planets;
    }

     public void setPlanets(Planet[] p) 
    {
        this.planets = p;
    }

}
