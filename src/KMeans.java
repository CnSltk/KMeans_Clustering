import java.util.*;

public class KMeans {
    private int k;
    private List<Cluster> clusters;
    public KMeans(int k) {
        this.k = k;
        this.clusters = new ArrayList<>();
    }
    public void fit(List<Point> points) {
        Collections.shuffle(points);
        Set<Integer> chosenIndices = new HashSet<>();
        Random rand = new Random();
        while (clusters.size() < k){
            int index = rand.nextInt(points.size());
            if (!chosenIndices.contains(index)){
                clusters.add(new Cluster(points.get(index)));
                chosenIndices.add(index);
            }
        }
        boolean converged;
        do{
            for(Cluster cluster : clusters) cluster.cleaPoints();
            for (Point point : points){
                Cluster closest = null;
                double minDistance = Double.MAX_VALUE;
                for(Cluster cluster : clusters){
                    double distance = Point.euclideanDistance(point, cluster.getCentroid());
                    if(distance < minDistance){
                        minDistance = distance;
                        closest = cluster;
                    }
                }
                closest.addPoint(point);
            }
            converged = true;
            for(Cluster cluster : clusters){
                Point newCentroid = cluster.calculateCentroid();
                if (!Arrays.equals(newCentroid.getCoordinates(),cluster.getCentroid().getCoordinates())) {
                    cluster.setCentroid(newCentroid);
                    converged = false;
                }
            }
        }while (!converged);
    }
    public List<Cluster> getClusters() {
        return clusters;
    }
}
