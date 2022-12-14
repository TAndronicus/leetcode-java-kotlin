import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WC270E1 {

    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < digits.length; j++) {
                if (i == j || (digits[j] % 2 != 0)) continue;
                for (int k = 0; k < digits.length; k++) {
                    if (j == k || k == i) continue;
                    integers.add(100 * digits[i] + 10 * digits[k] + digits[j]);
                }
            }
        }
        return integers.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(findEvenNumbers(new int[]{2, 1, 3, 0}), new int[]{102, 120, 130, 132, 210, 230, 302, 310, 312, 320}));
        System.out.println(Arrays.equals(findEvenNumbers(new int[]{2, 2, 8, 8, 2}), new int[]{222, 228, 282, 288, 822, 828, 882}));
        System.out.println(Arrays.equals(findEvenNumbers(new int[]{3, 7, 5}), new int[]{}));
        System.out.println(Arrays.equals(findEvenNumbers(new int[]{0, 2, 0, 0}), new int[]{200}));
        System.out.println(Arrays.equals(findEvenNumbers(new int[]{0, 0, 0}), new int[]{}));
    }
}
