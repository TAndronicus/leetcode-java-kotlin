import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E22 {

    public static class Pair {
        String prefix;
        int value;
        int open;

        public Pair(String prefix, int value, int open) {
            this.prefix = prefix;
            this.value = value;
            this.open = open;
        }
    }

    public static List<String> generateParenthesis(int n) {
        Queue<Pair> pairs = new LinkedList<>();
        pairs.add(new Pair("(", 1, 1));
        List<String> res = new ArrayList<>();
        while (!pairs.isEmpty()) {
            Pair pair = pairs.remove();
            if (pair.open == n && pair.value == 1) res.add(pair.prefix + ")");
            else {
                if (pair.open < n) pairs.add(new Pair(pair.prefix + "(", pair.value + 1, pair.open + 1));
                if (pair.value > 0) pairs.add(new Pair(pair.prefix + ")", pair.value - 1, pair.open));
            }
        }
        return res;
    }

    public static List<String> generateParenthesis2(int n) {
//        if (n == 1) return List.of("()");
        List<String> res = new ArrayList<>();
        addRecursively(res, "(", 1, 1, n);
        return res;
    }

    public static void addRecursively(List<String> res, String current, int value, int open, int n) {
        if (open == n && value == 1) res.add(current + ")");
        else {
            if (open < n) addRecursively(res, current + "(", value + 1, open + 1, n);
            if (value > 0) addRecursively(res, current + ")", value - 1, open, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(containsSame(generateParenthesis(1), List.of("()")));
        System.out.println(containsSame(generateParenthesis(3), List.of("((()))", "(()())", "(())()", "()(())", "()()()")));
        System.out.println(containsSame(generateParenthesis2(1), List.of("()")));
        System.out.println(containsSame(generateParenthesis2(3), List.of("((()))", "(()())", "(())()", "()(())", "()()()")));
    }

    public static boolean containsSame(List<String> l1, List<String> l2) {
        if (l1.size() != l2.size()) return false;
        return l1.containsAll(l2) && l2.containsAll(l1);
    }

}
