import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello world");
		ArrayList<Ride> currentRides = new ArrayList<Ride>();
		try {
			currentRides = Parse.parseRidesFromFile("e_high_bonus.in");
		}
		catch(Exception e) {
			System.out.println("File Reading failed");
		}

		System.out.printf("There are %3d rides", currentRides.size());
	}
}
