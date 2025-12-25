import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        String fileName = input.nextLine();
        System.out.println("Enter the maximum number of cities allowed for supply: ");
        int numCities = input.nextInt();

        try {
            HashMap<String, HashSet<String>> roadNetwork = extract_city.extraction(fileName);
            System.out.println("\n Road Network ");
            for (String c : roadNetwork.keySet()) {
                System.out.println(c + " --> " + roadNetwork.get(c));
            }
            HashSet<String> supplyLocations = new HashSet<>();
            System.out.println("\nResult");
            if (allocateResources.resources(roadNetwork, numCities, supplyLocations)) {
                System.out.println("The region can be made disaster-ready.");
                System.out.println("Cities with supplies: " + supplyLocations);
            } else {
                System.out.println("Cannot make region disaster-ready with " + numCities + " supplyLocations cities.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
