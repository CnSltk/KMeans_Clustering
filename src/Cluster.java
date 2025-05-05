import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private List<Point> points;
    private Point centroid;

    public Cluster(Point initialCentroid) {
        this.centroid = initialCentroid;
        this.points = new ArrayList<Point>();
    }
    public void addPoint(Point point) {
        points.add(point);
    }
    public void cleaPoints() {
        points.clear();
    }
    public Point calculateCentroid() {
        if(points.isEmpty()) return centroid;
        Point newCentroid = Point.mean(points.toArray(new Point[0]));
        return newCentroid;
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
