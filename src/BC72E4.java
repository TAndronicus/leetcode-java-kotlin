import java.util.HashMap;
import java.util.Map;

public class BC72E4 {

    public static long goodTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) positions.put(nums2[i], i);
        long counter = 0;
        for (int i = 0; i < nums1.length - 2; i++) {
            for (int j = i + 1; j < nums1.length - 1; j++) {
                if (positions.get(nums1[i]) > positions.get(nums1[j])) continue;
                for (int k = j + 1; k < nums1.length; k++) {
                    if (positions.get(nums1[j]) < positions.get(nums1[k])) counter++;
                }
            }
        }
        return counter;
    }

    public static long goodTriplets2(int[] nums1, int[] nums2) {
        long count = 0;
        Map<Integer, Integer> positions1 = new HashMap<>(), positions2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            positions1.put(nums1[i], i);
            positions2.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length - 1; i++) {
            int diff = Math.abs(positions1.get(i) - positions2.get(i));
            if (i - diff < 3) continue;
            if (count == 0) {
                count = i - diff - 2;
            } else {
                count = count * (i - diff - 2);
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(goodTriplets(new int[]{2,0,1,3}, new int[]{0,1,2,3}) == 1L);
//        System.out.println(goodTriplets(new int[]{4,0,1,3,2}, new int[]{4,1,0,2,3}) == 4L);
//        System.out.println(goodTriplets2(new int[]{2,0,1,3}, new int[]{0,1,2,3}) == 1L);
        System.out.println(goodTriplets2(new int[]{2, 0, 1, 3}, new int[]{0, 1, 2, 3}));
//        System.out.println(goodTriplets2(new int[]{4,0,1,3,2}, new int[]{4,1,0,2,3}) == 4L);
    }

}
