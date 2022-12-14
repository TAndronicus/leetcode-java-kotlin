import java.util.HashMap;
import java.util.Map;

public class BC79E3 {
    public static long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> numbersOfRoads = new HashMap<>();
        for (int[] road : roads) {
            for (int city : road) {
                numbersOfRoads.put(city, numbersOfRoads.getOrDefault(city, 0) + 1);
            }
        }
        Integer[] numRoadsSorted = numbersOfRoads.values().stream().sorted().toArray(Integer[]::new);
        long maxImportance = 0, diff = n - numRoadsSorted.length;
        for (int i = 0; i < numRoadsSorted.length; i++) {
            maxImportance += numRoadsSorted[i] * (i + 1 + diff);
        }
        return maxImportance;
    }

    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}) == 43);
        System.out.println(maximumImportance(5, new int[][]{{0, 3}, {2, 4}, {1, 3}}) == 20);
        System.out.println(maximumImportance(5, new int[][]{{0, 1}}) == 9);
    }
}
