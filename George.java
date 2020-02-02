
// This file is George
// for him to work on a solution.

import java.util.ArrayList;
import java.io.IOException;

class George{

  public static void main(String[] args) {

    //// Parsing File
    ArrayList<Ride> rides = new ArrayList<Ride>();
    try {
      rides = Parse.parseRidesFromFile("a_example.in");
    } catch (Exception e) {
      System.out.println("File not found");
    }
    Routes currentRoute = new Routes();


    //// Packing Routes

    // Put each Ride into Unique Routes
    Routes[] solution = new Routes[2];
    solution[0] = currentRoute;
    solution[1] = new Routes();

    // Join route together

    // loop untill X number remains
    for (int i=0; i<rides.size();i++) {
      currentRoute.addRide(rides.get(i));
    }

    //// Output Parsing
    try{
      Parse.parseRoutesToFile(solution, "GeorgeOut.out");
    } catch(IOException e) {
      System.out.print("failed");
    }
  }
}
