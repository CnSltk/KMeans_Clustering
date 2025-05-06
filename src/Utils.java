import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {
    public static void saveClustersToCSV(List<Cluster> clusters, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Cluster c : clusters) {
                for (Point p : c.getPoints()) {
                    for (double v : p.getCoordinates()) {
                        writer.write(v + ",");
                    }
                    writer.write(p.getClusterId() + "\n");
                }
            }
        }
    }
}
