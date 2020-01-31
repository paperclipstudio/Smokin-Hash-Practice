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
    public static void main(String[] args) throws FileNotFoundException {
        String[] tempArray;
        Scanner scanner = new Scanner(new File("e_high_bonus.in"));
        int i = 0;
        ArrayList<Ride> rides = new ArrayList<Ride>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            data = data.replaceAll("\\s+","");
            Ride tempRide = new Ride(data.charAt(0), data.charAt(1), data.charAt(2),data.charAt(3), data.charAt(4), data.charAt(5));
            rides.add(tempRide);

            //simple test:
            System.out.println("The car comes from horizontal street " + tempRide.getStartPos().getHorizontalStreet() + ", vertical street " + tempRide.getStartPos().getVerticalStreet() );
        }
        scanner.close();
    }
}
