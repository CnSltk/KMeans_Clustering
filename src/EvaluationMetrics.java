import java.util.List;

public class EvaluationMetrics {
    public static double calculateWCSS(List<Cluster> clusters) {
        double wcss = 0.0;
        for (Cluster cluster : clusters) {
            for (Point point : cluster.getPoints()) {
                double distance = Point.euclideanDistance(point,cluster.getCentroid());
                wcss += Math.pow(distance,2);
            }
        }
        return wcss;
    }
}
