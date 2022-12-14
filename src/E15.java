import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class E15 {

    static class Tripple {
        private final int x;
        private final int y;
        private final int z;

        public Tripple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tripple tripple = (Tripple) o;
            return x == tripple.x && y == tripple.y && z == tripple.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }

        public List<Integer> asList() {
            return Arrays.asList(x, y, z);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        Set<Tripple> res = new HashSet<>();
        int x = 0, y = 1, z = nums.length - 1;
        while (true) {
            int sum = nums[x] + nums[y] + nums[z];
            if (sum == 0) {
                res.add(new Tripple(nums[x], nums[y], nums[z]));
            }
            if (x == nums.length - 3) break;
            else if (x == z - 2) {
                x++;
                y = x + 1;
                z = nums.length - 1;
            } else if (y < z - 1) {
                y++;
            } else {
                y = x + 1;
                z--;
            }
        }
        return res.stream()
                .map(Tripple::asList)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1, sum = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == sum) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
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

    public static void main(String[] args) {
        System.out.println(deepEqual2(threeSum(new int[]{-1, 0, 1, 2, -1, -4}), Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))));
        System.out.println(deepEqual2(threeSum(new int[]{}), Collections.emptyList()));
        System.out.println(deepEqual2(threeSum(new int[]{4}), Collections.emptyList()));
        System.out.println(deepEqual2(threeSum(new int[]{0, 0, 0}), Collections.singletonList(Arrays.asList(0, 0, 0))));
        System.out.println(deepEqual2(threeSum(new int[]{-1, 0, 1}), Collections.singletonList(Arrays.asList(-1, 0, 1))));
        System.out.println(deepEqual2(threeSum(new int[]{-2, -3, 0, 0, -2}), Collections.emptyList()));
//        listPrint(threeSum(new int[]{-2, -3, 0, 0, -2}));
        System.out.println("----------------------");
        System.out.println(deepEqual2(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}), Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))));
        System.out.println(deepEqual2(threeSum2(new int[]{}), Collections.emptyList()));
        System.out.println(deepEqual2(threeSum2(new int[]{4}), Collections.emptyList()));
        System.out.println(deepEqual2(threeSum2(new int[]{0, 0, 0}), Collections.singletonList(Arrays.asList(0, 0, 0))));
        System.out.println(deepEqual2(threeSum2(new int[]{-1, 0, 1}), Collections.singletonList(Arrays.asList(-1, 0, 1))));
        System.out.println(deepEqual2(threeSum2(new int[]{-2, -3, 0, 0, -2}), Collections.emptyList()));
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
