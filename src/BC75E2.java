public class BC75E2 {

    // not working
    public static int triangularSum1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += (i + 1) * (nums[i] + nums[nums.length - 1 - i]);
        }
        if (nums.length % 2 == 1) sum += nums[nums.length / 2] * (nums.length + 1) / 2;
        return sum % 10;
    }

    public static int triangularSum2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] tmp = new int[nums.length];
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                tmp[j] = (nums[j] + nums[j + 1]) % 10;
            }
            System.arraycopy(tmp, 0, nums, 0, i);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(triangularSum2(new int[]{1, 2, 3, 4, 5}) == 8);
        System.out.println(triangularSum2(new int[]{5}) == 5);
    }
}
