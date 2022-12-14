import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BC74E1 {

    public static boolean divideArray(int[] nums) {
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .allMatch(i -> i % 2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(!divideArray(new int[]{1, 2, 3, 4}));
    }
}
