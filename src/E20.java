import java.util.Deque;
import java.util.LinkedList;

public class E20 {

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Deque<Character> characters = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                characters.offerLast(c);
            } else {
                Character last = characters.pollLast();
                if (last == null || (last != '(' && c == ')') || (last != '[' && c == ']') || (last != '{' && c == '}')) return false;
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(!isValid("(]"));
        System.out.println(!isValid("([(]))"));
        System.out.println(!isValid("((({)))}"));
        System.out.println(isValid("(([[{{}}]]))"));
        System.out.println(!isValid(")("));
    }

}
