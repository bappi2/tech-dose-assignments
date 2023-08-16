package recentInterview.inductiveHealth;
import java.util.List;

public class GasStations {

    public int optimalPoint(List<Integer> magic, List<Integer> dist) {
        int totalMagic = 0;
        int totalDist = 0;
        int currentTotal = 0;
        int start = 0;

        for (int i = 0; i < magic.size(); i++) {
            totalMagic += magic.get(i);
            totalDist += dist.get(i);
            currentTotal += magic.get(i) - dist.get(i);

            if (currentTotal < 0) {
                currentTotal = 0;
                start = i + 1;
            }
        }

        if (totalMagic < totalDist) {
            return -1; // No optimal point exists
        }

        return start;
    }

    public static void main(String[] args) {
        GasStations solution = new GasStations();

        // Example usage
        List<Integer> magic = List.of(8, 4, 1, 9);
        List<Integer> dist = List.of(10, 9, 3, 5);
        System.out.println(solution.optimalPoint(magic, dist));  // Output: -1
    }
}
