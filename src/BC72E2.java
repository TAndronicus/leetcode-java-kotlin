import java.util.Arrays;

public class BC72E2 {

    public static long[] sumOfThree(long num) {
        if (num % 3 != 0) return new long[]{};
        return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(sumOfThree(4), new long[]{}));
        System.out.println(Arrays.equals(sumOfThree(33), new long[]{10, 11, 12}));
    }
}
