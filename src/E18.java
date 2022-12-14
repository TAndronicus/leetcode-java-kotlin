import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class E18 {

    public static List<List<Integer>> threeSum(int[] nums, int target, int carry) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (target > 0 && nums[i] > target) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1, sum = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == sum) {
                    res.add(List.of(carry, nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > sum) k--;
                else j++;
            }
        }
        return res;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (target > 0 && nums[i] > target) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            res.addAll(threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i], nums[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(deepEqual2(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0), List.of(List.of(-2, -1, 1, 2), List.of(-2, 0, 0, 2), List.of(-1, 0, 0, 1))));
        System.out.println(deepEqual2(fourSum(new int[]{2, 2, 2, 2, 2}, 8), List.of(List.of(2, 2, 2, 2))));
        System.out.println(deepEqual2(fourSum(new int[]{0}, 1), Collections.emptyList()));
        System.out.println(deepEqual2(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11), List.of(List.of(-5, -4, -3, 1))));
    }

    public static void listPrint(List<List<Integer>> l) {
        for (List<Integer> inner : l) {
            System.out.println(String.join(", ", inner.stream().map(Object::toString).collect(Collectors.toList())) + "\n");
        }
    }

    public static boolean deepEqual2(List<List<Integer>> l1, List<List<Integer>> l2) {
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!deepEqual1(l1.get(i), l2.get(i))) return false;
        }
        return true;
    }

    public static boolean deepEqual1(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!Objects.equals(l1.get(i), l2.get(i))) return false;
        }
        return true;
    }
}
