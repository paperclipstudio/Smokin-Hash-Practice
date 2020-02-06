

/**
* Class is for the testing of Georges Solutions
* Uncomment different lines for different files
* @author Smokin'Hash
*/

import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;

class George{
  public static void main(String[] args) {
    ////
    //// Parsing File
    ////
    ArrayList<Ride> rides = new ArrayList<Ride>();
    try {
      //rides = Parse.parseRidesFromFile("a_example.in");
      //rides = Parse.parseRidesFromFile("b_should_be_easy.in");
      //rides = Parse.parseRidesFromFile("c_no_hurry.in");
      //rides = Parse.parseRidesFromFile("d_metropolis.in");
      rides = Parse.parseRidesFromFile("e_high_bonus.in");

    } catch (Exception e) {
      System.out.println("File not found");
    }

    ////
    //// Packing Routes
    ////

    // Put each Ride into Unique Routes
    // solution holds all routes.
    ArrayList<Routes> solution = new ArrayList<Routes>();
    for (Ride currentRide: rides) {
      Routes tempRoute = new Routes();
      tempRoute.addRide(currentRide);
      solution.add(tempRoute);
    }

    // Sort Routes by starting time.
    Collections.sort(solution, new SortByStart());
    //Collections.sort(solution, new SortByDistance());
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
    // Finds out the differents between the ending of one route and the starting
    // of another, if this difference is less than the acceptableDiff then they
    // get joinned together
    final int LARGE_NUMBER = 999999;
    // Stores the smallestDifference between routes.
    int smallestDiff = LARGE_NUMBER;
    int secondSmallestDiff = LARGE_NUMBER;
    // The difference that we would allow a joining.
    int acceptableDiff = 0;

    while(solution.size() > Ride.getNumberOfCars() ) {
      System.out.println("A Current Size: " + solution.size() +
      " Number of Cars: " + Ride.getNumberOfCars() +
      " acceptDiff: " + acceptableDiff +
      " smallDiff: " + smallestDiff);

      smallestDiff = LARGE_NUMBER;
      secondSmallestDiff = LARGE_NUMBER;
      // for each (i) and all later routes (j)
      for(int i = 0;i < solution.size(); i++){
        for(int j = 0; j < solution.size(); j++) {

        }
      }
      //Collections.sort(solution, new SortByStart());
      acceptableDiff = secondSmallestDiff;
    }
    // loop untill X number remains

    //// Output Parsing

    Routes[] finalSolution = solution.toArray(new Routes[solution.size()]);
    int points = 0;
    for (Routes input: finalSolution) {
      points += input.getPoints(0);
    }
    System.out.println("points: " + points);
    try{
      Parse.parseRoutesToFile(finalSolution, "GeorgeOut.out");
    } catch(IOException e) {
      System.out.print("failed");
    }
  }
}
