/*Interface.java
Written by Stephen Watson 
Student id C3339952
Assignment 2
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interface 
{

    private Star[] stars = null;
    private Planet[] planets = null;
    private int totalStars;
    private int totalPlanets;
    final static int N = 2;    // stars
    final static int M = 2;    // planets
    // N and M should be integer constants that a programmer can easily change
    // (2 and 2 can be used as default values).

    public Interface() 
    {
        stars = new Star[N];
        planets = new Planet[M];
        totalStars = 0;
        totalPlanets = 0;
        
    }

    public static void main(String[] args) 
    {
        Interface infFace = new Interface();
        infFace.run();
    }//main arguments

    private void run() 
    {
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
        scanner.close();
    }//running of the menu

    private void mainMenu(Scanner scanner) 
    {
        do 
        {
            System.out.println("1.  Add a star");
            System.out.println("2.  Add a planet");
            System.out.println("3.  Delete a star");
            System.out.println("4.  Delete a planet");
            System.out.println("5.  List of objects");
            System.out.println("6.  List of planets that orbit a star");
            System.out.println("7.  Angular distance between 2 objects.");
            System.out.println("8.  List of objects within an angular distance of a specified object.");
            System.out.println("9.  import Information.");
            System.out.println("10. Export Information.");
            System.out.println("0.  Exit.");

            System.out.print("Enter an option: ");
            int option = scanner.nextInt();
            switch (option) 
            {
            case 1:
                addStar(scanner);
                break;
            case 2:
                addPlanet(scanner);
                break;
            case 3:
                deleteStar(scanner);
                break;
            case 4:
                deletePlanet(scanner);
                break;
            case 5:
                printObjects();
                break;
            case 6:
                printsOrbitStar(scanner);
                break;
            case 7:
                angularDistance(scanner);
                break;
            case 8:
                angularDistance2(scanner);
                break;

            case 9:
                importInformation(scanner);
                break;
            
            case 10:
                exportInformation(scanner);
                break;
            
            case 0:
                System.out.println("Bye");
                System.exit(0);
                break;
                /*I have used (scanner) in the switch to link that particular 
                switch to its required code*/
            default:
                break;
            }
        }
        while (true);
    }//above is the complete menu

