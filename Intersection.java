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
      return (b.h() - a.h()) +
      (b.v() - a.v());
    }
}
