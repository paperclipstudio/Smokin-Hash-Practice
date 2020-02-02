
// This file is George
// for him to work on a solution.

import java.util.ArrayList;
import java.io.IOException;

class George{

  public static void main(String[] args) {

    // Parsing File
    ArrayList<Ride> rides = new ArrayList<Ride>();
    try {
      rides = Parse.parseRidesFromFile("a_example.in");
    } catch (Exception e) {
      System.out.println("File not found");
    }


    Routes currentRoute = new Routes();
    // Packing Routes
    for (int i=0; i<rides.size();i++) {
      System.out.println(rides.get(0));
      currentRoute.addRide(rides.get(i));
      System.out.printf("Points: %3d, Distance: %3d\n",
        rides.get(i).getPoints(0),
        rides.get(i).getDistance()
        );
    }

    Routes[] solution = new Routes[2];

    solution[0] = currentRoute;
    solution[1] = new Routes();
    // Output Parsing

    System.out.print(Parse.parseRoutesToString(currentRoute));
    try{
      Parse.parseRoutesToFile(solution, "GeorgeOut.out");
    } catch(IOException e) {
      System.out.print("failed");
    }
  }
}
