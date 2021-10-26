
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interface {

    private Star[] stars = null;
    private Planet[] planets = null;
    private int totalStars;
    private int totalPlanets;

    // N and M should be integer constants that a programmer can easily change
    // (2 and 2 can be used as default values).
    public static int N = 2;    // stars
    public static int M = 2;    // planets

    public Interface() {
        stars = new Star[N];
        planets = new Planet[M];
        totalStars = 0;
        totalPlanets = 0;
    }

    public Star[] getStars() {
        return stars;
    }

    public void setstars(Star[] s) {
        this.stars = s;
    }

    public boolean checkForStar(String star) {
        if (stars != null) {
            for (int i = 0; i < totalStars; i++) {
                if (stars[i].getName().trim().equals(star)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteStar(Scanner scanner) {

        System.out.print("Enter Star Name: ");
        String name = scanner.nextLine();

        int index = -1;

        if (stars != null) {
            for (int i = 0; i < totalStars; i++) {
                if (stars[i].getName().trim().equals(name)) {
                    index = i;
                    break;
                }
            }
        }

        // if star found, remove it
        if (index != -1) {
            // if not last index
            if (index != totalStars - 1) {
                for (int i = index; i < totalStars - 1; i++) {
                    stars[i] = stars[i + 1];
                }
            }
            totalStars -= 1;
        } else {
            System.out.println("Invalid Star.");
        }
    }

    public Planet[] getPlanets() {
        return planets;
    }

    public boolean checkForPlanet(String planet) {
        if (planets != null) {
            for (int i = 0; i < totalPlanets; i++) {
                if (planets[i].getName().trim().equals(planet)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setPlanets(Planet[] p) {
        this.planets = p;
    }

    public void deletePlanet(Scanner scanner) {

        System.out.print("Enter Planet Name: ");
        String name = scanner.nextLine();

        int index = -1;

        if (planets != null) {
            for (int i = 0; i < totalPlanets; i++) {
                if (planets[i].getName().trim().equals(name)) {
                    index = i;
                    break;
                }
            }
        }

        // if planet found, remove it
        if (index != -1) {
            // if not last index
            if (index != totalPlanets - 1) {
                for (int i = index; i < totalPlanets - 1; i++) {
                    planets[i] = planets[i + 1];
                }
            }
            totalPlanets -= 1;
        } else {
            System.out.println("Invalid Planet.");
        }
    }

    public static void main(String[] args) {
        Interface infFace = new Interface();
        infFace.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
        scanner.close();
    }

    //math for angular distance
    public double getDistance(double a1, double a2, double d1, double d2) {
        return Math.acos((Math.cos(a1 - a2) * Math.cos(Math.toRadians(d1)) * Math.cos(Math.toRadians(d1))
                + Math.sin(Math.toRadians(d1)) * Math.sin(Math.toRadians(d2))));
    }

    //adding a star console commands
    private void addStar(Scanner scanner) {
        String name, sType;
        double ra, dec;
        System.out.println("Enter Star Name: ");
        name = scanner.nextLine();
        System.out.println("Enter Right Ascension: ");
        ra = scanner.nextDouble();
        System.out.println("Enter Declination: ");
        dec = scanner.nextDouble();
        System.out.println("Enter Spectral type: ");
        sType = scanner.nextLine();

        //please check to make sure the star already exists
        if (checkForStar(name)) {
            System.out.println("Star already exists!");
        } else if (totalStars == N) {
            System.out.println("Cannot add more stars.");
        } else {
            stars[totalStars] = new Star(name, ra, dec, sType);
            totalStars += 1;
            System.out.println("Star added successfully");
        }
    }

    //adding a planet console command
    private void addPlanet(Scanner scanner) {

        System.out.print("Enter Planet Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Right Ascension: ");
        double ra = scanner.nextDouble();
        System.out.print("Enter Declination: ");
        double dec = scanner.nextDouble();

        //please check if the planet already exists
        if (checkForPlanet(name)) {
            System.out.println("Planet already exists!");
        } else if (totalPlanets == M) {
            System.out.println("Cannot add more panets.");
        } else {

            // check if it orbits any star
            Star star = null;
            System.out.println("");
            for (int i = 0; i < totalStars; i++) {
                System.out.println((i + 1) + ". " + stars[i].getName());
            }
            System.out.print("Enter star no. to select orbit or 0 for none: ");
            int starNum = scanner.nextInt();

            if (starNum > 0 && starNum <= totalStars) {
                star = stars[starNum - 1];
            }

            planets[totalPlanets] = new Planet(name, ra, dec, "", star);
            totalPlanets += 1;
            System.out.println("Planet added successfully");
        }
    }

    //Printing a list of objects
    private void printObjects() {

        if (totalPlanets == 0 && totalStars == 0) {
            System.out.println("No astronomical objects exist ");
            return;
        }

        for (int i = 0; i < totalStars; i++) {
            Star star = stars[i];
            System.out.println("Star: <" + star.getName() + "> coordinate <" + star.getRa() + "> <" + star.getDec()
                    + ">, spectral type <" + star.getsType() + ">");
        }

        for (int i = 0; i < totalPlanets; i++) {
            Planet planet = planets[i];
            System.out.println("Planet: <" + planet.getName() + "> coordinate <" + planet.getRa() + "> <" + planet.getDec() + ">");
        }

    }

    //list of orbiting objects
    private void printsOrbitStar(Scanner scanner) {
        boolean found = false;
        System.out.print("Enter Planet Name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < totalPlanets; i++) {
            if (planets[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Star: " + planets[i].getOrbits().getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Planet does not exist");
        }
    }

    //finding angular distance
    private void angularDistance(Scanner scanner) {
        Star star = null;
        Planet planet = null;

        System.out.print("Enter Star Name: ");
        String name = scanner.nextLine();
        if (!checkForStar(name)) {
            System.out.println("star does not exist");
            return;
        }
        for (int i = 0; i < totalStars; i++) {
            if (stars[i].getName().trim().equals(name)) {
                star = stars[i];
                break;
            }
        }

        System.out.print("Enter Planet Name: ");
        name = scanner.nextLine();
        if (!checkForPlanet(name)) {
            System.out.println("Planet does not exist");
            return;
        }
        for (int i = 0; i < totalPlanets; i++) {
            if (planets[i].getName().trim().equals(name)) {
                planet = planets[i];
                break;
            }
        }

        double dist = getDistance(star.getRa(), star.getDec(), planet.getRa(), planet.getDec());
        System.out.println("Angular Distance: " + dist);
    }

    private void angularDistance2(Scanner scanner) {
        Star star = null;
        Planet planet = null;

        System.out.print("Enter Star Name: ");
        String name = scanner.nextLine();
        if (!checkForStar(name)) {
            System.out.println("star does not exist");
            return;
        }
        for (int i = 0; i < totalStars; i++) {
            if (stars[i].getName().trim().equals(name)) {
                star = stars[i];
                break;
            }
        }

        System.out.print("Enter Planet Name: ");
        name = scanner.nextLine();
        if (!checkForPlanet(name)) {
            System.out.println("Planet does not exist");
            return;
        }
        for (int i = 0; i < totalPlanets; i++) {
            if (planets[i].getName().trim().equals(name)) {
                planet = planets[i];
                break;
            }
        }

        double dist = getDistance(star.getRa(), star.getDec(), planet.getRa(), planet.getDec());
        System.out.println("Angular Distance: " + dist);
    }

    private void mainMenu(Scanner scanner) {
        do {
            System.out.println("1. Add a star");
            System.out.println("2. Add a planet");
            System.out.println("3. Delete a star");
            System.out.println("4. Delete a planet");
            System.out.println("5. List of objects");
            System.out.println("6. List of planets that orbit a star");
            System.out.println("7. Angular distance between 2 objects.");
            System.out.println("8. List of objects within an angular distance of a specified object.");
            System.out.println("9. Import Planet and Star information from file.");
            System.out.println("10. Export Planet and Star information to file.");
            System.out.println("11. Exit.");

            System.out.print("Enter an option: ");
            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
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

                    case 11:
                        System.out.println("Bye");
                        System.exit(0);
                        break;
                    /*
				 * I have used (scanner) in the switch to link that particular switch to its
				 * required code
                     */
                    default:
                        break;
                }
            } catch (Exception ex) {

            }
        } while (true);

    }

    private void importInformation(Scanner scanner) {
        String fileName, starOrPlanet, name, sType, line;
        String[] parts;
        double ra, dec;
        System.out.print("Enter the name of file to import: ");
        fileName = scanner.nextLine();

        resetPlanetAndStars();

        // create file scanner to read the file
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new File(fileName));

            // read file
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                parts = line.split(" ");
                starOrPlanet = parts[0];
                name = parts[1];
                ra = Double.parseDouble(parts[2]);
                dec = Double.parseDouble(parts[3]);
                sType = parts[4];
                if (starOrPlanet.equalsIgnoreCase("PLANET")) {
                    //please check if the planet already exists
                    if (checkForPlanet(name)) {
                        System.out.println("Planet already exists!");
                    } else if (totalPlanets == M) {
                        System.out.println("Cannot add more panets.");
                    } else {
                        planets[totalPlanets] = new Planet(name, ra, dec, sType, null);
                        totalPlanets += 1;
                        System.out.println("Planet added successfully");
                    }
                } else if (starOrPlanet.equalsIgnoreCase("STAR")) {
                    //please check to make sure the star already exists
                    if (checkForStar(name)) {
                        System.out.println("Star already exists!");
                    } else if (totalStars == N) {
                        System.out.println("Cannot add more stars.");
                    } else {
                        stars[totalStars] = new Star(name, ra, dec, sType);
                        totalStars += 1;
                        System.out.println("Star added successfully");
                    }
                } else {
                    System.out.println("Invalid Object: " + starOrPlanet);
                }
            }
            System.out.println("\nPlant and Star information imported successfully.\n");

            fileScanner.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error occurred while reading from file.");
        }
    }

    private void exportInformation(Scanner scanner) {
        String fileName;
        System.out.print("Enter the name of export file: ");
        fileName = scanner.nextLine();

        try {
            PrintStream  outStream = new PrintStream(new File(fileName));

            if (totalPlanets == 0 && totalStars == 0) {
                System.out.println("No astronomical objects exist ");
                return;
            }

            for (int i = 0; i < totalStars; i++) {
                Star star = stars[i];
                outStream.println("STAR " + star.getName() + " " + star.getRa() + " " + star.getDec()
                        + " " + star.getsType());
            }

            for (int i = 0; i < totalPlanets; i++) {
                Planet planet = planets[i];
                outStream.println("PLANET " + planet.getName() + " " + planet.getRa() + " " + planet.getDec());
            }

            outStream.close();
            
             System.out.println("\nPlant and Star information exported successfully.\n");
        } catch (IOException ex) {
            System.out.println("Error occured while exporting.");
        }
    }

    private void resetPlanetAndStars() {
        for (int i = 0; i < totalPlanets; i++) {
            planets[i] = null;
        }
        totalPlanets = 0;

        for (int i = 0; i < totalStars; i++) {
            stars[i] = null;
        }
        totalStars = 0;
    }
}
