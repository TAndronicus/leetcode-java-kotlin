import java.util.function.BiFunction;

public class E28 {

    public static int strStrBrute(String haystack, String needle) { // 2603 ms
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean matched = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    matched = false;
                    break;
                }
            }
            if (matched) return i;
        }
        return -1;
    }

    public static int strStrBuiltin(String haystack, String needle) { // 271 ms
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        BiFunction<String, String, Integer> underTest = E28::strStrBuiltin;
        System.out.println(underTest.apply("hello", "ll") == 2);
        System.out.println(underTest.apply("aaaaa", "bba") == -1);
        System.out.println(underTest.apply("", "") == 0);
        System.out.println(underTest.apply("aaaaaa", "a") == 0);
        System.out.println(underTest.apply("aa", "aaa") == -1);
        System.out.println(underTest.apply("a", "a") == 0);
        System.out.println(underTest.apply("aaabbbccc", "ccc") == 6);
    }
}
