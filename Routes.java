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
  }

  public int getEarliest() {
        return rides.get(0).getEarliest();
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
        return rides.get(0).getFinishPos();
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
       Intersection currentPos = rides.get(0).getStartPos();

       for (Ride currentRide: rides) {
         currentTime += Intersection.getDistance(currentPos, currentRide.getStartPos());
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
     return distance;
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
     }
     System.out.println("joinRoutes() Failed Second Routes is too early");
     return false;
   }

   /**
   *
   * @return The Distance from the end of route a to the beginning of route break;
   *   which includes the time to get between the two.
   */
   public static int spaceTimeDiff(Routes a, Routes b) {
     int diff = Intersection.getDistance(a.getFinishPos(), b.getStartPos());
     diff += b.getEarliest() - a.getLatest();
     // Check to see if a ends after the b starts
     if (a.getLatest() > b.getEarliest()) {
       diff += 900000;
     }
     //System.out.println("Difference: " + diff);

     return diff;
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
