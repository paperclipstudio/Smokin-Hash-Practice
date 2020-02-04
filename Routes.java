import java.util.ArrayList;
import java.io.BufferedWriter;
import java.util.Comparator;

/**
* Used to model many rides together as one object
* @version 1
* @author Smokin Hash
*/

public class Routes {
  private Intersection startPos;
  private Intersection finishPos;
  private ArrayList<Ride> rides;
  private int distance;

/**
* Constuctor takes no args
*/
  Routes() {
    rides = new ArrayList<Ride>();
  }
/**
* Used to add a ride to the end of the Route
* Distance is updated at this points
* @param input The ride to be added
*/
  public void addRide(Ride input) {
    rides.add(input);

    int currentDistance = 0;
    Intersection currentPos = rides.get(0).getStartPos();
    for (Ride currentRide: rides) {
      currentDistance += Intersection.getDistance(currentPos, currentRide.getStartPos());
      currentDistance += Intersection.getDistance(currentRide.getStartPos(), currentRide.getFinishPos());
      currentPos = currentRide.getFinishPos();
    }
    this.distance = currentDistance;
  }

  public int getEarliest() {
        return rides.get(0).getEarliest();
    }

    /**
    * Gives the Ealiest that a route could finish
    * such that the earliest that a route could finishHorizontal
    * @return Earliest + totalDistance + time to get to startPos
    */
    public int getBestCaseLatest() {
      return getEarliest()
        + getDistance() 
        + Intersection.getDistance(new Intersection(0,0), getStartPos());
    }

    public int getLatest() {
        return rides.get(rides.size() - 1).getLatest();
    }

    public ArrayList<Ride> getRides() {
      return rides;
    }

    public Intersection getStartPos() {
        return rides.get(0).getStartPos();
    }

    public Intersection getFinishPos() {
        return rides.get(rides.size()-1).getFinishPos();
    }


   /**
   * Returns the number of points that a Route would get.
   * @param startTime Time that the Route would start.
   * @return The amount of points a Route would get if it would start
   * at the given start time.
   */
   public int getPoints(int startTime){
       int points = 0;
       int currentTime = startTime;
       Intersection currentPos = new Intersection(0,0);

       for (Ride currentRide: rides) {
         currentTime += Intersection.getDistance(currentPos, currentRide.getStartPos());
         if (currentTime < currentRide.getEarliest()) {
           currentTime = currentRide.getEarliest();
         }
         points += currentRide.getPoints(currentTime);
         currentTime += currentRide.getDistance();
         currentPos = currentRide.getFinishPos();
       }
       return points;
   }

   /**
   * @returns the Distance of a route
   */
   public int getDistance() {
     return this.distance;
   }
   /**
   * Returns the RideIDs of this routes
   */
   public int[] getRideIDs() {
     int[] rideIDlist = new int[rides.size()];
     for(int i = 0; i < rides.size();i++) {
       rideIDlist[i] = rides.get(i).getRideID();
     }
     return rideIDlist;
   }

   /**
   * @return The number of rides a route holds
   */
   public int getNumberOfRides() {
     return rides.size();
   }

   /**
   * Places the input route onto the end of this route
   * @param input the route to append to this routes
   */
   public boolean joinRoutes(Routes input) {
     if (this.getEarliest() + this.getDistance() < input.getLatest()){
       for (Ride currentRide: input.getRides()) {
         this.addRide(currentRide);
       }
       return true;
     } else {
       System.out.println("joinRoutes() Failed Second Routes is too early");
       return false;
     }
   }

   /**
   * @param a Starting Routes
   * @param b Ending Routes
   * @return The Distance from the end of route a to the beginning of route break;
   *   which includes the time to get between the two.
   */
   public static int spaceTimeDiff(Routes a, Routes b) {
     int diff = Intersection.getDistance(a.getFinishPos(), b.getStartPos());
     diff += b.getEarliest() - a.getBestCaseLatest();
     // Check to see if a ends after the b starts
     if (a.getBestCaseLatest() > b.getEarliest()) {
       diff += 900000;
     }
     //System.out.println("Difference: " + diff);

     return diff;
   }
}

class SortByDistance implements Comparator<Routes>{
  public int compare(Routes a, Routes b){
    return a.getDistance() - b.getDistance();
    //return b.getDistance() - a.getDistance();
  }
}

class SortByStart implements Comparator<Routes>{
  public int compare(Routes a, Routes b){
    if(a.getEarliest() == b.getEarliest()) {
      return 0;
    } else if(a.getEarliest() > b.getEarliest()){
      return 1;
    } else {
      return -1;
    }
  }
}
