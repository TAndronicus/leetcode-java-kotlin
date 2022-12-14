import java.util.Arrays;

public class E16 {

    public static int threeSumClosest(int[] nums, int target) {
        int currentClosest = nums[0] + nums[1] + nums[2], currentDiff = Math.abs(currentClosest - target);
        if (nums.length == 3) return currentClosest;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (sum - target < currentDiff) {
                        currentDiff = sum - target;
                        currentClosest = sum;
                    }
                    k--;
                } else {
                    if (target - sum < currentDiff) {
                        currentDiff = target - sum;
                        currentClosest = sum;
                    }
                    j++;
                }
            }
        }
        return currentClosest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2);
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1) == 0);
        System.out.println(threeSumClosest(new int[]{0, 1, 2, 4, 8}, 7) == 7);
        System.out.println(threeSumClosest(new int[]{0, 1, 2, 4, 8}, 8) == 9);
    }
}
