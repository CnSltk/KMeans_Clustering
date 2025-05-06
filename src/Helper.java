import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {
    public static int findClosestCluster(Point p, List<Cluster> clusters) {
        double minDist = Double.MAX_VALUE;
        List<Integer> ties = new ArrayList<>();

        for (int i = 0; i < clusters.size(); i++) {
            double d = Point.euclideanDistance(p, clusters.get(i).getCentroid());
            if (d < minDist) {
                minDist = d;
                ties.clear();
                ties.add(i);
            } else if (Math.abs(d - minDist) < 1e-9) {
                ties.add(i);
            }
        }
        return ties.get(new Random().nextInt(ties.size()));
    }
}
