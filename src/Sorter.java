import java.util.Comparator;

class Sorter implements Comparator<Flower> {

    @Override
    public int compare(Flower o1, Flower o2) {
        return Double.compare(o1.getDistance(),o2.getDistance());
    }
}
