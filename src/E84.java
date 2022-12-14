import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class E84 {
    public static int largestRectangleArea(int[] heights) {
        Map<Integer, Integer> lengthsOfHeights = new ConcurrentHashMap<>();
        int maxArea = 0;
        for (int height : heights) {
            int maxLength = 0;
            for (Integer key : lengthsOfHeights.keySet()) {
                if (key > height) {
                    Integer length = lengthsOfHeights.remove(key);
                    maxLength = Math.max(maxLength, length);
                    maxArea = Math.max(maxArea, length * key);
                } else {
                    lengthsOfHeights.compute(key, (__, v) -> v + 1);
                }
            }
            lengthsOfHeights.putIfAbsent(height, 1 + maxLength);
        }
        for (Map.Entry<Integer, Integer> entry : lengthsOfHeights.entrySet()) {
            maxArea = Math.max(maxArea, entry.getKey() * entry.getValue());
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1, 1, 1, 3, 4}) == 6);
        System.out.println(largestRectangleArea(new int[]{1, 1, 1, 4, 3}) == 6);
        System.out.println(largestRectangleArea(new int[]{1, 1, 1, 4, 3, 1, 1}) == 7);
        System.out.println(largestRectangleArea(new int[]{0}) == 0);
        System.out.println(largestRectangleArea(new int[]{1, 0, 1}) == 1);
        System.out.println(largestRectangleArea(new int[]{1, 2, 1, 0, 1, 2, 1}) == 3);
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}) == 10);
        System.out.println(largestRectangleArea(new int[]{2, 4}) == 4);
    }
}
