
// This file is George
// for him to work on a solution.

import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;


class George{

  public static void main(String[] args) {
    System.out.println("boop");
    //// Parsing File
    ArrayList<Ride> rides = new ArrayList<Ride>();
    try {
      //rides = Parse.parseRidesFromFile("a_example.in");
      //rides = Parse.parseRidesFromFile("b_should_be_easy.in");
      //rides = Parse.parseRidesFromFile("c_no_hurry.in");
      rides = Parse.parseRidesFromFile("d_metropolis.in");
      //rides = Parse.parseRidesFromFile("a_example.in");
      //rides = Parse.parseRidesFromFile("a_example.in");
      //rides = Parse.parseRidesFromFile("a_example.in");

    } catch (Exception e) {
      System.out.println("File not found");
    }

    Routes currentRoute = new Routes();

    //// Packing Routes

    // Put each Ride into Unique Routes
    ArrayList<Routes> solution = new ArrayList<Routes>();
    for (Ride currentRide: rides) {
      Routes tempRoute = new Routes();
      tempRoute.addRide(currentRide);
      solution.add(tempRoute);
    }

    // Sort Routes by starting time.
    Collections.sort(solution, new SortByStart());
    System.out.print("Solutions are sorted");
/*
    for (int i=0; i<solution.size(); i++) {
      System.out.printf("task: %3d Time: %4d From: [%3d,%3d] To: [%3d,%3d]\n",
        solution.get(i).getRideIDs()[0],
        solution.get(i).getEarliest(),
        solution.get(i).getStartPos().v(),
        solution.get(i).getStartPos().h(),
        solution.get(i). getFinishPos().v(),
        solution.get(i).getFinishPos().h());
    }*/

    // Join route together
    // Stores the smallestDifference between routes.
    int smallestDiff = 999999999;
    // The difference that we would allow a joining.
    int acceptableDiff = 0;

    while(solution.size() > Ride.getNumberOfCars() ) {


      System.out.println("A Current Size: " + solution.size() +
      " Number of Cars: " + Ride.getNumberOfCars() +
      " acceptableDiff: " + acceptableDiff +
      " smallestDiff: " + smallestDiff);
      for(int i = 0;i < solution.size(); i++){
        //System.out.println("i: " + i);
        for(int j = i+1; j < solution.size(); j++) {
          int currentDiff = Routes.spaceTimeDiff(solution.get(i), solution.get(j));
          if (currentDiff < smallestDiff) {
            smallestDiff = currentDiff;
          }
          if (acceptableDiff >= currentDiff) {
            // System.out.print("joining\n");
            solution.get(i).joinRoutes(solution.get(j));
            solution.remove(j);
          }
        }
      }
      acceptableDiff += smallestDiff/5;
    }
    // loop untill X number remains

    //// Output Parsing
    System.out.println("points: " + solution.get(0).getPoints(0));
    Routes[] finalSolution = solution.toArray(new Routes[solution.size()]);
    try{
      Parse.parseRoutesToFile(finalSolution, "GeorgeOut.out");
    } catch(IOException e) {
      System.out.print("failed");
    }
  }
}
