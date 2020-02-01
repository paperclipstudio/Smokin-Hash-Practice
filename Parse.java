import java.io.File; // Import the File class

import java.util.Scanner; // Import the Scanner class to read text files

import java.io.FileNotFoundException;

import java.util.ArrayList;

/**

 * Reads a .in file and creates a Arraylist of Rides. It then returns this

 * Arraylist.

 * @author Yan Yan Ji, Gus
 * 
 * @version 2
 * 
 * @

 * @param filename Input filename, if none is given then defaults to Rides.in

 * @return ArrayList<Ride> List of rides read from the file.
 * 

 */

public class Parse {

	public static void main(String[] args) throws FileNotFoundException {

		String[] tempArray;

		Scanner scanner = new Scanner(new File("C:\\Users\\yanya\\eclipse-workspace\\Parse\\src\\e_high_bonus.in"));

		// int i = 0;

		ArrayList<Ride> rides = new ArrayList<Ride>();

		while (scanner.hasNextLine()) {

			String data = scanner.nextLine();

			String data1[] = data.split(" ");
			int data2[] = new int[6];

			for (int i = 0; i < 5; i++) {
				data2[i] = Integer.parseInt(data1[i]);
			}

			Ride tempRide = new Ride(data2[0], data2[1], data2[2], data2[3], data2[4], data2[5]);

			rides.add(tempRide);

			// simple test:

			System.out.println("The car comes from horizontal street " + tempRide.getStartPos().getHorizontalStreet()
					+ ", vertical street " + tempRide.getStartPos().getVerticalStreet());

		}

		scanner.close();

	}

}