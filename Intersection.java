public class Intersection {
    private int horizontalStreet;
    private int verticalStreet;

    public Intersection(int horizontalStreet, int verticalStreet) {
        this.setHorizontalStreet(horizontalStreet);
        this.setVerticalStreet(verticalStreet);
    }

    public int getHorizontalStreet() {
        return horizontalStreet;
    }

    public void setHorizontalStreet(int horizontalStreet) {
        this.horizontalStreet = horizontalStreet;
    }

    public int getVerticalStreet() {
        return verticalStreet;
    }

    public void setVerticalStreet(int verticalStreet) {
        this.verticalStreet = verticalStreet;
    }
}
