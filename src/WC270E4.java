import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class WC270E4 {

    public static int[][] validArrangement(int[][] pairs) {
        List<int[]> ints = Arrays.asList(pairs);
        for (int[] pair : pairs) {
            Deque<int[]> route = new LinkedList<>();
            route.offerLast(pair);
            List<int[]> newLeft = new ArrayList<>(ints);
            newLeft.remove(pair);
            Deque<int[]> deque = findRecursively(route, newLeft);
            if (deque != null) return toArray(deque);
        }
        return null;
    }

    public static Deque<int[]> findRecursively(Deque<int[]> currentRoute, List<int[]> left) {
        if (left.isEmpty()) return currentRoute;
        int[] lastPair = currentRoute.getLast();
        for (int[] pair : left) {
            if (pair[0] == lastPair[1]) {
                Deque<int[]> newCurrent = new LinkedList<>(currentRoute);
                newCurrent.offerLast(pair);
                List<int[]> newLeft = new ArrayList<>(left);
                newLeft.remove(pair);
                Deque<int[]> deque = findRecursively(newCurrent, newLeft);
                if (deque != null) return deque;
            }
        }
        return null;
    }

    public static int[][] toArray(Deque<int[]> deque) {
        int[][] res = new int[deque.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.removeFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(validArrangement(new int[][]{{5, 1}, {4, 5}, {11, 9}, {9, 4}})));
        System.out.println(Arrays.deepToString(validArrangement(new int[][]{{1, 3}, {3, 2}, {2, 1}})));
        System.out.println(Arrays.deepToString(validArrangement(new int[][]{{1, 2}, {1, 3}, {2, 1}})));
    }
}
