import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BC72E3 {

    public static List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) return Collections.emptyList();
        long summand = 2;
        List<Long> res = new ArrayList<>();
        while (true) {
            if (finalSum > 2 * summand) {
                res.add(summand);
                finalSum -= summand;
                summand += 2;
            } else {
                res.add(finalSum);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(containsSame(maximumEvenSplit(12), List.of(2L, 4L, 6L)));
        System.out.println(containsSame(maximumEvenSplit(7), Collections.emptyList()));
        System.out.println(containsSame(maximumEvenSplit(28), List.of(2L, 4L, 6L, 16L)));
    }

    public static boolean containsSame(List<Long> l1, List<Long> l2) {
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!Objects.equals(l1.get(i), l2.get(i))) return false;
        }
        return true;
    }
}
