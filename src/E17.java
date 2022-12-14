import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E17 {

    static Map<Character, List<String>> mappingsStr = Stream.of(
            Map.entry('2', List.of("a", "b", "c")),
            Map.entry('3', List.of("d", "e", "f")),
            Map.entry('4', List.of("g", "h", "i")),
            Map.entry('5', List.of("j", "k", "l")),
            Map.entry('6', List.of("m", "n", "o")),
            Map.entry('7', List.of("p", "q", "r", "s")),
            Map.entry('8', List.of("t", "u", "v")),
            Map.entry('9', List.of("w", "x", "y", "z"))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    static Map<Character, List<Character>> mappingsCh = Stream.of(
            Map.entry('2', List.of('a', 'b', 'c')),
            Map.entry('3', List.of('d', 'e', 'f')),
            Map.entry('4', List.of('g', 'h', 'i')),
            Map.entry('5', List.of('j', 'k', 'l')),
            Map.entry('6', List.of('m', 'n', 'o')),
            Map.entry('7', List.of('p', 'q', 'r', 's')),
            Map.entry('8', List.of('t', 'u', 'v')),
            Map.entry('9', List.of('w', 'x', 'y', 'z'))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        List<String> res = new ArrayList<>((int) Math.pow(3, digits.length()));
        for (char c : digits.toCharArray()) {
            if (res.isEmpty()) res = mappingsStr.get(c);
            else {
                res = res.stream()
                        .flatMap(prefix -> mappingsStr.get(c).stream()
                                .map(suffix -> prefix + suffix))
                        .collect(Collectors.toList());
            }
        }
        return res;
    }

//    public static List<String> letterCombinationsCh(String digits) {
//        if (digits.length() == 0) return Collections.emptyList();
//        int longer = 0;
//        for (char c : digits.toCharArray()) if (c == '7' || c == '9') longer++;
//        char[][] res = new char[(int)(Math.pow(3, digits.length() - longer) * Math.pow(4, longer))][digits.length()];
//        int offset = res.length;
//        for (int i = 0; i < digits.length(); i++) {
//            List<Character> characters = mappingsCh.get(digits.charAt(i));
//            offset /= characters.size();
//            for (int j = 0; j < characters.size(); j++) {
//                int hop =
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(containsSame(letterCombinations("23"), List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
        System.out.println(containsSame(letterCombinations(""), Collections.emptyList()));
        System.out.println(containsSame(letterCombinations("2"), List.of("a", "b", "c")));
    }

    private static boolean containsSame(List<String> l1, List<String> l2) {
        if (l1.size() != l2.size()) return false;
        return l1.containsAll(l2) && l2.containsAll(l1);
    }
}
