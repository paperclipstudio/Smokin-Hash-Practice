import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

/**
* Reads a .in file and creates a Arraylist of Rides. It then returns this
* Arraylist.
* @param filename Input filename, if none is given then defaults to Rides.in
* @return ArrayList<Ride> List of rides read from the file.
*/

public class Parse {

  public static ArrayList<Ride> ReadFile() {
    ReadFile("Rides.in");
  }

  public static ArrayList<Ride> ReadFile(String filename) {
    String[] tempArray;
    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      int i = 0;
      ArrayList<Ride> rides = new ArrayList<Ride>();
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        data = data.replaceAll("\\s+","");
        tempArray = data.split("");
        Ride tempRide = new Ride(Integer.parseInt(tempArray[0]), Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2]),Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]));
        rides.add(tempRide);
        System.out.println("the car comes from: " + );
      }
        myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
