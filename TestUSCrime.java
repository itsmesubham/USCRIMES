/**
 * File: TestUSCrime.java
 * Author: Tuano, Antonio T.
 * Date: 08MAR19
 * Purpose: This program reads U.S. Crime Statistics file and display various data options
 */

// Import Utilities
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class TestUSCrime {
    static Scanner input = new Scanner(System.in);
    static Scanner inputyear = new Scanner(System.in);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private static DecimalFormat df3 = new DecimalFormat("###,###");
    public static void main(String[] args) {

	//Check for file argument
	if (args.length == 0)  {
	    System.out.println("\nError: You must enter a file name argument at program startup,");
	    System.out.println("e.g. C:>java TestCrime Crime.csv");
            System.out.println("\nPlease re-run the application with a file name argument.");
	    System.exit(0);
	}

	// Reference USCrimeFile
	USCrime[] data = USCrimeFile.read(args[0]);

	// Declare Variables
	long startTime = System.currentTimeMillis();
	long endTime;
	String choice;
	String userSelect;
	int yearinput;

	// Program Intro
        System.out.println("\n");
        System.out.println("****************************");
        System.out.println("*    U.S. Crime Stastics    *");
        System.out.println("****************************");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Local Computer Date/Time: " + dtf.format(now));
	System.out.println();
	System.out.println();
	System.out.println("This Java application will provide the user access");
	System.out.println("to various U.S. Crime statistics compiled from 1994 to 2013");
	System.out.println("by the Federal Bureau of Investigation.\n\n");	

	// Get USCrimeMenu Class
	while (true)  {
	    System.out.print(USCrimeMenu.getUSCrimeMenu());
            userSelect = input.nextLine();
	    System.out.println();
	    switch (userSelect)  {
		case "1":
		    USCrimeMethods.disPopPct(data);
		    break;

		case "2":
		    System.out.println("The highest Murder rate was " + USCrimeMethods.maxMurRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.maxMurRteYr(data) + ".");
		    break;

		case "3":
		    System.out.println("The lowest Murder rate was " + USCrimeMethods.minMurRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.minMurRteYr(data) + ".");
		    break;

		case "4":
		    System.out.println("The highest Robbery rate was " + USCrimeMethods.maxRobRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.maxRobRteYr(data) + ".");
		    break;

		case "5":
		    System.out.println("The lowest Robbery rate was " + USCrimeMethods.minRobRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.minRobRteYr(data) + ".");
		    break;

		case "6":
		    System.out.println("The lowest Burglary rate was " + USCrimeMethods.minBurRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.minBurRteYr(data) + ".");
		    System.out.println("The highest Burglary rate was " + USCrimeMethods.maxBurRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.maxBurRteYr(data) + ".");
		    break;

		case "7":
		    System.out.println("The lowest Rape rate was " + USCrimeMethods.minRapRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.minRapRteYr(data) + ".");
		    System.out.println("The highest Rape rate was " + USCrimeMethods.maxRapRte(data) + " per 100,000 inhabitants in the year " + USCrimeMethods.maxRapRteYr(data) + ".");
		    break;

		case "8":
		    System.out.print("Enter year between 1994 and 2013: ");
		    yearinput = inputyear.nextInt();
		    System.out.println();
		    if (yearinput < 1994 || yearinput > 2013) {
			do {
			    System.out.println("Error: Year must between 1994 and 2013 inclusive.");
	        	    System.out.print("Please try again : ");
                   	    yearinput = inputyear.nextInt();
            		} 
	    		while (yearinput < 1994 || yearinput > 2013);
		    }
            for (USCrime data1 : data) {
                if (yearinput == data1.getYear()) {
                    System.out.println("\nThe U.S. population in " + data1.getYear() + " was " + df3.format(data1.getPopulation()) + " inhabitants.");
                }		    
            }
		    break;

		case "Q":
		    endTime = System.currentTimeMillis();
	            System.out.println("\nThe elapsed time using this application was " + (endTime - startTime) / 1000 + " seconds.");
		    System.out.println("\nThank you for trying the US Crimes Statistics application.");
		    System.exit(0);

		default:
		    System.out.println("Error: Invalid selection! Please Try again.\n");
		    break;
	    }
	}
    }
}
