import java.util.Arrays;

public class Point {
    private final double[] coordinates;
    public Point(double[] coordinates) {
        this.coordinates = coordinates;
    }
    public double[] getCoordinates() {
        return coordinates;
    }
    public static double euclideanDistance(Point p1, Point p2) {
        double sum = 0.0;
        for (int i = 0; i < p1.coordinates.length; i++) {
            sum += Math.pow(p1.coordinates[i] - p2.coordinates[i], 2);
        }
        return Math.sqrt(sum);
    }
    public static Point mean(Point[] points){
        int dimensions = points[0].coordinates.length;
        double[] mean = new double[dimensions];
        for(Point p : points){
            for(int i = 0; i < dimensions; i++){
                mean[i] += p.coordinates[i];
            }
        }
        for(int i = 0; i < dimensions; i++){
            mean[i] /= dimensions;
        }
        return new Point(mean);
    }

    @Override
    public String toString() {
        return Arrays.toString(coordinates);
    }
}
