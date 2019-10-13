//Contact for assingment shubham7120k@gmail.com

// Import Utilities
import java.util.Scanner;
import java.io.*;

public class USCrimeFile {
    public static USCrime[] read(String filename) {
	
	// Array Declaration
	USCrime[] stats = new USCrime[20];

	// Variable Declaration
	int count = 0;
	String line;

	// Read File
	try {
    	    Scanner inputReader;
            inputReader = new Scanner(new File(filename));
    	    inputReader.nextLine();
	    while (inputReader.hasNext()) {
		line = inputReader.nextLine();
		String[] data = line.split(",");
		stats[count] = new USCrime(Integer.parseInt(data[0]));		// US Crime Year from file
		stats[count].setPopulation(Integer.parseInt(data[1]));		// US Population from file
		stats[count].setMurderRate(Float.parseFloat(data[5]));		// US Crime Murder Rate from file
		stats[count].setRobberyRate(Float.parseFloat(data[9]));		// US Crime Robbery Rate from file
		stats[count].setBurglaryRate(Float.parseFloat(data[15]));	// US Crime Burglary Rate from file
		stats[count].setRapeRate(Float.parseFloat(data[7]));		// US Crime Rape Rate from file
		count++;
	    } 
	    inputReader.close();
	} 
	catch (FileNotFoundException e) {
	    System.out.println();
	    System.out.println(e);
	    System.out.println("\n1. Please ensure the file name is correct.");
	    System.out.println("2. Please ensure the file resides in the same location as the java application.");
	    System.out.println("3. Please re-run application.");
	    System.exit(0);
	}
	return stats;
    }
}
