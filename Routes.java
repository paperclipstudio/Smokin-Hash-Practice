import java.util.ArrayList;
import java.io.BufferedWriter;
import java.util.Comparator;

public class Routes {
  private Intersection startPos;
  private Intersection finishPos;
  private ArrayList<Ride> rides;
  private int distance;


  Routes() {
    rides = new ArrayList<Ride>();
  }

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
   *
   * @return The Distance from the end of route a to the beginning of route break;
   *   which includes the time to get between the two.
   */
   public static int spaceTimeDiff(Routes a, Routes b) {
     int badness = 0;
     int spaceDiff = Intersection.getDistance(a.getFinishPos(), b.getStartPos());
     badness += spaceDiff;
     int timeDiff = (b.getEarliest() - a.getBestCaseLatest());
     if(timeDiff >= 0) {
       badness += timeDiff;
     } else {
     // Check to see if a ends after the b starts     
       badness += 9000000;
     }
     //System.out.println("Difference: " + diff);
     return badness;
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
    return a.getEarliest() - b.getEarliest();
  }
}
