
// This file is George
// for him to work on a solution.

import java.util.ArrayList;
//import Parse.parseRidesFromFile;


class George{
  public static void main(String[] args) {
    ArrayList<Ride> rides = new ArrayList<Ride>();
    try {
      rides = Parse.parseRidesFromFile("a_example.in");
    } catch (Exception e) {
      System.out.println("File not found");
    }
    for (int i=0; i<rides.size();i++) {
      System.out.printf("Points: %3d, Distance: %3d\n",
        rides.get(i).getPoints(0),
        rides.get(i).getDistance()
        );
    }
  }
}
