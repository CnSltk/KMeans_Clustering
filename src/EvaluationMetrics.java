import java.util.List;

public class EvaluationMetrics {
    public static double calculateWCSS(List<Cluster> clusters) {
        double wcss = 0.0;
        for (Cluster c : clusters) {
            Point centroid = c.getCentroid();
            for (Point p : c.getPoints()) {
                double d = Point.euclideanDistance(p, centroid);
                wcss += d * d;
            }
        }
        return wcss;
    }
}
