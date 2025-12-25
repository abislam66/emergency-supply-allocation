import java.util.HashMap;
import java.util.HashSet;

public class allocateResources {

    public static boolean resources(HashMap<String, HashSet<String>> roadNetwork, int numCities, HashSet<String> supplyLocations) {
        HashSet<String> covered = new HashSet<>();
        return helper.solve(roadNetwork, numCities, supplyLocations, covered);
    }
}
