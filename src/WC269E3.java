public class WC269E3 {

    public static int minimumDeletions(int[] nums) {
        if (nums.length < 3) return nums.length;
        int indexMin = 0, indexMax = 0, min = 100_001, max = -100_001;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                indexMin = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                indexMax = i;
            }
        }
        int minToRemove = Math.min(indexMin + 1, nums.length - indexMin);
        int maxToRemove = Math.min(indexMax + 1, nums.length - indexMax);
        if (minToRemove < maxToRemove) {
            boolean fromFront = indexMin < nums.length / 2;
            int newLength = nums.length - minToRemove, newIndexMax = fromFront ? (indexMax - minToRemove) : indexMax;
            return Math.min(newIndexMax + 1, newLength - newIndexMax) + minToRemove;
        } else {
            boolean fromFront = indexMax < nums.length / 2;
            int newLength = nums.length - maxToRemove, newIndexMin = fromFront ? (indexMin - maxToRemove) : indexMin;
            return Math.min(newIndexMin + 1, newLength - newIndexMin) + maxToRemove;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}) == 5);
        System.out.println(minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
        System.out.println(minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}) == 3);
        System.out.println(minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}));
        System.out.println(minimumDeletions(new int[]{101}) == 1);
        System.out.println(minimumDeletions(new int[]{101}));
        System.out.println(minimumDeletions(new int[]{1, 2, 0, 5, 3, 4}));
        System.out.println(minimumDeletions(new int[]{48, -49, -67, 18, -59, -56, 47, -26, -24, -73, -96, 27, -2, -45}) == 5);
        System.out.println(minimumDeletions(new int[]{41, -47, -26, 57, 82, -23, 47, 52, 42, 79, 2, 77, 0, -4, 1, -99, -57, 72, -95}) == 9);
    }
}
