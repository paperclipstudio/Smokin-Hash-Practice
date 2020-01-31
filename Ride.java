/**
*  @author George Sanger 947777
*  Created for Google Hash practice 2020
*  Ride Class holds information for one ride.
*/

public class Ride{
  private int[] startPos = new int[2];
  private int[] endPos = new int[2];
  private final int earlist;
  private final int latest;
  private final int rideID;
  private static int bonusPerRide;

  public Ride(int startX, int startY, int endX, int endY, int earlist, int latest, int rideID) {
      this.startPos[0] = startX;
      this.startPos[1] = startY;
      this.endPos[0] = endX;
      this.endPos[1] = endY;
      this.earlist = earlist;
      this.latest = latest;
      this.rideID = rideID;
    }
    /**
    * Returns the number of points that a Journy would get.
    * @param startTime Time since begining that the ride would begin.
    * @return The amount of points a ride would get if it would start
    * at the given start time.
    */
    public int getPoints(int startTime){
      int points = 0;
      if (startTime == earlist) {
        points += bonusPerRide;
      }
      if (startTime + distance() <= latest) {
        points += distance();
      }
      return points;
    }
    /**
    * Returns the Distance of a journey.
    * No side effects
    */
    public int distance() {
      return Math.sqrt(Math.pow(startPos[0] - startPos[1], 2));
    }
    /**
    * Returns the RideID of this ride
    */
    public int getRideID() {
      return rideID;
    }

    public setRideBonusPoints(int bonus) {
      bonusPerRide = bonus;
    }
}
