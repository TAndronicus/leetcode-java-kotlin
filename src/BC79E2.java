import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BC79E2 {
    public static String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            int length = messages[i].split(" ").length;
            counts.merge(senders[i], length, Integer::sum);
        }
        return counts.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).thenComparing(Map.Entry::getKey).reversed())
                .findFirst().get().getKey();
    }

    public static void main(String[] args) {
        System.out.println(largestWordCount(new String[]{"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"}, new String[]{"Alice", "userTwo", "userThree", "Alice"}).equals("Alice"));
        System.out.println(largestWordCount(new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"}, new String[]{"Bob", "Charlie"}).equals("Charlie"));
    }
}
