import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BC79E1 {
    public static boolean digitCount(String num) {
        Map<Integer, Long> collect = Arrays.stream(num.split("")).collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()));
        return IntStream.range(0, num.length()).allMatch(index -> Long.valueOf(num.substring(index, index + 1)).equals(collect.get(index) == null ? 0 : collect.get(index)));
    }

    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(!digitCount("030"));
    }
}
