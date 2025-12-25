import java.util.HashMap;
import java.util.HashSet;

public class helper {
    public static boolean solve(HashMap<String, HashSet<String>> roadNetwork, int maxSupplies, HashSet<String> supplyLocations, HashSet<String> covered) {
        // If all cities covered
        boolean allCovered = true;
        for (String city : roadNetwork.keySet()) {
            if (!covered.contains(city)) {
                allCovered = false;
                break;
            }
        }
        if (allCovered) return true;

        // Find first uncovered city

        String target = null;
        for (String city : roadNetwork.keySet()) {
            if (!covered.contains(city)) {
                target = city;
                break;
            }
        }

        // Choices = target && neighbors
        HashSet<String> choices = new HashSet<>();
        choices.add(target);
        choices.addAll(roadNetwork.get(target));
        // Try each choice
        for (String choice : choices) {
            // If this would exceed stockpile count, skip
            if (!supplyLocations.contains(choice) &&
                    supplyLocations.size() == maxSupplies) {
                continue;
            }

            // Determine what this choice newly covers
            HashSet<String> newlyCovered = new HashSet<>();
            newlyCovered.add(choice);
            newlyCovered.addAll(roadNetwork.get(choice));

            // Apply choice
            supplyLocations.add(choice);
            for (String c : newlyCovered) {
                covered.add(c);
            }

            // Recurse
            if (solve(roadNetwork, maxSupplies, supplyLocations, covered)) {
                return true;
            }

            // BACKTRACK
            supplyLocations.remove(choice);
            for (String c : newlyCovered) {
                // Only remove if not covered by another supply
                boolean stillCovered = false;
                for (String otherSupply : supplyLocations) {
                    if (otherSupply.equals(c) ||
                            roadNetwork.get(otherSupply).contains(c)) {
                        stillCovered = true;
                        break;
                    }
                }
                if (!stillCovered) covered.remove(c);
            }
        }

        return false;
    }
}
