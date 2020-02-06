

/**
* Class is for the testing of PointsPer Ride Solutions
* Uncomment different lines for different files
* @author Smokin'Hash
*/

import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;

class pointPerCar{

  public static double pointsPerCar(ArrayList<Routes> input) {
    int points = getArrayListPoints(input);
    return points / (double) input.size();
  }

  public static int getArrayListPoints(ArrayList<Routes> inputArrayList) {
    int points = 0;
    for (Routes input: inputArrayList) {
      points += input.getPoints(0);
    }
    return points;
  }

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
    final int LARGE_NUMBER = 999999999;
    // Stores the smallestDifference between routes.
    int smallestDiff = LARGE_NUMBER;
    int secondSmallestDiff = LARGE_NUMBER;
    // The difference that we would allow a joining.
    int acceptableDiff = -100;

    while(solution.size() > Ride.getNumberOfCars() ) {
      System.out.printf("Size: %4d  # of Cars:  %3d " +
      "Diff: %4d  pointsPerCar: %4.4f\n",
      solution.size(),
      Ride.getNumberOfCars(),
      acceptableDiff,
      pointsPerCar(solution));

      smallestDiff = LARGE_NUMBER - 2;
      secondSmallestDiff = LARGE_NUMBER;

      int maxPoints = 0;
      int[] bestIJ = {0, 1};
      // for each (i) and all later routes (j)
      for(int i = 0;i < 350; i++){
        for(int j = 0; j < solution.size(); j++) {
          if (i != j) {
            // Find the difference between route i and route j

            Routes routeIJ = Routes.joinRoutes(solution.get(i), solution.get(j));
            int pointsI = solution.get(i).getPointsPerTime();
            int pointsJ = solution.get(j).getPointsPerTime();
            int pointsIJ = routeIJ.getPointsPerTime();
            int pointGain = pointsIJ - (pointsI + pointsJ)/2;

            //if (pointsI > 0){System.out.println(pointGain);};
            if (pointGain > maxPoints) {
              maxPoints = pointGain;
              bestIJ[0] = i;
              bestIJ[1] = j;
              //System.out.printf("New best: i %3d, j %3d, pointsGain: %5d\n",
              //i, j, pointGain);
            }
          }
        }
      }
      System.out.printf("joining %3d with %3d\n", bestIJ[0], bestIJ[1]);
      solution.get(bestIJ[0]).joinRoutes(solution.get(bestIJ[1]));
      solution.remove(bestIJ[1]);
      //Collections.sort(solution, new SortByStart());
    }
    // loop untill X number remains

    //// Output Parsing

    Routes[] finalSolution = solution.toArray(new Routes[solution.size()]);
    System.out.printf("points: %,3d\n", getArrayListPoints(solution));
    try{
      Parse.parseRoutesToFile(finalSolution, "GeorgeOut.out");
    } catch(IOException e) {
      System.out.print("failed");
    }
  }
}
