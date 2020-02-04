import java.io.File; // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Reads a .in file and creates a Arraylist of Rides. It then returns this
 * Arraylist.
 * @author Yan Yan Ji, Gus
 *
 * @version 2
 *
 *
 * @param filename Input filename, if none is given then defaults to Rides.in
 * @return ArrayList<Ride> List of rides read from the file.
 *
 */

public class Parse {
    public static ArrayList<Ride> parseRidesFromFile(String filename) throws FileNotFoundException {
      Scanner scanner = new Scanner(new File(filename));
      ArrayList<Ride> rides = new ArrayList<Ride>();
      // Reading the first line that holds Map information
      // Which is in the format
      // rows, column, number of cars, number of rides, bonus, max time
	    String Firstline = scanner.nextLine();
      String[] setupData = Firstline.split(" ");
      Ride.setRideBonusPoints(Integer.parseInt(setupData[4]));
      Ride.setNumberOfCars(Integer.parseInt(setupData[2]));

      int rideID = 0; // RideID is a unique id that remebers which route came when.
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        String tempArray[] = data.split(" ");
			  Ride tempRide = new Ride(Integer.parseInt(tempArray[0]),
        Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2]),
				Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]),
				Integer.parseInt(tempArray[5]), rideID);
        rides.add(tempRide);
        rideID++;

            //simple test:
            //System.out.println("The car comes from horizontal street " + tempRide.getStartPos().h() + ", vertical street " + tempRide.getStartPos().v() );
        }
        scanner.close();
		return rides;
    }

	// Function to return the integer value of a charater in a string
	private static int getIntAt(String lineToParse, int index) {
		return Character.getNumericValue(lineToParse.charAt(index));
	}


  public static String parseRoutesToString(Routes inputRoute) {
    String outputString = "";
    outputString += inputRoute.getNumberOfRides();
    for (int currentRideID: inputRoute.getRideIDs()) {
      outputString += " " + currentRideID;
    }
    return outputString;
  }

  public static String  parseManyRoutesToString(Routes[] inputRoutes) {
    String currentString = "";
    for (Routes currentRoute: inputRoutes) {
      currentString += parseRoutesToString(currentRoute);
      currentString += "\n";
    }
    return currentString;
  }

  public static void parseRoutesToFile (
  Routes[] inputRoutes,
  String outputFile) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
    writer.write(parseManyRoutesToString(inputRoutes));
    writer.close();
  }

}
