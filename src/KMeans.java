import java.util.*;

public class KMeans {
    private int k;
    private List<Cluster> clusters;

    public KMeans(int k) {
        this.k = k;
        this.clusters = new ArrayList<>();
    }
    public void fit(List<Point> points) {
        initializeByRandomAssignment(points);

        boolean converged;
        do {
            for (Cluster cluster : clusters) {
                cluster.clearPoints();
            }
            for (Point p : points) {
                int cid = Helper.findClosestCluster(p, clusters);
                clusters.get(cid).addPoint(p);
                p.setClusterId(cid);
            }
            converged = true;
            for (int i = 0; i < k; i++) {
                Cluster c = clusters.get(i);
                Point newCentroid = c.calculateCentroid();
                if (!Arrays.equals(newCentroid.getCoordinates(), c.getCentroid().getCoordinates())) {
                    c.setCentroid(newCentroid);
                    converged = false;
                }
            }
        } while (!converged);
    }
    private void initializeByRandomAssignment(List<Point> points) {
        Random rnd = new Random();
        // 1)
        for (Point p : points) {
            p.setClusterId(rnd.nextInt(k));
        }
        // 2)
        Map<Integer, List<Point>> buckets = new HashMap<>();
        for (int i = 0; i < k; i++) {
            buckets.put(i, new ArrayList<>());
        }
        for (Point p : points) {
            buckets.get(p.getClusterId()).add(p);
        }
        for (int cid = 0; cid < k; cid++) {
            if (buckets.get(cid).isEmpty()) {
                int donor = (cid + 1) % k;
                Point moved = buckets.get(donor).remove(0);
                moved.setClusterId(cid);
                buckets.get(cid).add(moved);
            }
        }
        // 3)
        clusters.clear();
        for (int cid = 0; cid < k; cid++) {
            Point[] arr = buckets.get(cid).toArray(new Point[0]);
            Cluster c = new Cluster(Point.mean(arr));
            clusters.add(c);
        }
    }

    public List<Cluster> getClusters() {
        return clusters;
    }
}
