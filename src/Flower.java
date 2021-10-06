public class Flower {
    private String flowerName;
    private double distance;

    public Flower(double distance, String flowerName) {
        this.distance = distance;
        this.flowerName = flowerName;
    }

    public double getDistance() {return distance;}
    public String getFlowerName() {return flowerName;}
    public String toString() {return distance + ", " + flowerName;}
}