//---------------------------------------------------------------------------------------------------------
///////////Below are star methods/////////////////////////////////////////////////////////////////////////////
        // if stars is not null loop through total stars and return name if it matches
     public boolean checkForStar(String star) 
    {
        if (stars != null) 
        {
            for (int i = 0; i < totalStars; i++) 
            {
                if (stars[i].getName().trim().equals(star)) 
                {
                    return true;
                }

            }
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void deleteStar(Scanner scanner) 
    {
        System.out.print("Enter Star Name: ");
        String name = scanner.next();
        while(!checkForStar(name)) 
        {
            System.out.println("Star does not exists! please enter another Stars name");
            name = scanner.next();
        }
        int index = -1;

        if (stars != null) 
        {
            for (int i = 0; i < totalStars; i++) 
            {
                if (stars[i].getName().trim().equals(name)) 
                {

                    index = i;
                    totalPlanets = 0;
                    System.out.println("this star has been deleted " + stars[i].getName());
                    break;
                    
                }
             
            }
        
        }
///////////////////// deleting a star if stars is not null and loops through to a name that matches that match gets deleted
        if (index != -1) 
        {
            // if not last index
            if (index != totalStars - 1) 
            {
                for (int i = index; i < totalStars - 1; i++) 
                {
                    stars[i] = stars[i + 1];
                }
            }
            totalStars -= 1;
        } 
        else if (totalPlanets == 0 && totalStars == 0) 
        {
            System.out.println("No astronomical objects exist ");
            return;
        }


        else 
        {
            System.out.println("the star does not exist");
            return;
        }
        
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           



//////////////////Below are planet methods////////////////////////////////////////////////////////////////////////////////////////////
   //if planets is not null loop through total planets and return name if it matches
       
    public boolean checkForPlanet(String planet) 
    {
        if (planets != null) 
        {
            for (int i = 0; i < totalPlanets; i++)  
            {
                if (planets[i].getName().trim().equals(planet)) 
                {
                    return true;
                }
            }
        }
        return false;
    }    
////////////Above is boolean for checking for existing planets deleting a planet if planets is not null and loops through to a name that matches that match gets deleted///////////////////////////////////////////////////////////////////////////
    
    public void deletePlanet(Scanner scanner) 
    {
        
        System.out.println("Enter Planet Name: ");
        String name = scanner.next();
        while(!checkForPlanet(name)) 
        {
            System.out.println("Planet does not exists! please enter another Planet name");
            name = scanner.next();
        }
        int index = -1;

        if (planets != null) 
        {
            for (int i = 0; i < totalPlanets; i++) 
            {
                if (planets[i].getName().trim().equals(name)) 
                {
                    index = i;
                    System.out.println("this planet has been deleted " + planets[i].getName());
                    break;
                }
            }
        }

        
        if (index != -1) 
        {
            
            if (index != totalPlanets - 1) 
            {
                for (int i = index; i < totalPlanets - 1; i++) 
                {
                    planets[i] = planets[i + 1];
                }
            }
            totalPlanets -= 1;
        } 
        else 
        {
            System.out.println("Invalid Planet.");
        }
    }

/////////Above is the checking for existing planets and removing it if found/////////////////////////////////////////////////////////////////

    public double getDistance(double a1, double a2, double d1, double d2) 
    {
        return Math.acos((Math.cos(a1 - a2) * Math.cos(Math.toRadians(d1)) * Math.cos(Math.toRadians(d1))
                + Math.sin(Math.toRadians(d1)) * Math.sin(Math.toRadians(d2))));
    }
////////////////////////////math for angular distance///////////////////////////////////////////////////////////////////////////////////////


/////////////////////Beow now are all the console commands for input/////////////////////////////////////////////////////////////////////////

    private void addStar(Scanner scanner) 
    {
        String name, sType;
        double ra, dec;
         if (totalStars == N) 
        {
            System.out.println("Cannot add more stars to this full array.");
            mainMenu(scanner);

        }
        System.out.println("Enter Star Name: ");
        name = scanner.next();
        while(checkForStar(name)) 
        {
            System.out.println("Star already exists! please enter another stars name");
            System.out.println("Enter Star Name: ");
            name = scanner.next();
        } 
        
        System.out.println("Enter Right Ascension: ");
        ra = scanner.nextDouble();
        while(ra < 0.00 || ra > 360.0)
            { 
                System.out.println("invalid input re-enter right Ascention");
                ra = scanner.nextDouble();
            }//inputting right ascention with 0 to 360 degree range asking again if the input is outside that range.
        System.out.println("Enter Declination: ");
        dec = scanner.nextDouble();
        while(dec < 0.00 || dec > 90.0)
            { 
                System.out.println("invalid input re-enter declination");
                dec = scanner.nextDouble();
                System.out.println("");
            }   //inputting declination with 0 to 90 degree range asking again if the input is outside that range.
        System.out.println("Enter Spectral type: ");
        sType = scanner.next();
        while(!sType.matches("(.*)[Oo]+[\\d]||[Bb]+[\\d]||[Aa]+[\\d]||[Ff]+[\\d]||[Gg]+[\\d]||[Kk]+[\\d]||[Mm]+[\\d](.*)") || sType.length()!=2)
        {
            System.out.println(" Invalid Spectral Type: ");
            sType = scanner.next();
            //above while loop checks the string for chosen specifc chars and ints 
            
        } 
        //please check to make sure the star already exists 
        if(!checkForStar(name)) 
        {
            stars[totalStars] = new Star(name, ra, dec, sType, planets);
            totalStars += 1;
            sortStars(totalStars);// here is the extra sorting algorithm that that places the stars into order as they are added 
            System.out.println("Star added successfully");
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void addPlanet(Scanner scanner) 
    {

        if (totalPlanets == M) 
        {
           System.out.println("Can not add any more panets to this full array.");
           mainMenu(scanner);

        }
        System.out.print("Enter Planet Name: ");
        String name = scanner.next();
        while(checkForPlanet(name)) 
        {
            System.out.println("Planet already exists! please enter another Planet name");
            System.out.println("Enter Planets Name: ");
            name = scanner.next();
        } 
        System.out.print("Enter Right Ascension: ");
        double ra = scanner.nextDouble();
        while(ra < 0.00 || ra > 360.0)
            { 
                System.out.print("invalid input re-enter right Ascention" );
                ra = scanner.nextDouble();
                System.out.println("");
            }//inputting right ascention with 0 to 360 degree range asking again if the input is outside that range.
        System.out.print("Enter declination: ");
        double dec = scanner.nextDouble();
            while(dec < 0.00 || dec > 90.0)
            { 
                System.out.print("invalid input re-enter declination" );
                dec = scanner.nextDouble();
                System.out.println("");
            }//inputting declination with 0 to 90 degree range asking again if the input is outside that range.

        //please check if the planet already exists
        if (checkForPlanet(name)) 
        {
            System.out.println("Planet already exists!");
        }  
        else 
        {

            /////////// check if it orbits any star///////////////////
            Star star = null;
            System.out.println("");
            for (int i = 0; i < totalStars; i++) 
            {
                System.out.println((i + 1) + ". " + stars[i].getName());
            }
            System.out.print("Enter stars number you wish this planet to orbit ");
            int starNum = scanner.nextInt();

            if (starNum > 0 && starNum <= totalStars) 
            {
                star = stars[starNum - 1];
            }

            planets[totalPlanets] = new Planet(name, ra, dec, star);
            totalPlanets += 1;
            sortPlanets(totalPlanets);// here is the  extra sorting algorithm that organises the stars as they are added  
            System.out.println("Planet added successfully");
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void printObjects() 
    {

        if (totalPlanets == 0 && totalStars == 0) 
        {
            System.out.println("No astronomical objects exist ");
            return;
        }

        for (int i = 0; i < totalStars; i++) 
        {
            Star star = stars[i];
            System.out.println("Star: <" + star.getName() + "> coordinate <" + star.getRa() + "> <" + star.getDec()
                    + ">, spectral type <" + star.getsType() + ">");
        }

        for (int i = 0; i < totalPlanets; i++)
        {
            Planet planet = planets[i];
            System.out.println("Planet: <" + planet.getName() + "> coordinate <" + planet.getRa() + "> <" + planet.getDec() + ">");
        }   //checking for total planets and total stars and printing that array 

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private void printsOrbitStar(Scanner scanner) 
    {

        
        System.out.print("Enter Stars Name: ");
        String name = scanner.next();
        for (int i = 0; i < totalPlanets; i++) 
        {
            if(stars[i] == null) 
            {  
                
                System.out.print("No Stars or planets exist");
            }
                
            if(stars[i] != null && stars[i].getName().equalsIgnoreCase(name)) 
            {
                System.out.println("Planet: <" + planets[i].getName() + "> orbits this star");
             
            }  
        } //printing the planet array that is attached to the star array if stars array is not = to null
        
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

    private void angularDistance(Scanner scanner) 
    {
        Star star = null;
        Planet planet = null;
        
        System.out.print("Enter Star Name: ");
        String name = scanner.next();
        if (!checkForStar(name)) 
        {
            System.out.println("star does not exist");
            return;
        }
        for (int i = 0; i < totalStars; i++) 
        {
            if (stars[i].getName().trim().equals(name)) 
            {
                star = stars[i];
                break;
            }
        }
        
        System.out.print("Enter Planet Name: ");
        name = scanner.next();
        if (!checkForPlanet(name)) 
        {
            System.out.println("Planet does not exist");
            return;
        }
        for (int i = 0; i < totalPlanets; i++) 
        {
            if (planets[i].getName().trim().equals(name)) 
            {
                planet = planets[i];
                break;
            }
        }
        
        double dist = getDistance(star.getRa(), star.getDec(), planet.getRa(), planet.getDec());
        System.out.println(" Angular Distance: " + dist);
    }   

    //Above code gives the angular distance between  star and planets 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void angularDistance2(Scanner scanner) 
    {
        Star star = null;
        Planet planet = null;
        
        System.out.print("Enter Star Name: ");
        String name = scanner.next();
        if (!checkForStar(name)) 
        {
            System.out.println("star does not exist");
            return;
        }
        for (int i = 0; i < totalStars; i++) 
        {
            if (stars[i].getName().trim().equals(name)) 
            {
                star = stars[i];
                break;
            }
        }
        
        System.out.print("Enter Planet Name: ");
        name = scanner.next();
        if (!checkForPlanet(name)) 
        {
            System.out.println("Planet does not exist");
            return;
        }
        for (int i = 0; i < totalPlanets; i++) 
        {
            if (planets[i].getName().trim().equals(name)) 
            {
                planet = planets[i];
                break;
            }
        }
        
            double dist = getDistance(star.getRa(), star.getDec(), planet.getRa(), planet.getDec());
            System.out.println("Star " + star.getName() + " " + " has Angular Distance "  + dist + " from " + planet.getName());
            System.out.println("Planet " + planet.getName() + " " + " has Angular Distance "  + dist + " from " + star.getName());
    }
    //above gives angular  distance of the specied objects checking for names and getting there values from setters and getters
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     private void importInformation(Scanner scanner) 
     {
        String fileName, starOrPlanet, name, sType, line;
        String[] parts;
        double ra, dec;
        System.out.print("Enter the name of file to import: ");
        fileName = scanner.next();

        resetPlanetAndStars();

        // create file scanner to read the file
        Scanner fileScanner;
        try 
        {
            fileScanner = new Scanner(new File(fileName));

            // read file
            while (fileScanner.hasNext()) 
            {
                line = fileScanner.nextLine();
                parts = line.split(" ",5);
                starOrPlanet = parts[0];
                System.out.println("" + parts[0].toLowerCase());
                name = parts[1].toLowerCase();
                ra = Double.parseDouble(parts[2].toLowerCase());
                dec = Double.parseDouble(parts[3].toLowerCase());
                sType = parts[4].toLowerCase();
                if (starOrPlanet.equalsIgnoreCase("PLANET")) 
                {
                    //above prints the array positions ars required and into lowercase 
                    //checking if the objects already exists and will not allow you to import just planets if no stars are imported or currently exists
                    
                    while(totalStars < 1)
                    {
                        System.out.println("there are no stars created for the imported planets, please create stars first.");
                        mainMenu(scanner);;
                        return;
                    }
                    if (checkForPlanet(name)) 
                    {
                        System.out.println("Planet already exists!");
                    } 
                    else if (totalPlanets == M) 
                    {
                        System.out.println("Cannot add more planets.");
                    } 

                    else 
                    {   /////////// check if it orbits any star///////////////////
                        Star star = null;
                        System.out.println("");
                        for (int i = 0; i < totalStars; i++) 
                        {
                            System.out.println((i + 1) + ". " + stars[i].getName());
                        }
                        System.out.println("Enter star number to select orbit or 0 for none: ");
                        int starNum = scanner.nextInt();

                        if (starNum > 0 && starNum <= totalStars) 
                        {
                            star = stars[starNum - 1];
                        }

                        planets[totalPlanets] = new Planet(name, ra, dec, star);
                        totalPlanets += 1;
                        System.out.println("Planet added successfully");
                    }

                } 
                else if (starOrPlanet.equalsIgnoreCase("STAR")) 
                {
                    //please check to make sure the star already exists
                    if (checkForStar(name)) 
                    {
                        System.out.println("Star already exists!");
                    } 
                    else if (totalStars == N) 
                    {
                        System.out.println("Cannot add more stars.");
                    } 
                    else 
                    {
                        stars[totalStars] = new Star(name, ra, dec, sType, planets);
                        totalStars += 1;
                        System.out.println("Star added successfully");
                    }
                } 
                else 
                {
                    System.out.println("Invalid Object: " + starOrPlanet);
                }
            }

            sortStars(totalStars);// extra sorting alogorithm for stars
            sortPlanets(totalPlanets);//extra sorting alogorithm for planets

            System.out.println("\nPlant and Star information imported successfully.\n");

            fileScanner.close();

        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Error occurred while reading from file.");
            mainMenu(scanner);
        }

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void exportInformation(Scanner scanner) 
    {
        String fileName;
        System.out.print("Enter the name of export file: ");
        System.out.print("Please tray again starting from main menu ");
        fileName = scanner.next();

        try 
        {
            PrintStream  outStream = new PrintStream(new File(fileName));

            if (totalPlanets == 0 && totalStars == 0) 
            {
                System.out.println("No astronomical objects exist ");
                return;
            }

            for (int i = 0; i < totalStars; i++) 
            {
                Star star = stars[i];
                outStream.println("STAR " + star.getName().toLowerCase() + " " + star.getRa() + " " + star.getDec()
                        + " " + star.getsType());
            }

            for (int i = 0; i < totalPlanets; i++) 
            {
                Planet planet = planets[i];
                outStream.println("PLANET " + planet.getName().toLowerCase() + " " + planet.getRa() + " " + planet.getDec());
            }

            outStream.close();
            
             System.out.println("\nPlant and Star information exported successfully.\n");
        } 
        catch (IOException ex) 
        {
            System.out.println("Error occured while exporting.");
            System.out.print("Please tray again starting from main menu ");
            mainMenu(scanner);
        }
    }
    //Above is the same format for exporting the documents as used in importing
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void resetPlanetAndStars() 
    {
        for (int i = 0; i < totalPlanets; i++) 

        {
            planets[i] = null;
        }
        totalPlanets = 0;

        for (int i = 0; i < totalStars; i++) 
        {
            stars[i] = null;
        }
        totalStars = 0;
    }
    //above used to resset totalplanets and totalstars if either array is null
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //below is sorting stars algorithm that uses compareto which is from the string library, this method was conmfirmed for use in lecture 
    private void sortStars(int n) 
    { 
        if (n <= 1) 
            return; 
       
        for (int i=0; i<n-1; i++) 
            if (stars[i].getName().compareTo(stars[i+1].getName()) > 1) 
            { 
                Star temp = stars[i]; 
                stars[i] = stars[i+1]; 
                stars[i+1] = temp; 
            } 
       
        sortStars(n-1); 
    } 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       //below is sorting planets algorithm that uses compareto which is from the string library, this method was conmfirmed for use in lecture 
    private void sortPlanets(int n) 
    { 
        if (n <= 1) 
            return; 
       
        for (int i=0; i < n-1; i++) 
            if (planets[i].getName().compareTo(planets[i+1].getName()) > 1) 
            { 
                Planet temp = planets[i]; 
                planets[i] = planets[i+1]; 
                planets[i+1] = temp; 
            } 
       
        sortPlanets(n-1); 
    } 
}   
