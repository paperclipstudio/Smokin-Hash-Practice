/**
*  @author George Sanger 947777
*  Created for Google Hash practice 2020
*  Ride Class holds information for one ride.
*/

public class Rides {
  private Intersection startPos
  private Intersection finishPos;
  private ArrayList<Ride> rides;

  public int getEarliest() {
        return rides.get(0).earliest;
    }

    public int getLatest() {
        return rides.get(rides.size()).latest;
    }

    public Intersection getStartPos() {
        return rides.get(0).startPos;
    }

    public Intersection getFinishPos() {
        return rides.get(0).finishPos;
    }


   /**
   * Returns the number of points that a Journy would get.
   * @param startTime Time since begining that the ride would begin.
   * @return The amount of points a ride would get if it would start
   * at the given start time.
   */
   public int getPoints(int startTime){
       int points = 0;
       int currentTime = startTime;
       Intersection currentPos = rides.get(0).startPos;

       for (Ride currentRide: rides) {
         currentTime += Ride.getDistance(currentPos, currentRide.getStartPos());
         points += currentRide.getPoints(currentTime);
         currentTime += currentRide.distance();
         currentPos = currentRide.getFinishPos;
       }


   }
   /**
   * Returns the Distance of a journey.
   * No side effects
   */
   public double distance() {
     return Math.sqrt(Math.pow(startPos[0] - startPos[1], 2));
   }
   /**
   * Returns the RideID of this ride
   */
   public int[] getRideIDs() {
     int[] rideIDlist = new int[rides.size()];
     for(int i = 0; i < rides.length();i++) {
       rideIDlist[i] = rides[i].getRideID()
     }

     return rideIDlist;
   }
}
