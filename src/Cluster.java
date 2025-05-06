import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private List<Point> points;
    private Point centroid;

    public Cluster(Point initialCentroid) {
        this.centroid = initialCentroid;
        this.points = new ArrayList<>();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public void clearPoints() {
        points.clear();
    }

    public Point calculateCentroid() {
        if (points.isEmpty()) return centroid;
        return Point.mean(points.toArray(new Point[0]));
    }

    public Point getCentroid() {
        return centroid;
    }

    public void setCentroid(Point centroid) {
        this.centroid = centroid;
    }

    public List<Point> getPoints() {
        return points;
    }
}
