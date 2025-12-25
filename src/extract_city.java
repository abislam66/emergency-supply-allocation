import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class extract_city {
    public static HashMap<String, HashSet<String>> extraction(String file) throws FileNotFoundException {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(":");
            String city = parts[0].trim();
            HashSet<String> neighbors = new HashSet<>();
            if (parts.length > 1) {
                String[] entries = parts[1].split(",");
                for (String entry : entries) {
                    String neighbor = entry.split("\\(")[0].trim();
                    if (!neighbor.isEmpty()) {
                        neighbors.add(neighbor);
                    }
                }
            }

            map.putIfAbsent(city, new HashSet<>());
            map.get(city).addAll(neighbors);

            // Add reverse edges
            for (String n : neighbors) {
                map.putIfAbsent(n, new HashSet<>());
                map.get(n).add(city);
            }
        }
        sc.close();
        return map;
    }
}
