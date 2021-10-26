/*Interface.java
Written by Stephen Watson 
Student id C3339952
*/
import java.util.Scanner;
public class Interface 
{
    private Star star1 = null;
    private Star star2 = null;

    public static void main(String[] args) 
    {
        Interface infFace = new Interface();
        infFace.run();
    }

    private void run() 
    {
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
        scanner.close();
    } 

    private void mainMenu(Scanner scanner) 
    {
        do 
        {
            System.out.println("1. Add a star");
            System.out.println("2. Add a planet");
            System.out.println("3. Delete a star");
            System.out.println("4. Delete a planet");
            System.out.println("5. List of objects");
            System.out.println("6. List of planets that orbit a star");
            System.out.println("7. Angular distance between 2 objects.");
            System.out.println("8. List of objects within an angular distance of a specified object.");
            System.out.println("9. Exit.");

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
                deletePlannet(scanner);
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
    }

    //--------------------------------------------------------------------------------------------
    private void addStar(Scanner scanner) 
    {
        if (star1 != null && star2 != null) 
        {
            System.out.println("There are already 2 stars");
            return;//if both stars are not empty tell the user 2 stars exist 
        }
        else
        {
            System.out.print("Enter Star's Name: ");
            String name = scanner.next();

            if (star1 != null && star1.getName().equals(name)) 
            {
                System.out.println("Star is already exists");
                return;
            }
            if (star2 != null && star2.getName().equals(name)) 
            {
                System.out.println("Star is already exists");
                return;
            }
             System.out.print("Enter right ascension: ");
             double ra = scanner.nextDouble();
            while(ra < 0.00 || ra > 360.0)
            { 
                System.out.print("invalid input re-enter right Ascention");
                ra = scanner.nextDouble();
                System.out.println("");
            }//inputting right ascention with 0 to 360 degree range asking again if the input is outside that range.
            System.out.print("Enter declination: ");
            double dec = scanner.nextDouble();
            while(dec < 0.00 || dec > 90.0)
            { 
                 System.out.print("invalid input re-enter declination");
                dec = scanner.nextDouble();
                System.out.println("");
            }   //inputting declination with 0 to 90 degree range asking again if the input is outside that range.
            System.out.print("Enter spectral type: ");
            String sType = scanner.next();
             while(!sType.matches("(.*)[Oo]+[\\d]||[Bb]+[\\d]||[Aa]+[\\d]||[Ff]+[\\d]||[Gg]+[\\d]||[Kk]+[\\d]||[Mm]+[\\d](.*)") || sType.length()!=2)
            {
            System.out.println(" Invalid Spectral Type: ");
            sType = scanner.next();
            //above while loop checks the string for chosen specifc chars and ints 
            } 
            if (star1 == null) 
            {
                star1 = new Star(name, ra, dec, sType, null, null);
            } 
            else if (star2 == null) 
            {
                star2 = new Star(name, ra, dec, sType, null, null);
            }//tell the program if star 1 or star 2 is empty create new star.
        }
    }
    //---------------------------------------------------------------------------------------------------------
    private void addPlanet(Scanner scanner) 
    {
        System.out.print("Enter Planet Name: ");
        String name = scanner.next();

     
        System.out.print("Enter right ascension: ");
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
        System.out.print("Enter the star its orbiting ");
        String starName = scanner.next();
        Planet planet1 = new Planet(name, ra, dec);
        if (star1 != null) 
        {
            if (star1.getName().equals(starName)) 
            {

                if (star1.getPlanet1() == null) 
                {
                    star1.setPlanet1(planet1);
                } 
                else if (star1.getPlanet2() == null) 
                {
                    star1.setPlanet2(planet1);
                } 
                else if (star1 != null && (star1.getPlanet1().getName().equals(name)

                        || star1.getPlanet2().getName().equals(name))) 
                {
                    System.out.println(" the planet already exists");
                    return;
                } /*this is letting the program know if the star returns a name and planets are empty 
                    create that planet and if the star name returns an name and the planets returns
                    a name that planet already exists. */
                else 
                {
                    System.out.println(" the star already has 2 orbiting planets.");
                }
            }
        }

        if (star2 != null) 
        {
            if (star2.getName().equals(starName))
             {
                if (star2.getPlanet1() == null) 
                {
                    star2.setPlanet1(planet1);
                } 
                else if (star2.getPlanet2() == null) 
                {
                    star2.setPlanet2(planet1);
                } 
                else if (star2 != null && (star2.getPlanet1().getName().equals(name)

                        || star2.getPlanet2().getName().equals(name))) 
                {
                    System.out.println("the planet already exists");
                    return;
                } 
                else
                {
                    System.out.println(" the star already has 2 orbiting planets.");
                }
            }
        }

    }
//----------------------------------------------------------------------------------------   
    

    //-------------------------------------------------------------------------------------------------
    private void deleteStar(Scanner scanner) 
    {
        System.out.print("Enter Star's Name: ");
        String name = scanner.next();
        if (star1 != null && star1.getName().equals(name)) 
        {
            star1 = null;
            System.out.println("Star1 is deleted");
            //to deleted you go backwards if star1 is not empty and returns a name star1  empty
            //and print out it is deleted
        } 
        else if (star2 != null && star2.getName().equals(name)) 
        {
            star2 = null;
            System.out.println("Star2 is deleted");
            //to deleted you go backwards if star1 is not empty and returns a name star1  empty
            //and print out it is deleted
        } 
        else 
        {
            System.out.println("Star doesn't exist");
            return;
        }//if nothing returns a method print out does not exists.
    }

    //-----------------------------------------------------------------------------------------------
    private void deletePlannet(Scanner scanner) 
    {
        System.out.print("Enter Planet Name: ");
        String name = scanner.next();
        if (star1 != null && star1.getPlanet1() != null && star1.getPlanet1().getName().equals(name)) 
        {
            star1.setPlanet1(null);
            System.out.println("Planet1 is deleted from star1");
        } 
        else if (star1 != null && star1.getPlanet2() != null && star1.getPlanet2().getName().equals(name)) {
            star1.setPlanet2(null);
            System.out.println("Planet2 is deleted from star1");
        }
        if (star2 != null && star2.getPlanet1() != null && star2.getPlanet1().getName().equals(name)) 
        {
            star2.setPlanet1(null);
            System.out.println("Planet1 is deleted from star2");
        } 
        else if (star2 != null && star2.getPlanet2() != null && star2.getPlanet2().getName().equals(name)) 
        {
            star2.setPlanet2(null);
            System.out.println("Planet2 is deleted from star2");
        } 
        else
        {
            System.out.println("the planet does not exist");
            return;
        }    //Same again, to deleted you go backwards if star1 is not empty and planet1 is not empty and returns a name planet1
            //planet1 = empty. If nothing returns a method print out planet does not exists.

    }


    //-----------------------------------------------------------------------------------------
    private void printObjects() 
    {
        boolean isFound = false;
        if (star1 != null) 
        {
            System.out.println(star1);
            if (star1.getPlanet1() != null)
             {
                System.out.println(star1.getPlanet1());
            }
            if (star1.getPlanet2() != null) 
            {
                System.out.println(star1.getPlanet2());
            }
            isFound = true;
        }   /*boolean created to determine if stars and planets are empty or return a method
            a method and print them out accordingly. for example
            if star 1 is not empty and thats false it will not print star 1, it will print star1 if star 1 is
            not empty and that = true.*/

        if (star2 != null) 
        {
            System.out.println(star2);
            if (star2.getPlanet1() != null) 
            {
                System.out.println(star2.getPlanet1());
            }
            if (star2.getPlanet2() != null) {
                System.out.println(star2.getPlanet2());
            }
            isFound = true;
        }
           /*boolean created to determine if stars and planets are empty or return a method
            a method and print them out accordingly. for example
            if planet1 for star2 is not empty and thats false it will not print planet1, it will print planet1 for star2 if planet 1 is
            not empty and star2 is not empty and that = true.*/


        if (!isFound) 
        {
            System.out.println("No Stars or planets exist");
        }

    }
    //-------------------------------------------------------------------------------------
    
//---------------------------------------------------------------------------------------
    private void printsOrbitStar(Scanner scanner) 
    {
        System.out.print("Enter Star Name: ");
        String name = scanner.next();
        if (star1 != null && star1.getName().equals(name)) 
        {

            if (star1.getPlanet1() != null) 
            {
                System.out.println("Planet <" + star1.getPlanet1().getName() + "> orbits this star");
                return;
            }

            if (star1.getPlanet2() != null) 
            {
                System.out.println("Planet <" + star1.getPlanet2().getName() + "> orbits this star");
                return;
                 /* if star 1 is not empty and returns a method, and either planet is
                not empty print out planet1 and planet 2 for star1*/
            } 
            else 
            {
                System.out.println("No planets orbit this star");
            }
        } 
        else if (star2 != null && star2.getName().equals(name)) 
        {
            if (star2.getPlanet1() != null) 
            {
                System.out.println("Planet <" + star2.getPlanet1().getName() + "> orbits this star");
                return;
            }

            if (star2.getPlanet2() != null) 
            {
                System.out.println("Planet <" + star2.getPlanet2().getName() + "> orbits this star");
                return;
            }  /* if star 2 is not empty and returns a method, and either planet is
                not empty print out planet1 and planet 2 for star2*/
            else 
            {
                System.out.println("No planets orbit this star");
            }
        }       /*if planets do not return a method but the star does and is not empty
                print  out no planets orbit this star*/
                        
        else 
        {
            System.out.println("the star does not exist.");
            return;
        }   //if the star does not rerturn a name print out star does not exists.
    }
//--------------------------------------------------------------------------------------------------------------

    public double getDistance(double a1, double a2, double d1, double d2) 
    {
        return Math.acos((Math.cos(a1 - a2) * Math.cos(Math.toRadians(d1)) * Math.cos(Math.toRadians(d1))
                + Math.sin(Math.toRadians(d1)) * Math.sin(Math.toRadians(d2))));
    }   /*maths component of the assignment covered in last weeks lecture.
    (side note) thank you for the equation or I might not of worked it out :) */

    private void angularDistance(Scanner scanner) 
    {
        Star object1 = null;
        Star object2 = null;
        Planet p1 = null;
        Planet p2 = null;
        System.out.print("Enter Objects Name: ");
        String name1 = scanner.next();
        System.out.print("Enter objects Name: ");
        String name2 = scanner.next();
        if (star1 != null && star1.getName().equals(name1)) 
        {
            object1 = star1;
            if (star1.getPlanet1() != null && star1.getPlanet1().getName().equals(name2)) 
            {
                p1 = star1.getPlanet1();
            } 
            else if (star1.getPlanet2() != null && star1.getPlanet2().getName().equals(name2)) 
            {
                p2 = star1.getPlanet2();
            }
        }    /*if star 1 is not empty object1 returns planet1 name in set name1 string, set name 1 to planet1. 
            this goes for all planet names being set accordingly*/ 
        else if (star1 != null && star1.getName().equals(name2)) 
        {
            object1 = star1;
            if (star1.getPlanet1() != null && star1.getPlanet1().getName().equals(name1)) 
            {
                p1 = star1.getPlanet1();
            } 
            else if (star1.getPlanet2() != null && star1.getPlanet2().getName().equals(name1)) 
            {
                p2 = star1.getPlanet2();
            }
        } 
        else if (star2 != null && star2.getName().equals(name1)) 
        
        {
            object2 = star2;
            if (star2.getPlanet1() != null && star2.getPlanet1().getName().equals(name2)) 
            {
                p1 = star2.getPlanet1();
            } 
            else if (star2.getPlanet2() != null && star2.getPlanet2().getName().equals(name2)) 
            {
                p2 = star2.getPlanet2();
            }
        } 
        else if (star2 != null && star2.getName().equals(name2)) 
        {
            object2 = star2;
            if (star2.getPlanet2() != null && star2.getPlanet1().getName().equals(name1)) 
            {
                p1 = star2.getPlanet1();
            } 
            else if (star2.getPlanet2() != null && star2.getPlanet2().getName().equals(name1)) 
            {
                p2 = star2.getPlanet2();
            }
             /*same here. If star 2 is not empty object2 returns planet1 name in name1 string, set name 1 to planet1. 
            this goes for all planet names being set accordingly*/
        }

        if (p1 != null && star1 != null) 
        {
            System.out.println("Angular distance:" + getDistance(star1.getRa(), p1.getRa(), star1.getDec(), p1.getDec()));
        } 
        else if (p2 != null && star1 != null) 
        {
            System.out.println("Angular distance:" + getDistance(star1.getRa(), p2.getRa(), star1.getDec(), p2.getDec()));
        } 
        else if (p1 != null && star2 != null)
        {
            System.out.println("Angular distance:" + getDistance(star2.getRa(), p1.getRa(), star2.getDec(), p1.getDec()));
        } 
        else if (p2 != null && star2 != null) 
        {
            System.out.println("Angular distance:" + getDistance(star2.getRa(), p2.getRa(), star2.getDec(), p2.getDec()));
        } 
        else if (star1 != null && star2 != null) 
        {
            System.out.println("Angular distance:" + getDistance(star2.getRa(), p2.getRa(), star2.getDec(), p2.getDec()));
        } 
        else if (p1 != null && p2 != null)
        {
            System.out.println("Angular distance:" + getDistance(p1.getRa(), p2.getRa(), p1.getDec(), p2.getDec()));
        }
            /* these are just the setters and getters for the angular distance.
            example if p2 is not empty and star 2 not empty print angular distance by getting 
            distance, star1 right ascension, declination and p2 right ascension, declination*/

    }
//---------------------------------------------------------------------------------------
    private void angularDistance2(Scanner scanner) 
    {
        Star object1 = null;
        Star object2 = null;
        Planet p1 = null;
        Planet p2 = null;
        //naming instant variables required for the methods
        //Setting Star to object = null and planets p1 and p2  to keep track of different stars and planets
        System.out.print("Enter Object Name: ");
        String name1 = scanner.next();
        if (star1 != null) 
        {
            object1 = star1;
            if (star1.getPlanet1() != null && star1.getPlanet1().getName().equals(name1)) 
            {
                p1 = star1.getPlanet1();
            } 
            else if (star1.getPlanet2() != null && star1.getPlanet2().getName().equals(name1))
            {
                p2 = star1.getPlanet2();
            }   /*if staqr 1 is not empty object 1 is star1. And just declaring if star 1 planets are not empty and return a name 
            they are planets of star 1.*/

        } 
        else if (star2 != null) 
        {
            object2 = star2;
            if (star2.getPlanet1() != null && star2.getPlanet1().getName().equals(name1)) 
            {
                p1 = star2.getPlanet1();
            } 
            else if (star2.getPlanet2() != null && star2.getPlanet2().getName().equals(name1)) 
            {
                p2 = star2.getPlanet2();
                /*if staqr 2 is not empty object 2 is star2. And just declaring if star 1 planets are not empty and return a name 
            they are planets of star 1.*/
            }
        }
        System.out.println("Angular distance:" + getDistance(p1.getRa(), p2.getRa(), p1.getDec(), p2.getDec()));
    }   //print out the anugular distances when the if statements are met using set and get methods in if statements.

    //-----------------------------------------------------------------------------------------
    
}