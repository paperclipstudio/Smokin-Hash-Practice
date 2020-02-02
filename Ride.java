 /**
 *  @author George Sanger 947777
 *  Created for Google Hash practice 2020
 *  Ride Class holds information for one ride.
 */

public class Ride {
    private Intersection startPos;
    private Intersection finishPos;
    private int earliest;
    private int latest;
    private final int rideID;
    private static int bonusPerRide;
    private static int numberOfCars;

    public Ride(
			int startHorizontal,
			int startVertical,
			int finishHorizontal,
			int finishVertical,
			int earliest,
			int latest,
			int rideID) {
        this.startPos = new Intersection(startHorizontal, startVertical);
        this.finishPos = new Intersection(finishHorizontal, finishVertical);
        this.earliest = earliest;
        this.latest = latest;
        this.rideID = rideID;
    }

     public int getEarliest() {
         return earliest;
     }

     public int getLatest() {
         return latest;
     }

     public Intersection getStartPos() {
         return startPos;
     }

     public Intersection getFinishPos() {
         return finishPos;
     }


    /**
    * Returns the number of points that a Ride would get.
    * @param startTime Time since begining that the ride would begin.
    * @return The amount of points a ride would get if it would start
    * at the given start time.
    */
    public int getPoints(int startTime){
        int points = 0;
        if (startTime < earliest) {
          return 0;
        }
        if (startTime == earliest) {
            points += bonusPerRide;
        }
        if (startTime + getDistance() <= latest) {
            points += getDistance();
        }
        return points;
    }
    /**
    * Returns the Distance of a journey.
    * No side effects
    */
    public int getDistance() {
      return Intersection.getDistance(startPos, finishPos);
    }
    /**
    * Returns the RideID of this ride
    */
    public int getRideID() {
      return rideID;
    }
    /**
    * Sets the bonus points for all rides
    */
    public static void setRideBonusPoints(int bonus) {
      bonusPerRide = bonus;
    }

    public static void setNumberOfCars(int cars) {
      numberOfCars = cars;
    }

    public static int getNumberOfCars() {
      return numberOfCars;
    }
}
