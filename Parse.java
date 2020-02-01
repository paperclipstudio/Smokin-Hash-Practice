import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Reads a .in file and creates a Arraylist of Rides. It then returns this
 * Arraylist.
 * @author Gus
 * @param filename Input filename, if none is given then defaults to Rides.in
 * @return ArrayList<Ride> List of rides read from the file.
 */

public class Parse {
    public static ArrayList<Ride> parseRidesFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        ArrayList<Ride> rides = new ArrayList<Ride>();
       // Reading the first line that holds Map information
	   // Which is in the format
	   // rows, column, number of cars, number of rides, bonus, max time
	    String Firstline = scanner.nextLine();

		int rideID = 0; // RideID is a unique id that remebers which route came when.
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            data = data.replaceAll("\\s+","");
            Ride tempRide = new Ride(
					getIntAt(data,0), 
					getIntAt(data,1),
					getIntAt(data,2), 
					getIntAt(data,3), 
					getIntAt(data,4),
					getIntAt(data,5),
					rideID);
            rides.add(tempRide);

            //simple test:
            //System.out.println("The car comes from horizontal street " + tempRide.getStartPos().getHorizontalStreet() + ", vertical street " + tempRide.getStartPos().getVerticalStreet() );
        }
        scanner.close();
		return rides;
    }

	// Function to return the integer value of a charater in a string
	private static int getIntAt(String lineToParse, int index) {
		return Character.getNumericValue(lineToParse.charAt(index));
	}
}
