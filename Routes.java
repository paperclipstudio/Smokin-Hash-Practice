import java.util.ArrayList;
import java.io.BufferedWriter;

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
        return rides.get(rides.size()).getLatest();
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
   public int distance() {
     return distance;
   }
   /**
   * Returns the RideID of this ride
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

}
