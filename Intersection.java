/**
* @author Smokin'Hash
* Class that models a position on the grid based steets
*
*/

public class Intersection {
    private int horizontalStreet;
    private int verticalStreet;
    
    public Intersection(int horizontalStreet, int verticalStreet) {
        this.setHorizontalStreet(horizontalStreet);
        this.setVerticalStreet(verticalStreet);
    }

    public int h() {
        return horizontalStreet;
    }

    public void setHorizontalStreet(int horizontalStreet) {
        this.horizontalStreet = horizontalStreet;
    }

    public int v() {
        return verticalStreet;
    }

    public void setVerticalStreet(int verticalStreet) {
        this.verticalStreet = verticalStreet;
    }

    public static int getDistance(Intersection a, Intersection b) {
      int distance = 0;
      if (a.h() > b.h()) {
        distance += a.h() - b.h();
      } else {
        distance += b.h() - a.h();
      }

      if (a.v() > b.v()) {
        distance += a.v() - b.v();
      } else {
        distance += b.v() - a.v();
      }
      return distance;
    }
}
